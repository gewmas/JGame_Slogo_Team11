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

    public TurtleCommand createTurtleCommand(TurtleCommand turtleCmd) {

        if(!(expression instanceof NumberExpression)) {
            // Do better error checking here
            return null;
        }

        NumberExpression exp = (NumberExpression) expression;
        turtleCmd.setX(turtleCmd.getX() + exp.getNumber() * Math.cos(turtleCmd.getDirection()));
        turtleCmd.setY(turtleCmd.getY() + exp.getNumber() * Math.sin(turtleCmd.getDirection()));
        return turtleCmd;
    }


}
