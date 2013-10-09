package viewer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import jgame.JGPoint;

public class Display extends Panel {
	
    public Display(int width, int height){
        setPreferredSize(new Dimension(width,height));
        //setVisible(true);
        setBorder(BorderFactory.createLineBorder(Color.black));
        this.setName("Display");
        this.setOpaque(false);
        Example1 jgametest = new Example1(new JGPoint(width-10,height-10));
        add(jgametest);
        setVisible(true);
    }
    
}
