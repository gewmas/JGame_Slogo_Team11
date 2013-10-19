package model.expression;

import java.util.ArrayList;
import java.util.List;
import Exceptions.SlogoException;
import controller.TurtleCommand;
import model.Model;
import model.parser.DefaultParser;

public class RepeatExpression extends ScopedExpression {
    Expression variableExpression;
    //    Expression expression2;
    List<Expression> commandExpression;

    public RepeatExpression(List<String> cmdList, Model model) throws SlogoException{
        super(model);
        commandExpression = new ArrayList<Expression>();
        convert(cmdList);
    }

    @Override
    public void convert (List<String> cmdList) throws SlogoException {
        cmdList.remove(0);

        int openBracketIndex = -1;
        int closeBracketIndex = -1;
        int bracketNumber = 0;

        for(int i = 0; i < cmdList.size(); i++){
            if(cmdList.get(i).equals("[")){
                if(openBracketIndex == -1){
                    openBracketIndex = i;
                }
                bracketNumber++;
            }else if(cmdList.get(i).equals("]")){
                bracketNumber--;
                if(bracketNumber == 0){
                    closeBracketIndex = i;
                    break;
                }
            }
        }

        try
        {
            variableExpression = new NumberExpression(Double.parseDouble(cmdList.get(0)), model);
            //            cmdList.remove(0);
        }
        catch(NumberFormatException e)
        {
            variableExpression = parser.parse(new ArrayList<String>(cmdList.subList(0, openBracketIndex)));
        }

        //        expression1 = DefaultParser.parse(new ArrayList<String>(cmdList.subList(0, openBracketIndex)));

        List<String> expression2CmdList = new ArrayList<String>(cmdList.subList(openBracketIndex+1, closeBracketIndex));
        while(!expression2CmdList.isEmpty()){
            commandExpression.add(parser.parse(expression2CmdList));
        }

        for(int i = 0; i <= closeBracketIndex; i++){
            cmdList.remove(0);
        }

        //        cmdList = cmdList.subList(closeBracketIndex+1, cmdList.size());

    }

    /*@Override
    // Must think about whether expressions being evaluated can check for variables defined outside of repeat scope!
    public List<Expression> evaluate() {
    	NumberExpression repeatNumberExp = (NumberExpression) expression1.evaluate().get(0);
    	// For number of specified repeats, execute the commands within repeat brackets
    	List<Expression> finalExpressionList = new ArrayList<Expression>();
    	for (int i = 0; i < repeatNumberExp.getNumber(); i++) {	
    		for (Expression expression : expression2) {
    			finalExpressionList.addAll(expression.evaluate());
			}
		}
    	return finalExpressionList;
    }*/

    public List<TurtleCommand> createTurtleCommands (TurtleCommand turtleCmd) {
        List<TurtleCommand> commandList = new ArrayList<TurtleCommand>();
        NumberExpression repeatNumberExp = (NumberExpression) variableExpression.evaluate().get(0); //Assume variable is NumberExpression

        TurtleCommand latestTurtleCommand = turtleCmd;

        for (int i = 0; i < repeatNumberExp.getNumber(); i++) { 
            for(Expression expression : commandExpression){
                List<TurtleCommand> turtleCmds = expression.createTurtleCommands(latestTurtleCommand);
                if(turtleCmds.size() != 0) {  //if call another fun inside the fun, no Cmds reutrn
                    latestTurtleCommand = turtleCmds.get(turtleCmds.size() -1);
                }
                commandList.addAll(turtleCmds);
            }
        }


        return commandList;

    }

}
