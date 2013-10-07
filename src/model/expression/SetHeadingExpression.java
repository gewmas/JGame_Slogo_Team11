package model.expression;

import java.util.ArrayList;
import java.util.List;
import controller.TurtleCommand;

public class SetHeadingExpression extends OneParameterExpression{

    public SetHeadingExpression (List<String> cmdList) {
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
        turtleCmd.setDirection(exp.getNumber());
        List<TurtleCommand> list = new ArrayList<TurtleCommand>();
        list.add(new TurtleCommand(turtleCmd));
        return list;
    }

}
