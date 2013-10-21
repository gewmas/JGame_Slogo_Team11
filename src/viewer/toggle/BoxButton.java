package viewer.toggle;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import controller.Controller;
import viewer.Panel;

public class BoxButton extends Button {
    private static final String LABEL="Highlight Active Turtles";
    private static final String COMMAND="BOXTOGGLE";
    //protected Controller myController;
    
    public BoxButton(Controller controller) {
        super(LABEL, controller);
        //myController=controller;
    }

    @Override
    public void buttonPushed() {
    	//((Toggles) this.myPanel).toggleGrid();
        myController.interpretCommand(COMMAND);
    }
	
}
