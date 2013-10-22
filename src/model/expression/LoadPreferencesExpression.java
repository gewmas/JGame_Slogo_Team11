package model.expression;

import java.util.ArrayList;
import java.util.List;

import controller.TurtleCommand;
import model.Model;
import Exceptions.SlogoException;

public class LoadPreferencesExpression extends DisplayCommandExpression {

	public LoadPreferencesExpression(List<String> cmdList, Model model) throws SlogoException {
		super(cmdList, model);
	}
	
    @Override
    public List<TurtleCommand> createTurtleCommands (TurtleCommand turtleCmd) throws SlogoException {
        List<TurtleCommand> list = new ArrayList<TurtleCommand>();
        
        NumberExpression exp = super.turtleCommandPrep(turtleCmd, list);
                
//        turtleCmd.loadPreferences((int)exp.getNumber());
        
        list.add(turtleCmd);
        return list;
    }

}
