package viewer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import controller.Controller;
import controller.TurtleTrace;
import jgame.JGPoint;

public class Display extends Panel {
	
    public Display(int width, int height,Controller controller){
        setPreferredSize(new Dimension(width,height));
        //setVisible(true);
        setBorder(BorderFactory.createLineBorder(Color.black));
        this.setName("Display");
        this.setOpaque(false);
        DefaultTurtleDisplay jgametest = new DefaultTurtleDisplay(new JGPoint(width-10,height-10), controller);
        add(jgametest);
        setVisible(true);
    }
    
}
