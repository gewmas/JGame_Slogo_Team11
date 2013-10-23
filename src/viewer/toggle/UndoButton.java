package viewer.toggle;

import controller.Controller;

public class UndoButton extends Button {

	private static final String LABEL = "Undo";
	
	/**
	 * UndoButton is a GUI button for users to undo an issued command
	 * @param controller is the controller between model and view (MVC)
	 */
	public UndoButton(Controller controller) {
		super(LABEL, controller);
	}

	@Override
	public void buttonPushed() {
		this.myController.undo();
	}

}
