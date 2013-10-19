package model.expression;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import Exceptions.SlogoException;
import model.Model;
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
    public DoTimesExpression(List<String> cmdList, Model model) throws SlogoException{
        super(model);
        limitExpression = new ArrayList<Expression>();
        commandExpression = new ArrayList<Expression>();
        convert(cmdList);
    }

    @Override
    public void convert (List<String> cmdList) throws SlogoException {
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
        variableExpression = new VariableExpression(new ArrayList<String>(cmdList.subList(1, 2)), model); // assuming just on variable
        List<String> limits = new ArrayList<String>(cmdList.subList(openBracketIndex+2, closeBracketIndex));
        while(!limits.isEmpty()){
            limitExpression.add(parser.parse(limits));
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
            commandExpression.add(parser.parse(commands));
        }

        for(int i = 0; i <= closeBracketIndex; i++){
            cmdList.remove(0);
        }
    }

    public List<TurtleCommand> createTurtleCommands (TurtleCommand turtleCmd) throws SlogoException {
        List<TurtleCommand> commandList = new ArrayList<TurtleCommand>();

        // create local variable :i from 0 to limit
        localVariables.put(variableExpression.getId(), new NumberExpression(0, model));
        NumberExpression limit = (NumberExpression) limitExpression.get(0).evaluate().get(0); //Assuming get a NumberExpression

        NumberExpression variableNumber = (NumberExpression) localVariables.get(variableExpression.getId());

        TurtleCommand latestTurtleCommand = turtleCmd;

        while(variableNumber.getNumber() < limit.getNumber()){
            
            for(Expression expression : commandExpression){
                List<TurtleCommand> turtleCmds = expression.createTurtleCommands(latestTurtleCommand);
                if(turtleCmds.size() != 0) {  //if call another fun inside the fun, no Cmds reutrn
                    latestTurtleCommand = turtleCmds.get(turtleCmds.size() -1);
                }
                commandList.addAll(turtleCmds);
            }


            localVariables.put(variableExpression.getId(), variableNumber.sum(new NumberExpression(1, model)));
            variableNumber = (NumberExpression) localVariables.get(variableExpression.getId());
        }

        localVariables.clear();

        return commandList;
    }


}
