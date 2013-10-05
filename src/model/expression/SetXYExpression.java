package model.expression;

import java.util.List;
import controller.TurtleCommand;

public class SetXYExpression extends TwoParameterExpression {

    public SetXYExpression (List<String> cmdList) {
        super(cmdList);
    }
    
    public TurtleCommand createTurtleCommand(TurtleCommand turtleCmd) {

        if(!(expression1 instanceof NumberExpression) || !(expression2 instanceof NumberExpression)) {
            // Do better error checking here
            return null;
        }

        NumberExpression expX = (NumberExpression) expression1;
        NumberExpression expY = (NumberExpression) expression2;
        turtleCmd.setX(expX.getNumber());
        turtleCmd.setY(expY.getNumber());
        return turtleCmd;
    }

}
