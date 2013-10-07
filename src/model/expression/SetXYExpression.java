package model.expression;

import java.util.ArrayList;
import java.util.List;
import controller.TurtleCommand;

public class SetXYExpression extends TwoParameterExpression {

    public SetXYExpression (List<String> cmdList) {
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
        turtleCmd.setX(expX.getNumber());
        turtleCmd.setY(expY.getNumber());
        List<TurtleCommand> list = new ArrayList<TurtleCommand>();
        list.add(new TurtleCommand(turtleCmd));
        return list;
    }

}
