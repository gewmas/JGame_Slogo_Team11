package model.expression;

import java.util.List;
import controller.TurtleCommand;

public class BackExpression extends OneParameterExpression {

    public BackExpression (List<String> cmdList) {
        super(cmdList);
    }
    
    public TurtleCommand createTurtleCommand(TurtleCommand turtleCmd) {
        
        if(!(expression instanceof NumberExpression)) {
            // Do better error checking here
            return null;
        }
        
        NumberExpression exp = (NumberExpression) expression;
        turtleCmd.setX(turtleCmd.getX() - exp.getNumber() * Math.cos(turtleCmd.getDirection()));
        turtleCmd.setY(turtleCmd.getY() - exp.getNumber() * Math.sin(turtleCmd.getDirection()));
        return turtleCmd;
    }

}
