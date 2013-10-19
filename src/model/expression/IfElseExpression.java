package model.expression;

import java.util.ArrayList;
import java.util.List;
import Exceptions.SlogoException;
import controller.TurtleCommand;
import model.Model;
import model.parser.DefaultParser;

public class IfElseExpression extends Expression {

    Expression conditionExpression; //assuming one expression
    List<Expression> ifCommandExpression;
    List<Expression> elseCommandExpression;
    
    /*
     * IFELSE expr [ trueCommand(s) ]  [ falseCommand(s) ]
     * if lessp 2 3 [ fd sum 1 2 ] [ fd sum 1 sum 1 2 ]
     */
    
    public IfElseExpression(List<String> cmdList, Model model) throws SlogoException{
        super(model);
        ifCommandExpression = new ArrayList<Expression>();
        elseCommandExpression = new ArrayList<Expression>();
        convert(cmdList);
    }
    
    @Override
    public void convert (List<String> cmdList) throws SlogoException {
        cmdList.remove(0); // remove if

        int openBracketIndex = -1;
        int closeBracketIndex = -1;
        int bracketNumber = 0;

        //Within [ ifCommand ]
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

        
        
        conditionExpression = parser.parse(new ArrayList<String>(cmdList.subList(0, openBracketIndex)));

      //Within [ ifCommand ]
        List<String> ifCommand = new ArrayList<String>(cmdList.subList(openBracketIndex+1, closeBracketIndex));
        while(!ifCommand.isEmpty()){
            ifCommandExpression.add(parser.parse(ifCommand));
        }
        
        
        // remove   expr  [ ifCommand ]
        for(int i = 0; i <= closeBracketIndex; i++){
            cmdList.remove(0);
        }

        openBracketIndex = -1;
        closeBracketIndex = -1;
        bracketNumber = 0;

        //Within [ elseCommand ]
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

        List<String> elseCommands = new ArrayList<String>(cmdList.subList(openBracketIndex+1, closeBracketIndex));
        while(!elseCommands.isEmpty()){
            elseCommandExpression.add(parser.parse(elseCommands));
        }

        for(int i = 0; i <= closeBracketIndex; i++){
            cmdList.remove(0);
        }
    }

    @Override
    public List<Expression> evaluate () {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public List<TurtleCommand> createTurtleCommands(TurtleCommand turtleCommand) throws SlogoException {

        List<TurtleCommand> commandList = new ArrayList<TurtleCommand>();

        NumberExpression condition = (NumberExpression) conditionExpression.evaluate().get(0);
        if(condition.getNumber() == 1) {
            commandList = makeTurtleCommands(ifCommandExpression, turtleCommand);
        } else {
            commandList = makeTurtleCommands(elseCommandExpression, turtleCommand);
        }
        return commandList;
    }
    
    public List<TurtleCommand> makeTurtleCommands(List<Expression> commandExpression, TurtleCommand turtleCommand) throws SlogoException {
        
        List<TurtleCommand> commandList = new ArrayList<TurtleCommand>();
        TurtleCommand latestTurtleCommand = turtleCommand;
        for (Expression expression : ifCommandExpression) {
            
                List<TurtleCommand> turtleCmds = expression.createTurtleCommands(latestTurtleCommand);
                if(turtleCmds.size() != 0) {  //if call another fun inside the fun, no Cmds reutrn
                    latestTurtleCommand = turtleCmds.get(turtleCmds.size() -1);
                }
                commandList.addAll(turtleCmds);
        }
        
        return commandList;
        
    }

}
