package viewer.toggle;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import controller.Controller;
import viewer.Panel;

public class InfoTableButton extends Button {
    private static final String LABEL="Toggle Data Panel";
    private static final String COMMAND="DATATOGGLE";
    //protected Controller myController;
    
    public InfoTableButton(Controller controller) {
        super(LABEL, controller);
        //myController=controller;
    }

    @Override
    public void buttonPushed() {
//        ((Toggles) this.myPanel).toggleGrid();
        myController.interpretCommand(COMMAND);
    }
	
}
