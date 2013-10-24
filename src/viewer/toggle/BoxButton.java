package viewer.toggle;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import controller.Controller;
import viewer.Panel;

/**
 * @author FrontEnd - Alex, Adam
 */
public class BoxButton extends Button {

    private static final String LABEL="Highlight Active Turtles";

    /**
     * BoxButton is a GUI button for users to highlight active turtles
     * @param controller is the controller between model and view (MVC)
     */
    public BoxButton(Controller controller) {
        super(LABEL, controller);
    }

    @Override
    public void buttonPushed() {
        myController.toggleHighlightTurtles();
    }

}
