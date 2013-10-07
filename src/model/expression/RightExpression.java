package model.expression;

import java.util.ArrayList;
import java.util.List;
import controller.TurtleCommand;

public class RightExpression extends OneParameterExpression {

    public RightExpression (List<String> cmdList) {
        super(cmdList);
    }
    
    @Override
    public List<TurtleCommand> createTurtleCommands(TurtleCommand turtleCmd) {

        expression = expression.evaluate().get(0);
        
        if(!(expression instanceof NumberExpression)) {
            // Do better error checking here
            return null;
        }

        turtleCmd = new TurtleCommand(turtleCmd);
        NumberExpression exp = (NumberExpression) expression;
        turtleCmd.setDirection(turtleCmd.getDirection() - exp.getNumber());
        List<TurtleCommand> list = new ArrayList<TurtleCommand>();
        list.add(turtleCmd);
        return list;
    }

}
