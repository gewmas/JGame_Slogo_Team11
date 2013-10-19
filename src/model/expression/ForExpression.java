package model.expression;

import java.util.ArrayList;
import java.util.List;
import Exceptions.SlogoException;
import controller.TurtleCommand;
import model.Model;
import model.parser.DefaultParser;

public class ForExpression extends ScopedExpression{
    
    VariableExpression variableExpression; //Assuming just one variable
    Expression startExpression;
    Expression endExpression;
    Expression incrementExpression;
    
    List<Expression> commandExpression; //command(s)

    /*
     * FOR [ variable start end increment ] [ command(s) ]
     * 
     * for [ :i sum 1 3 sum 1 3 sum 1 3 ] [  fd 23 fd 23 ]
     * 
     */
    public ForExpression(List<String> cmdList, Model model) throws SlogoException{
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

        // Find [ variable start end increment ]
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

        //Within [ variable start end increment ]
        variableExpression = new VariableExpression(new ArrayList<String>(cmdList.subList(1, 2)), model); // assuming just on variable
        cmdList.remove(0); // remove [
        cmdList.remove(0); // remove variable
        
        //condition
        try
        {
            startExpression = new NumberExpression(Double.parseDouble(cmdList.get(0)), model);
            cmdList.remove(0);
        }
        catch(NumberFormatException e)
        {
            startExpression = parser.parse(cmdList);
        }
        
        try
        {
            endExpression = new NumberExpression(Double.parseDouble(cmdList.get(0)), model);
            cmdList.remove(0);
        }
        catch(NumberFormatException e)
        {
            endExpression = parser.parse(cmdList);
        }
        
        try
        {
            incrementExpression = new NumberExpression(Double.parseDouble(cmdList.get(0)), model);
            cmdList.remove(0);
        }
        catch(NumberFormatException e)
        {
            incrementExpression = parser.parse(cmdList);
        }
        
//        startExpression = DefaultParser.parse(cmdList);
//        
//        endExpression = DefaultParser.parse(cmdList);
//        
//        incrementExpression = DefaultParser.parse(cmdList);
        
        cmdList.remove(0); // remove ]  

        
        
        // --------------------------

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

    public List<TurtleCommand> createTurtleCommands (TurtleCommand turtleCmd) {
        List<TurtleCommand> commandList = new ArrayList<TurtleCommand>();
        
        // assuming not changing afterwards
        NumberExpression start = (NumberExpression) startExpression.evaluate().get(0);
        NumberExpression end = (NumberExpression) endExpression.evaluate().get(0);
        NumberExpression increment = (NumberExpression) incrementExpression.evaluate().get(0);
        
        // create local variable
        localVariables.put(variableExpression.getId(), start);
        
        NumberExpression variableNumber = (NumberExpression) localVariables.get(variableExpression.getId());
        TurtleCommand latestTurtleCommand = turtleCmd;
        
        
        //for (:i = start, :i < end, :i += increment)
        while(variableNumber.getNumber() < end.getNumber()){
            
            for(Expression expression : commandExpression){
                List<TurtleCommand> turtleCmds = expression.createTurtleCommands(latestTurtleCommand);
                if(turtleCmds.size() != 0) {  //if call another fun inside the fun, no Cmds reutrn
                    latestTurtleCommand = turtleCmds.get(turtleCmds.size() -1);
                }
                commandList.addAll(turtleCmds);
            }
            
            
            localVariables.put(variableExpression.getId(), variableNumber.sum(increment));
            variableNumber = (NumberExpression) localVariables.get(variableExpression.getId());
        }
        
        
        
        localVariables.clear();
        
        return commandList;
    }

}
