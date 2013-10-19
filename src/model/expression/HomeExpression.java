package model.expression;

import java.util.ArrayList;
import java.util.List;
import model.Model;
import controller.TurtleCommand;

public class HomeExpression extends ZeroParameterExpression {

    public HomeExpression (Model model) {
        super(model);
    }

    @Override
    public List<TurtleCommand> createTurtleCommands(TurtleCommand turtleCmd) {
        turtleCmd = new TurtleCommand(turtleCmd);
        turtleCmd.setX(0);
        turtleCmd.setY(0);
        List<TurtleCommand> list = new ArrayList<TurtleCommand>();
        list.add(turtleCmd);
        return list;
    }
    
}
