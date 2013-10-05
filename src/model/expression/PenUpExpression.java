package model.expression;

import controller.TurtleCommand;

public class PenUpExpression extends ZeroParameterExpression {

    public TurtleCommand createTurtleCommand(TurtleCommand turtleCmd) {

        turtleCmd.setPenDown(false);
        
        return turtleCmd;
    }
    
}
