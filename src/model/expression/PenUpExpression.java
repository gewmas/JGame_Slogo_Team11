package model.expression;

import java.util.ArrayList;
import java.util.List;
import controller.TurtleCommand;

public class PenUpExpression extends ZeroParameterExpression {

    @Override
    public List<TurtleCommand> createTurtleCommands(TurtleCommand turtleCmd) {

        turtleCmd.setPenDown(false);
        
        List<TurtleCommand> list = new ArrayList<TurtleCommand>();
        list.add(turtleCmd);
        return list;
    }
    
}
