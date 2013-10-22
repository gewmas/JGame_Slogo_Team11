package viewer.toggle;

import controller.Controller;

public class UndoButton extends Button {

	private static final String BUTTON_TITLE = "Undo";
	
	public UndoButton(Controller controller) {
		super(BUTTON_TITLE, controller);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void buttonPushed() {
		this.myController.undo();
	}

}
