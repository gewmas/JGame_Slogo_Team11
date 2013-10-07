package model.expression;

import java.util.ArrayList;
import java.util.List;
import controller.TurtleCommand;

public class PenDownExpression extends ZeroParameterExpression {
    
    @Override
    public List<TurtleCommand> createTurtleCommands(TurtleCommand turtleCmd) {

        turtleCmd.setPenDown(true);
        
        List<TurtleCommand> list = new ArrayList<TurtleCommand>();
        list.add(turtleCmd);
        return list;
    }

}
