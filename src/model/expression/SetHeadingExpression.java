package model.expression;

import java.util.ArrayList;
import java.util.List;
import model.Model;
import Exceptions.SlogoException;
import controller.TurtleCommand;

public class SetHeadingExpression extends OneParameterExpression{

    public SetHeadingExpression (List<String> cmdList, Model model) throws SlogoException {
        super(cmdList, model);
    }
    
    @Override
    public List<TurtleCommand> createTurtleCommands(TurtleCommand turtleCmd) {

        expression = expression.evaluate().get(0);
        
        if(!(expression instanceof NumberExpression)) {
            // Do better error checking here
            return null;
        }

        NumberExpression exp = (NumberExpression) expression;
        turtleCmd = new TurtleCommand(turtleCmd);
        turtleCmd.setDirection(exp.getNumber());
        List<TurtleCommand> list = new ArrayList<TurtleCommand>();
        list.add(turtleCmd);
        return list;
    }

}
