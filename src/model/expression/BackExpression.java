package model.expression;

import java.util.List;
import controller.TurtleCommand;

public class BackExpression extends OneParameterExpression {

    public BackExpression (List<String> cmdList) {
        super(cmdList);
    }
    
    public TurtleCommand createTurtleCommand(TurtleCommand turtleCmd) {
        expression = expression.evaluate().get(0);
        
        if(!(expression instanceof NumberExpression)) {
            // Do better error checking here
            return null;
        }
        
        NumberExpression exp = (NumberExpression) expression;
        turtleCmd.setX(turtleCmd.getX() - exp.getNumber() * Math.round(Math.cos(Math.toRadians(turtleCmd.getDirection()))));
        turtleCmd.setY(turtleCmd.getY() - exp.getNumber() * Math.round(Math.sin(Math.toRadians(turtleCmd.getDirection()))));
        return turtleCmd;
    }

}
