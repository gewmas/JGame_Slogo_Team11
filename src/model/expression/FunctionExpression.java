package model.expression;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import controller.TurtleCommand;
import controller.TurtleTrace;
import model.parser.DefaultParser;

public class FunctionExpression extends Expression {

    List<String> commandList;
    FunctionDeclarationExpression declaration;
    private static Map<String, Expression>localVariables;

    public FunctionExpression(List<String> cmdList){
        localVariables = new HashMap<String, Expression>();
        commandList = cmdList;
    }

    @Override
    public void convert (List<String> cmdList) {
        cmdList.remove(0);
        
       for (Expression varExpression : declaration.variables) {
           VariableExpression var = (VariableExpression) varExpression;     
           try
           {
               NumberExpression finalExp = new NumberExpression(Double.parseDouble(cmdList.get(0)));
               localVariables.put(var.getId(), finalExp);
               cmdList.remove(0);
           }
           catch (NumberFormatException e)
           {
               localVariables.put(var.getId(), DefaultParser.parse(cmdList));
           }  
       }
                           
    }
    
    public void checkFunctionDeclaration(Expression exp) {
        declaration = (FunctionDeclarationExpression) exp;
    }
    
    @Override
    public List<TurtleCommand> createTurtleCommands(TurtleCommand turtleCommand) {
        List<TurtleCommand> commandList = new ArrayList<TurtleCommand>();
        
        TurtleCommand latestTurtleCommand = turtleCommand;

        for (Expression expression : declaration.expressions) {
            List<TurtleCommand> turtleCmds = expression.createTurtleCommands(latestTurtleCommand);
            if(turtleCmds.size() != 0) {
                latestTurtleCommand = turtleCmds.get(turtleCmds.size() -1);
            }
            commandList.addAll(turtleCmds);
        }
        
        return commandList;
    }
    
    public static Map<String, Expression> getLocalVariables() {
        return localVariables;
    }
    
}
