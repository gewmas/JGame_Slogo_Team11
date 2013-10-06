package model.expression;

import java.util.List;
import controller.TurtleCommand;

public class SetHeadingExpression extends OneParameterExpression{

    public SetHeadingExpression (List<String> cmdList) {
        super(cmdList);
    }
    
    public TurtleCommand createTurtleCommand(TurtleCommand turtleCmd) {

        expression = expression.evaluate().get(0);
        
        if(!(expression instanceof NumberExpression)) {
            // Do better error checking here
            return null;
        }

        NumberExpression exp = (NumberExpression) expression;
        turtleCmd.setDirection(exp.getNumber());
        return turtleCmd;
    }

}
