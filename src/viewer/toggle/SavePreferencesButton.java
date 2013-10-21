package viewer.toggle;

import controller.Controller;

public class SavePreferencesButton extends Button {

	private static final String BUTTON_TITLE = "Save Preferences";
	private static final String COMMAND = "SAVEPREFS";
	
	public SavePreferencesButton(Controller controller) {
		super(BUTTON_TITLE, controller);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void buttonPushed() {
		// TODO Auto-generated method stub
        myController.interpretCommand(COMMAND);
	}

}
