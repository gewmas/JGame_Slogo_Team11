package viewer;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ToggleControls extends JPanel{
    protected JTextField myTextField;
    public ToggleControls(){
        setPreferredSize(new Dimension(300,300));
        //setVisible(true);
        setBorder(BorderFactory.createLineBorder(Color.black));
        this.setName("Toggle Controls");
        JButton buttonToggle=new JButton("Toggle");
        add(buttonToggle);
        setVisible(true);
    }
}
