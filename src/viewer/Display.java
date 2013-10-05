package viewer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Display extends JPanel{
    public Display(){
        setPreferredSize(new Dimension(500,500));
        //setVisible(true);
        setBorder(BorderFactory.createLineBorder(Color.black));
        this.setName("Display");
        setVisible(true);
    }
}
