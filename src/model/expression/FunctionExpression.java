package model.expression;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import model.Model;
import Exceptions.SlogoException;
import controller.TurtleCommand;


public class FunctionExpression extends ScopedExpression {

    // List<String> commandList;
    FunctionDeclarationExpression functionDeclaration;

    /*
     * to method [ :x ] [ fd :x ]
     * method sum 1 2
     */

    public FunctionExpression (List<String> cmdList, Model model) throws SlogoException {
        super(model);
        // commandList = cmdList;
    }

    @Override
    public void convert (List<String> cmdList) throws SlogoException {
        cmdList.remove(0);

        for (Expression varExpression : functionDeclaration.variables) {
            VariableExpression var = (VariableExpression) varExpression;
            try
            {
                NumberExpression finalExp =
                        new NumberExpression(Double.parseDouble(cmdList.get(0)), model);
                localVariables.put(var.getId(), finalExp);
                cmdList.remove(0);
            }
            catch (NumberFormatException e)
            {
                localVariables.put(var.getId(), parser.parse(cmdList));
            }
        }

    }

    public void checkFunctionDeclaration (Expression exp) {
        functionDeclaration = (FunctionDeclarationExpression) exp;
    }

    @Override
    public List<TurtleCommand> createTurtleCommands (TurtleCommand turtleCommand)
                                                                                 throws SlogoException {
        // add to runningFunction Map
        FunctionDeclarationExpression functionDeclaration = getFunctionDeclaration();
        String functionName = functionDeclaration.getFunctionName();
        model.getRunningFunction().put(functionName, this);

        model.getFunctionStack().push(functionDeclaration.getFunctionName());

        List<TurtleCommand> commandList = new ArrayList<TurtleCommand>();

        TurtleCommand latestTurtleCommand = turtleCommand;

        for (Expression expression : functionDeclaration.expressions) {
            // List<Expression> evaluatedExpressions = expression.evaluate();
            // for (Expression evalExpression : evaluatedExpressions) {

            List<TurtleCommand> turtleCmds = expression.createTurtleCommands(latestTurtleCommand);
            if (turtleCmds.size() != 0) {  // if call another fun inside the fun, no Cmds return
                latestTurtleCommand = turtleCmds.get(turtleCmds.size() - 1);
            }
            commandList.addAll(turtleCmds);
            // }
        }

        // clean localVariable
        model.getRunningFunction().remove(functionName);
        model.getFunctionStack().pop();
        localVariables.clear();

        return commandList;
    }

    @Override
    public Map<String, Expression> getLocalVariables () {
        return super.getLocalVariables();
    }

    public FunctionDeclarationExpression getFunctionDeclaration () {
        return functionDeclaration;
    }

}
