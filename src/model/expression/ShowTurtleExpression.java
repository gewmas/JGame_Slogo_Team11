package model.expression;

import controller.TurtleCommand;

public class ShowTurtleExpression extends ZeroParameterExpression {

    public TurtleCommand createTurtleCommand(TurtleCommand turtleCmd) {

        turtleCmd.setVisible(true);
        
        return turtleCmd;
    }
    
}
