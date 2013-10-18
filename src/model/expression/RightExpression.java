package model.expression;

import java.util.ArrayList;
import java.util.List;
import Exceptions.SlogoException;
import controller.TurtleCommand;

public class RightExpression extends OneParameterExpression {

    public RightExpression (List<String> cmdList) throws SlogoException {
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
        double currentDirection = turtleCmd.getDirection() - exp.getNumber();
        if(currentDirection < -180){
            currentDirection += 360;
        }else if(currentDirection > 180){
            currentDirection -= 360;
        }
        turtleCmd.setDirection(currentDirection);
        List<TurtleCommand> list = new ArrayList<TurtleCommand>();
        list.add(turtleCmd);
        return list;
    }

}
