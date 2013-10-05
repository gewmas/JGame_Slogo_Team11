package model.expression;

import controller.TurtleCommand;

public class PenDownExpression extends ZeroParameterExpression {
    
    public TurtleCommand createTurtleCommand(TurtleCommand turtleCmd) {

        turtleCmd.setPenDown(true);
        
        return turtleCmd;
    }

}
