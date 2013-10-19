package model.expression;

import java.util.ArrayList;
import java.util.List;
import controller.TurtleCommand;

public class StampExpression extends ZeroParameterExpression {

    @Override
    public List<TurtleCommand> createTurtleCommands(TurtleCommand turtleCmd) {
        turtleCmd = new TurtleCommand(turtleCmd);
        turtleCmd.setStamp(true);
        List<TurtleCommand> list = new ArrayList<TurtleCommand>();
        list.add(turtleCmd);
        return list;
    }

}
