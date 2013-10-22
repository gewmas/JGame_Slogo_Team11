package viewer.toggle;

import controller.Controller;
import controller.TurtleCommand;

public class LoadPreferencesButton extends SelectableListButton {

	private static final String BUTTON_TITLE = "Load Preferences";
	private static final String DIALOG_MESSAGE = "Please select preferences to load.";

	protected static String[] PREFERENCES = {};
	public LoadPreferencesButton(Controller controller) {
		super(PREFERENCES, PREFERENCES, BUTTON_TITLE, DIALOG_MESSAGE, controller);
	}
	
	private int getAllPreferenceNames() {
		return this.myController.getAllPreferences().size();
	}
	
	@Override
	public void buttonPushed() {
		this.myListModel.clear();
		int numOptions = getAllPreferenceNames();
		for (int i = 0; i < numOptions; i++) {
			myListModel.addElement(String.valueOf(i));
			System.out.println(i);
		}
		super.buttonPushed();
		if (!myListModel.isEmpty()) {
			System.out.println(numOptions);
			int selected = myList.getSelectedIndex();
			if (selected > -1) {
			    this.myController.loadPreferences(selected);				
			}
		}
	}
}
