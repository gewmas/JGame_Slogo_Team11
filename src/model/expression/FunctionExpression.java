package model.expression;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import controller.TurtleCommand;
import controller.TurtleTrace;
import model.parser.DefaultParser;

public class FunctionExpression extends ScopedExpression {

//    List<String> commandList;
    FunctionDeclarationExpression declaration;
    

    /*
     *  to method [ :x ] [ fd :x ]
     *  method sum 1 2
     * 
     */
    
    public FunctionExpression(List<String> cmdList){
//        commandList = cmdList;
    }

    @Override
    public void convert (List<String> cmdList) {
        cmdList.remove(0);
        
       for (Expression varExpression : declaration.variables) {
           VariableExpression var = (VariableExpression) varExpression;     
           try
           {
               NumberExpression finalExp = new NumberExpression(Double.parseDouble(cmdList.get(0)));
               ScopedExpression.getLocalVariables().put(var.getId(), finalExp);
               cmdList.remove(0);
           }
           catch (NumberFormatException e)
           {
               ScopedExpression.getLocalVariables().put(var.getId(), DefaultParser.parse(cmdList));
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
            List<Expression> evaluatedExpressions = expression.evaluate();
            for (Expression evalExpression : evaluatedExpressions) {
                List<TurtleCommand> turtleCmds = evalExpression.createTurtleCommands(latestTurtleCommand);
                if(turtleCmds.size() != 0) {  //if call another fun inside the fun, no Cmds reutrn
                    latestTurtleCommand = turtleCmds.get(turtleCmds.size() -1);
                }
                commandList.addAll(turtleCmds);
            }
        }
        
        //clean localVariable
        FunctionExpression.getLocalVariables().clear();
        
        return commandList;
    }
    
    
    
}
