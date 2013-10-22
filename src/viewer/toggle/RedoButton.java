package viewer.toggle;

import controller.Controller;

public class RedoButton extends Button {

	private static final String BUTTON_TITLE = "Redo";

	public RedoButton(Controller controller) {
		super(BUTTON_TITLE, controller);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void buttonPushed() {
		this.myController.redo();
	}

}
