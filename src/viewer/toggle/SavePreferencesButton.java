package viewer.toggle;

import controller.Controller;

public class SavePreferencesButton extends Button {

	private static final String BUTTON_TITLE = "Save Preferences";
	private static final String COMMAND = "SAVEPREFS";
	
	public SavePreferencesButton(Controller controller) {
		this(BUTTON_TITLE, controller);
		// TODO Auto-generated constructor stub
	}
	
	public SavePreferencesButton(String label, Controller controller) {
		super(label, controller);
	}

	@Override
	public void buttonPushed() {
		// TODO Auto-generated method stub
        myController.interpretCommand(COMMAND);
	}

}
