package model.expression;

import java.util.ArrayList;
import java.util.List;
import controller.TurtleCommand;

public class HomeExpression extends ZeroParameterExpression {

    @Override
    public List<TurtleCommand> createTurtleCommands(TurtleCommand turtleCmd) {
        turtleCmd.setX(0);
        turtleCmd.setY(0);
        List<TurtleCommand> list = new ArrayList<TurtleCommand>();
        list.add(new TurtleCommand(turtleCmd));
        return list;
    }
    
}
