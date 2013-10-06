package viewer.toggle;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import viewer.Button;
import viewer.Panel;

public class ToggleControls extends Panel {
	
    protected List<Button> buttonList;
    
    public ToggleControls(int width, int height){
        setPreferredSize(new Dimension(width,height));
        //setVisible(true);
        //Put toggles into list of some kind and automate creation - but then how do we
        //define listener callbacks?
        setBorder(BorderFactory.createLineBorder(Color.black));
        this.setName("Toggle Controls");
        this.buttonList = new ArrayList<Button>();
        buttonList.add(new BackgroundColorButton());
        buttonList.add(new TurtleImageButton());
        buttonList.add(new PenColorButton());
        buttonList.add(new ToggleGridButton());   
        for (int i = 0; i < buttonList.size(); i++) {
			add(buttonList.get(i));
		}        
        setVisible(true);
    }
}
