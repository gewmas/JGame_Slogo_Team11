package model.expression;

import controller.TurtleCommand;

public class HomeExpression extends ZeroParameterExpression {

    public TurtleCommand createTurtleCommand(TurtleCommand turtleCmd) {
        turtleCmd.setX(0);
        turtleCmd.setY(0);
        return turtleCmd;
    }
    
}
