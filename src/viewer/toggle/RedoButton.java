package viewer.toggle;

import controller.Controller;

public class RedoButton extends Button {

	private static final String BUTTON_TITLE = "Undo";
	private static final String COMMAND = "UNDO";

	public RedoButton(Controller controller) {
		this(BUTTON_TITLE, controller);
		// TODO Auto-generated constructor stub
	}
	
	public RedoButton(String label, Controller controller) {
		super(label, controller);
	}

	@Override
	public void buttonPushed() {
		// TODO Auto-generated method stub
        myController.interpretCommand(COMMAND);
	}

}
