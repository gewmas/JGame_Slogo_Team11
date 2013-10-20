package model.expression;

import java.util.ArrayList;
import java.util.List;
import model.Model;
import controller.TurtleCommand;
import Exceptions.SlogoException;

public class SetShapeExpression extends DisplayCommandExpression {

    public SetShapeExpression (List<String> cmdList, Model model) throws SlogoException {
        super(cmdList, model);
    }
    
    @Override
    public List<TurtleCommand> createTurtleCommands (TurtleCommand turtleCmd) throws SlogoException {
        List<TurtleCommand> list = new ArrayList<TurtleCommand>();
        
        NumberExpression exp = super.turtleCommandPrep(turtleCmd, list);
        
        turtleCmd.setShape(exp.getNumber());
        
        list.add(turtleCmd);
        return list;
    }

}
