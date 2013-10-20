package model.expression;

import java.util.ArrayList;
import java.util.List;
import controller.TurtleCommand;
import model.Model;
import Exceptions.SlogoException;

public class AskExpression extends Expression {
    
    private ArrayList<String> turtleIds;
    List<Expression> expressions;


    public AskExpression(List<String> cmdList, Model model) throws SlogoException{
        super(model);
        turtleIds = new ArrayList<String>();
        expressions = new ArrayList<Expression>();
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

        //Within [ :count ]
        for(int i = openBracketIndex+1; i < closeBracketIndex; i++){
            turtleIds.add(cmdList.get(i));
        }


        //Remove [ :count ]
        cmdList.remove(0); // remove [
        cmdList.remove(0); // remove ]
        /*for(int i = openBracketIndex; i <= closeBracketIndex; i++){
            cmdList.remove(0);
        }*/

        openBracketIndex = -1;
        closeBracketIndex = -1;
        bracketNumber = 0;

        //With [ ... ]
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

        List<String> expressionCmdList = new ArrayList<String>(cmdList.subList(openBracketIndex+1, closeBracketIndex));
        while(!expressionCmdList.isEmpty()){
            expressions.add(parser.parse(expressionCmdList));
        }

        for(int i = 0; i <= closeBracketIndex; i++){
            cmdList.remove(0);
        }

    }
    
    public List<TurtleCommand> createTurtleCommands(TurtleCommand turtleCommand) throws SlogoException {
        
        //Before making turtle commands, set specific active turtles
        model.getController().getCurrentWorkspace().setActiveTurtle(turtleIds);
        
        //Now execute all the commands and make the turtleCommands
        List<TurtleCommand> commandList = new ArrayList<TurtleCommand>();
        
        TurtleCommand latestTurtleCommand = turtleCommand;

        for (Expression expression : expressions) {
//            List<Expression> evaluatedExpressions = expression.evaluate();
//            for (Expression evalExpression : evaluatedExpressions) {
                List<TurtleCommand> turtleCmds = expression.createTurtleCommands(latestTurtleCommand);
                if(turtleCmds.size() != 0) {  //if call another fun inside the fun, no Cmds return
                    latestTurtleCommand = turtleCmds.get(turtleCmds.size() -1);
                }
                commandList.addAll(turtleCmds);
//            }
        }
                
        return commandList;
    }

}
