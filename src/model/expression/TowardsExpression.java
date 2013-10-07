package model.expression;

import java.util.ArrayList;
import java.util.List;
import controller.TurtleCommand;

public class TowardsExpression extends TwoParameterExpression {

    public TowardsExpression (List<String> cmdList) {
        super(cmdList);
    }
    
    @Override
    public List<TurtleCommand> createTurtleCommands(TurtleCommand turtleCmd) {

        if(!(expression1 instanceof NumberExpression) || !(expression2 instanceof NumberExpression)) {
            // Do better error checking here
            return null;
        }

        NumberExpression expX = (NumberExpression) expression1;
        NumberExpression expY = (NumberExpression) expression2;
        double pointX = expX.getNumber();
        double pointY = expY.getNumber();

        double turtleX = turtleCmd.getX();
        double turtleY = turtleCmd.getY();
        
        //Shift turtle x,y to origin and adjust point so relation remains
        double newPointX = pointX - turtleX;
        double newPointY = pointY - turtleY;       
        
        double angle = Math.atan((newPointY/newPointX));
        
        turtleCmd.setDirection((turtleCmd.getDirection() - angle));
        
        List<TurtleCommand> list = new ArrayList<TurtleCommand>();
        list.add(turtleCmd);
        return list;
    }

}
