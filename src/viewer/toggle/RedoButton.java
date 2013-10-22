package viewer.toggle;

import controller.Controller;

public class RedoButton extends Button {

	private static final String LABEL = "Redo";

	public RedoButton(Controller controller) {
		super(LABEL, controller);
	}

	@Override
	public void buttonPushed() {
		this.myController.redo();
	}

}
