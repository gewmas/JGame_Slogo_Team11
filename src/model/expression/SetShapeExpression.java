package model.expression;

import java.util.ArrayList;
import java.util.List;
import controller.TurtleCommand;
import Exceptions.SlogoException;

public class SetShapeExpression extends DisplayCommandExpression {

    public SetShapeExpression (List<String> cmdList) throws SlogoException {
        super(cmdList);
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public List<TurtleCommand> createTurtleCommands (TurtleCommand turtleCmd) {
        List<TurtleCommand> list = new ArrayList<TurtleCommand>();
        
        NumberExpression exp = super.turtleCommandPrep(turtleCmd, list);
        
        turtleCmd.setShape(exp.getNumber());
        
        list.add(turtleCmd);
        return list;
    }

}
