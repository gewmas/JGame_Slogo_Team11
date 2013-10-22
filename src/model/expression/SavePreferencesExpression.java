package model.expression;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import controller.TurtleCommand;
import model.Model;
import Exceptions.SlogoException;

public class SavePreferencesExpression extends DisplayCommandExpression {

	public SavePreferencesExpression(List<String> cmdList, Model model) throws SlogoException {
		super(cmdList, model);
	}
	
    @Override
    public List<TurtleCommand> createTurtleCommands (TurtleCommand turtleCmd) throws SlogoException {
        List<TurtleCommand> list = new ArrayList<TurtleCommand>();
        
        NumberExpression exp = super.turtleCommandPrep(turtleCmd, list);
                
//        turtleCmd.savePreferences(turtleCmd.getCurrentPreferences());
        
        list.add(turtleCmd);
        return list;
    }

}
