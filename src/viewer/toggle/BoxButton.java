package viewer.toggle;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import controller.Controller;
import viewer.Panel;

public class BoxButton extends Button {
    private static final String LABEL="Highlight Active Turtles";
    
    public BoxButton(Controller controller) {
        super(LABEL, controller);
        //myController=controller;
    }

    @Override
    public void buttonPushed() {
        myController.toggleHighlightTurtles();
    }
	
}
