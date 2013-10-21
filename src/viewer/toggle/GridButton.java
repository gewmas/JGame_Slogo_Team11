package viewer.toggle;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import controller.Controller;
import viewer.Panel;

public class GridButton extends Button {
	
    private static final String LABEL="Toggle Grid";
    
    public GridButton(Controller controller) {
        super(LABEL, controller);
    }

    @Override
    public void buttonPushed() {
    	this.myController.toggleGrid();
    }
	
}
