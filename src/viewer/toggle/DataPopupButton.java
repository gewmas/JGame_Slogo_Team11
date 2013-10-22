package viewer.toggle;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import controller.Controller;
import viewer.Panel;

public class DataPopupButton extends Button {
    private static final String LABEL="View Data";
    
    public DataPopupButton(Controller controller) {
        super(LABEL, controller);
    }

    @Override
    public void buttonPushed() {
    	//this.myController.getCurrentWorkspace().getActiveTurtles().
    }
	
}
