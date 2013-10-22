package viewer.toggle;

import controller.Controller;

public class SavePreferencesButton extends Button {

	private static final String LABEL = "Save Preferences";
	
	public SavePreferencesButton(Controller controller) {
		super(LABEL, controller);
	}

	@Override
	public void buttonPushed() {
		this.myController.savePreferences(this.myController.getCurrentPreferences());
	}

}
