package viewer.toggle;

import controller.Controller;

/**
 * @author FrontEnd - Alex, Adam
 */
public class SavePreferencesButton extends Button {

	private static final String LABEL = "Save Preferences";
	
	/**
	 * SavePreferencesButton is a GUI button for users to save current GUI preferences
	 * @param controller is the controller between model and view (MVC)
	 */
	public SavePreferencesButton(Controller controller) {
		super(LABEL, controller);
	}

	@Override
	public void buttonPushed() {
		this.myController.savePreferences(this.myController.getCurrentPreferences());
	}

}
