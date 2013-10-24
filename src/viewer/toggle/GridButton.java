package viewer.toggle;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import controller.Controller;
import viewer.Panel;

/**
 * @author FrontEnd - Alex, Adam
 */
public class GridButton extends Button {

    private static final String LABEL="Toggle Grid";

    /**
     * GridButton is a GUI button for users to toggle the reference grid on or off
     * @param controller is the controller between model and view (MVC)
     */
    public GridButton(Controller controller) {
        super(LABEL, controller);
    }

    @Override
    public void buttonPushed() {
        this.myController.toggleGrid();
    }

}
