package viewer.toggle;

import controller.Controller;

public class SavePreferencesButton extends Button {

	private static final String BUTTON_TITLE = "Save Preferences";
	
	public SavePreferencesButton(Controller controller) {
		super(BUTTON_TITLE, controller);
	}

	@Override
	public void buttonPushed() {
		this.myController.savePreferences(this.myController.getCurrentPreferences());
	}

}
