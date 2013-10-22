package viewer.toggle;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import controller.Controller;
import jgame.JGColor;
import jgame.JGObject;
import viewer.DisplayBox;
import viewer.Panel;
import viewer.display_objects.TurtleDisplay;

public class Toggles extends Panel {
	
    protected List<Button> buttonList;
    private JGColor backgroundColor;
    private int turtleImageNum;
    private JGColor penColor;
    private TurtleDisplay myTurtleDisplay;
    private boolean gridOn;
    
    public Toggles(int width, int height, Controller controller){
        super(width,height);
    	//setVisible(true);
        //Put toggles into list of some kind and automate creation - but then how do we
        //define listener callbacks?
        setBorder(BorderFactory.createLineBorder(Color.black));
        this.setName("Togggle Controls");
        
        this.buttonList = new ArrayList<Button>();
        
        buttonList.add(new WorkspaceButton(controller));
        buttonList.add(new BackgroundColorButton(controller));
        buttonList.add(new TurtleImageButton(controller));
        buttonList.add(new PenColorButton(controller));
        buttonList.add(new GridButton(controller));   
        buttonList.add(new BoxButton(controller));
        buttonList.add(new DataPopupButton(controller));
        buttonList.add(new UndoButton(controller));
        buttonList.add(new RedoButton(controller));
        buttonList.add(new SavePreferencesButton(controller));
        buttonList.add(new LoadPreferencesButton(controller));

        
        for (int i = 0; i < buttonList.size(); i++) {
			add(buttonList.get(i));
		}        
                
//        myTurtleDisplay=turtledisplay;
        
        setVisible(true);
    }
    
    public void setBackgroundColor(JGColor color) {
    	myTurtleDisplay.setBackGroundColor(color);
    	this.backgroundColor = color;
    }
    
    public JGColor getBackgroundColor() {
    	return this.backgroundColor;
    }
    
    public void setTurtleImage(int imageNum) {
        myTurtleDisplay.setTurtleImageNumber(imageNum);
        this.turtleImageNum = imageNum;
    }
    
    public int getTurtleImage() {
    	return this.turtleImageNum;
    }
    
    public void setPenColor(JGColor color) {
    	myTurtleDisplay.setPenColor(color);
    	this.penColor = color;
    }
    
    public JGColor getPenColor() {
    	return this.penColor;
    }
    
    public void toggleGrid() {
    	myTurtleDisplay.toggleGrid();
    	this.gridOn = !this.gridOn;
    }
    
    public boolean getGridStatus() {
    	return this.gridOn;
    }
}
