package viewer.toggle;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import controller.Controller;
import jgame.JGColor;
import viewer.Panel;

public class TurtleImageButton extends SelectableListButton {
    private static final String BUTTON_TITLE="Set Turtle Image";
    private static final String DIALOG_MESSAGE="Please select a turtle image";
    private static final String[] IMAGE_NUMBERS={"1","2"};
    private static final String[] IMAGE_NAMES={"Turtle 1", "Turtle 2"};

    public TurtleImageButton(Controller controller) {
        super(IMAGE_NAMES,IMAGE_NUMBERS, BUTTON_TITLE, DIALOG_MESSAGE,controller);
    }

    @Override
    public void buttonPushed() {
    	super.buttonPushed();
    	this.myController.setTurtleImage(IMAGE_NUMBERS[myList.getSelectedIndex()]);
    }

//    @Override
//    public void callReturn () {
//        ((Toggles) this.myPanel).setTurtleImage(IMAGE_NUMBERS[myList.getSelectedIndex()]);
//    }

}
