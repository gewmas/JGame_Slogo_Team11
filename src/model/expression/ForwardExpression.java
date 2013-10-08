package model.expression;

import java.util.ArrayList;
import java.util.List;
import controller.TurtleCommand;


public class ForwardExpression extends OneParameterExpression {

    public ForwardExpression (List<String> cmdList) {
        super(cmdList);
    }

    @Override
    public List<Expression> evaluate () {
        List<Expression> finalExpressionList = new ArrayList<Expression>();
        finalExpressionList.addAll(expression.evaluate());
        return finalExpressionList;
    }

    @Override
    public List<TurtleCommand> createTurtleCommands (TurtleCommand turtleCmd) {
        Expression evaluatedExpression = expression.evaluate().get(0);

        if (!(evaluatedExpression instanceof NumberExpression)) // Do better error checking here
            return null;

        NumberExpression exp = (NumberExpression) evaluatedExpression;
        turtleCmd = new TurtleCommand(turtleCmd);

        // Math.round(d*100)/100.0d;
        double precision = 1000;
        turtleCmd.setX(turtleCmd.getX() + exp.getNumber() *
                       Math.round(Math.cos(Math.toRadians(turtleCmd.getDirection())) * precision) /
                       precision);
        turtleCmd.setY(turtleCmd.getY() + exp.getNumber() *
                       Math.round(Math.sin(Math.toRadians(turtleCmd.getDirection())) * precision) /
                       precision);

        // turtleCmd.setX(turtleCmd.getX() + exp.getNumber() *
        // Math.round(Math.cos(Math.toRadians(turtleCmd.getDirection()))));
        // turtleCmd.setY(turtleCmd.getY() + exp.getNumber() *
        // Math.round(Math.sin(Math.toRadians(turtleCmd.getDirection()))));
        List<TurtleCommand> list = new ArrayList<TurtleCommand>();
        list.add(turtleCmd);
        return list;
    }

}
