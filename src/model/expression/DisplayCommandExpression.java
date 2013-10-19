package model.expression;

import java.util.ArrayList;
import java.util.List;
import model.Model;
import controller.TurtleCommand;
import Exceptions.SlogoException;

public class DisplayCommandExpression extends OneParameterExpression {

    public DisplayCommandExpression (List<String> cmdList, Model model) throws SlogoException {
        super(cmdList, model);
    }
    
    @Override
    public List<Expression> evaluate () throws SlogoException {
        List<Expression> finalExpressionList = new ArrayList<Expression>();
        finalExpressionList.addAll(expression.evaluate());
        return finalExpressionList;
    }
    
    public NumberExpression turtleCommandPrep(TurtleCommand turtleCmd, List<TurtleCommand> list) throws SlogoException {
        turtleCmd = new TurtleCommand(turtleCmd);
        
        if(expression instanceof SetBackgroundExpression){
            List<TurtleCommand> currentExpressionCmdlist = expression.createTurtleCommands(turtleCmd);
            list.addAll(currentExpressionCmdlist);
            turtleCmd = currentExpressionCmdlist.get(0);
        }
        
        Expression evaluatedExpression = expression.evaluate().get(0);

        if (!(evaluatedExpression instanceof NumberExpression)) // Do better error checking here
            return null;

        NumberExpression exp = (NumberExpression) evaluatedExpression;
        
        return exp;
    }

}
