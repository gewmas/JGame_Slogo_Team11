package viewer;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ToggleControls extends JPanel{
    private static final int BUTTON_WIDTH=180;
    public ToggleControls(int width, int height){
        setPreferredSize(new Dimension(width,height));
        //setVisible(true);
        //Put toggles into list of some kind and automate creation - but then how do we
        //define listener callbacks?
        setBorder(BorderFactory.createLineBorder(Color.black));
        this.setName("Toggle Controls");
        JButton backgroundColorButton=new JButton("Set Background Color");
        backgroundColorButton.setPreferredSize(new Dimension(BUTTON_WIDTH,20));
        add(backgroundColorButton);
        JButton turtleImageButton=new JButton("Set Turtle Image");
        turtleImageButton.setPreferredSize(new Dimension(BUTTON_WIDTH,20));
        add(turtleImageButton);
        JButton setPenColorButton=new JButton("Set Pen Color");
        setPenColorButton.setPreferredSize(new Dimension(BUTTON_WIDTH,20));
        add(setPenColorButton);
        JButton toggleGridButton=new JButton("Toggle Grid");
        toggleGridButton.setPreferredSize(new Dimension(BUTTON_WIDTH,20));
        add(toggleGridButton);
        setVisible(true);
    }
}
