package viewer.toggle;

import controller.Controller;
import controller.TurtleCommand;

public class LoadPreferencesButton extends SelectableListButton {

	private static final String BUTTON_TITLE = "Load Preferences";
	private static final String DIALOG_MESSAGE = "Please select preferences to load.";
	protected static String[] PREFERENCES = {"1", "2", "3"};
	private static final String COMMAND = "LOADPREFS";
	//protected TurtleCommand turtleCmd;
	
//	public LoadPreferencesButton(Controller controller, TurtleCommand turtleCmd) {
//		super(PREFERENCES, PREFERENCES, COMMAND, BUTTON_TITLE, DIALOG_MESSAGE, controller);
//		this.turtleCmd = turtleCmd;
//	}
	public LoadPreferencesButton(Controller controller) {
		super(PREFERENCES, PREFERENCES, COMMAND, BUTTON_TITLE, DIALOG_MESSAGE, controller);
	}
	
	private String[] getAllPreferenceNames() {
		String[] preferenceNames = new String[TurtleCommand.getAllPreferences().size()];
		for (Integer i = 0; i < preferenceNames.length; i++) {
			preferenceNames[i] = i.toString();
		}
		//return preferenceNames;
		return PREFERENCES;
	}
	
//	@Override
//	public void buttonPushed() {
//		// TODO Auto-generated method stub
//        myController.interpretCommand(COMMAND);
//	}

}
