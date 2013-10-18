package model.expression;

import java.util.ArrayList;
import java.util.List;
import Exceptions.SlogoException;
import controller.TurtleCommand;

public class BackExpression extends OneParameterExpression {

    public BackExpression (List<String> cmdList) throws SlogoException {
        super(cmdList);
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
        turtleCmd.setX(turtleCmd.getX() - exp.getNumber() * Math.round(Math.cos(Math.toRadians(turtleCmd.getDirection()))));
        turtleCmd.setY(turtleCmd.getY() - exp.getNumber() * Math.round(Math.sin(Math.toRadians(turtleCmd.getDirection()))));
        List<TurtleCommand> list = new ArrayList<TurtleCommand>();
        list.add(turtleCmd);
        return list;
    }

}
