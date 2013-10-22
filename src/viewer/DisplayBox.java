package viewer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import viewer.display_objects.TurtleDisplayWindow;
import controller.Controller;
import controller.TurtleTrace;
import jgame.JGPoint;

public class DisplayBox extends Panel {
	
    protected TurtleDisplayWindow myTurtleDisplay;
    
    public DisplayBox(int width, int height,TurtleDisplayWindow turtledisplay,Controller controller){
        super(width,height);
        setBorder(BorderFactory.createLineBorder(Color.black));
        this.setName("Display");
        this.setOpaque(false);
        myTurtleDisplay = turtledisplay;
        add(myTurtleDisplay);
        setVisible(true);
    }    
}
