package model.expression;

import java.util.ArrayList;
import java.util.List;
import Exceptions.SlogoException;
import model.Model;
import controller.TurtleCommand;

public class HomeExpression extends ZeroParameterExpression {

    public HomeExpression (Model model) throws SlogoException {
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
