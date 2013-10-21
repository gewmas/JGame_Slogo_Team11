package viewer.toggle;

import controller.Controller;

public class LoadPreferencesButton extends SelectableListButton {

	private static final String BUTTON_TITLE = "Load Preferences";
	private static final String DIALOG_MESSAGE = "Please select preferences to load.";
	protected static String[] PREFERENCES = {};
	private static final String COMMAND = "LOADPREFS";
	
	public LoadPreferencesButton(Controller controller) {
		super(PREFERENCES, PREFERENCES, COMMAND, BUTTON_TITLE, DIALOG_MESSAGE, controller);
	}
	
//	@Override
//	public void buttonPushed() {
//		// TODO Auto-generated method stub
//        myController.interpretCommand(COMMAND);
//	}

}
