package model.expression;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import Exceptions.SlogoException;
import controller.TurtleCommand;
import controller.TurtleTrace;
import model.Model;
import model.parser.DefaultParser;

public class FunctionExpression extends ScopedExpression {

//    List<String> commandList;
    FunctionDeclarationExpression declaration;
    

    /*
     *  to method [ :x ] [ fd :x ]
     *  method sum 1 2
     * 
     */
    
    public FunctionExpression(List<String> cmdList, Model model) throws SlogoException{
        super(model);
//        commandList = cmdList;
    }

    @Override
    public void convert (List<String> cmdList) throws SlogoException {
        cmdList.remove(0);
        
       for (Expression varExpression : declaration.variables) {
           VariableExpression var = (VariableExpression) varExpression;     
           try
           {
               NumberExpression finalExp = new NumberExpression(Double.parseDouble(cmdList.get(0)), model);
               localVariables.put(var.getId(), finalExp);
               cmdList.remove(0);
           }
           catch (NumberFormatException e)
           {
               localVariables.put(var.getId(), parser.parse(cmdList));
           }  
       }
                           
    }
    
    public void checkFunctionDeclaration(Expression exp) {
        declaration = (FunctionDeclarationExpression) exp;
    }
    
    @Override
    public List<TurtleCommand> createTurtleCommands(TurtleCommand turtleCommand) throws SlogoException {
        List<TurtleCommand> commandList = new ArrayList<TurtleCommand>();
        
        TurtleCommand latestTurtleCommand = turtleCommand;

        for (Expression expression : declaration.expressions) {
//            List<Expression> evaluatedExpressions = expression.evaluate();
//            for (Expression evalExpression : evaluatedExpressions) {
                List<TurtleCommand> turtleCmds = expression.createTurtleCommands(latestTurtleCommand);
                if(turtleCmds.size() != 0) {  //if call another fun inside the fun, no Cmds return
                    latestTurtleCommand = turtleCmds.get(turtleCmds.size() -1);
                }
                commandList.addAll(turtleCmds);
//            }
        }
        
        //clean localVariable
        localVariables.clear();
        
        return commandList;
    }
    
    
    
}
