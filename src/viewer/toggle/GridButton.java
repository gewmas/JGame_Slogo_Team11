package viewer.toggle;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import controller.Controller;
import viewer.Panel;

public class GridButton extends Button {

    private static final String COMMAND="GRIDTOGGLE";
    protected Controller myController;
    
    public GridButton(Controller controller) {
        super("Toggle Grid");
        myController=controller;
    }

    @Override
    public void buttonPushed() {
//        ((Toggles) this.myPanel).toggleGrid();
        myController.interpretCommand(COMMAND);
    }
	
}
