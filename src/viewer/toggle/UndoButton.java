package viewer.toggle;

import controller.Controller;

public class UndoButton extends Button {

	private static final String LABEL = "Undo";
	
	public UndoButton(Controller controller) {
		super(LABEL, controller);
	}

	@Override
	public void buttonPushed() {
		this.myController.undo();
	}

}
