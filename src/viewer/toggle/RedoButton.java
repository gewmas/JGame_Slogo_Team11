package viewer.toggle;

import controller.Controller;

public class RedoButton extends Button {

	private static final String LABEL = "Redo";

	/**
	 * RedoButton is a GUI button for users to redo an undone command
	 * @param controller is the controller between model and view (MVC)
	 */
	public RedoButton(Controller controller) {
		super(LABEL, controller);
	}

	@Override
	public void buttonPushed() {
		this.myController.redo();
	}

}
