package viewer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Display extends Panel {
	
    public Display(int width, int height){
        setPreferredSize(new Dimension(width,height));
        //setVisible(true);
        setBorder(BorderFactory.createLineBorder(Color.black));
        this.setName("Display");
        setVisible(true);
    }
    
}
