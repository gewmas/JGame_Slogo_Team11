package viewer.toggle;

import controller.Controller;

public class UndoButton extends Button {

	private static final String BUTTON_TITLE = "Redo";
	private static final String COMMAND = "REDO";
	
	public UndoButton(Controller controller) {
		this(BUTTON_TITLE, controller);
		// TODO Auto-generated constructor stub
	}
	
	public UndoButton(String label, Controller controller) {
		super(label, controller);
	}

	@Override
	public void buttonPushed() {
		// TODO Auto-generated method stub
        myController.interpretCommand(COMMAND);
	}

}
