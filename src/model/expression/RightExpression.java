package model.expression;

import java.util.List;
import controller.TurtleCommand;

public class RightExpression extends OneParameterExpression {

    public RightExpression (List<String> cmdList) {
        super(cmdList);
    }
    
    public TurtleCommand createTurtleCommand(TurtleCommand turtleCmd) {

        if(!(expression instanceof NumberExpression)) {
            // Do better error checking here
            return null;
        }

        NumberExpression exp = (NumberExpression) expression;
        turtleCmd.setDirection(turtleCmd.getDirection() - exp.getNumber());
        return turtleCmd;
    }

}
