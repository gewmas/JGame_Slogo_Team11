package viewer.toggle;

import controller.Controller;
import controller.TurtleCommand;

public class LoadPreferencesButton extends SelectableListButton {

	private static final String BUTTON_TITLE = "Load Preferences";
	private static final String DIALOG_MESSAGE = "Please select preferences to load.";
	protected static String[] PREFERENCES = {};
	//protected TurtleCommand turtleCmd;
	
//	public LoadPreferencesButton(Controller controller, TurtleCommand turtleCmd) {
//		super(PREFERENCES, PREFERENCES, COMMAND, BUTTON_TITLE, DIALOG_MESSAGE, controller);
//		this.turtleCmd = turtleCmd;
//	}
	public LoadPreferencesButton(Controller controller) {
		super(PREFERENCES, PREFERENCES, BUTTON_TITLE, DIALOG_MESSAGE, controller);
	}
	
	private String[] getAllPreferenceNames() {
		String[] preferenceNames = new String[this.myController.getAllPreferences().size()];
		for (Integer i = 0; i < preferenceNames.length; i++) {
			preferenceNames[i] = i.toString();
		}
		return preferenceNames;
	}
	
	@Override
	public void buttonPushed() {
		this.myListModel.clear();
		String[] preferenceNames = getAllPreferenceNames();
		for (int i = 0; i < preferenceNames.length; i++) {
			myListModel.addElement(preferenceNames[i]);
		}
		if (!myListModel.isEmpty()) {
			System.out.println(preferenceNames.length);
			System.out.println(preferenceNames[0]);
		    this.myController.loadPreferences(Integer.parseInt(preferenceNames[myList.getSelectedIndex()]));
		}
	}

}
