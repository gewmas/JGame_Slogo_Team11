package model.expression;

import controller.TurtleCommand;

public class HideTurtleExpression extends ZeroParameterExpression {

    public TurtleCommand createTurtleCommand(TurtleCommand turtleCmd) {

        turtleCmd.setVisible(false);
        
        return turtleCmd;
    }
    
    
}
