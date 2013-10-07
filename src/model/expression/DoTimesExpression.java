package model.expression;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import model.parser.DefaultParser;
import controller.TurtleCommand;

public class DoTimesExpression extends ScopedExpression {

    VariableExpression variableExpression; //Assuming just one variable
    List<Expression> limitExpression; //limit

    List<Expression> commandExpression; //command(s)


    /*
     * DOTIMES [ variable limit ] [ command(s) ]
     * 
     * DOTIMES [ :i sum 1 3 ] [ fd 23 fd 23 ]
     * 
     * runs the commands for each value specified in the range, i.e., from 0 up to (limit - 1). 
     * note, variable is assigned to each succeeding value so that it can be accessed by the commands
     * 
     */
    public DoTimesExpression(List<String> cmdList){
        limitExpression = new ArrayList<Expression>();
        commandExpression = new ArrayList<Expression>();
        convert(cmdList);
    }

    @Override
    public void convert (List<String> cmdList) {
        cmdList.remove(0);

        int openBracketIndex = -1;
        int closeBracketIndex = -1;
        int bracketNumber = 0;

        //Find [ variable limit ]
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

        //Within [ variable limit ]
        variableExpression = new VariableExpression(new ArrayList<String>(cmdList.subList(1, 2))); // assuming just on variable
        List<String> limits = new ArrayList<String>(cmdList.subList(openBracketIndex+2, closeBracketIndex));
        while(!limits.isEmpty()){
            limitExpression.add(DefaultParser.parse(limits));
        }


        //Remove [ variable limit ]
        for(int i = openBracketIndex; i <= closeBracketIndex; i++){
            cmdList.remove(0);
        }

        openBracketIndex = -1;
        closeBracketIndex = -1;
        bracketNumber = 0;

        //Within [ command(s) ]
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

        List<String> commands = new ArrayList<String>(cmdList.subList(openBracketIndex+1, closeBracketIndex));
        while(!commands.isEmpty()){
            commandExpression.add(DefaultParser.parse(commands));
        }

        for(int i = 0; i <= closeBracketIndex; i++){
            cmdList.remove(0);
        }
    }

    public List<TurtleCommand> createTurtleCommands (TurtleCommand turtleCmd) {
        List<TurtleCommand> commandList = new ArrayList<TurtleCommand>();

        // create local variable :i from 0 to limit
        ScopedExpression.getLocalVariables().put(variableExpression.getId(), new NumberExpression(0));
        NumberExpression limit = (NumberExpression) limitExpression.get(0).evaluate().get(0); //Assuming get a NumberExpression

        NumberExpression variableNumber = (NumberExpression) ScopedExpression.getLocalVariables().get(variableExpression.getId());

        TurtleCommand latestTurtleCommand = turtleCmd;

        while(variableNumber.getNumber() < limit.getNumber()){
            
            for(Expression expression : commandExpression){
                List<TurtleCommand> turtleCmds = expression.createTurtleCommands(latestTurtleCommand);
                if(turtleCmds.size() != 0) {  //if call another fun inside the fun, no Cmds reutrn
                    latestTurtleCommand = turtleCmds.get(turtleCmds.size() -1);
                }
                commandList.addAll(turtleCmds);
            }


            ScopedExpression.getLocalVariables().put(variableExpression.getId(), variableNumber.sum(new NumberExpression(1)));
            variableNumber = (NumberExpression) ScopedExpression.getLocalVariables().get(variableExpression.getId());
        }

        ScopedExpression.getLocalVariables().clear();

        return commandList;
    }


}
