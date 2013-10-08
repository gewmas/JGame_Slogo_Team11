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

import jgame.JGColor;
import jgame.JGObject;
import viewer.Button;
import viewer.Panel;

public class Toggles extends Panel {
	
    protected List<Button> buttonList;
    private JGColor backgroundColor;
    private JGObject turtleImage;
    private JGColor penColor;
    private boolean gridOn;
    
    public Toggles(int width, int height){
    	setPreferredSize(new Dimension(width,height));
        //setVisible(true);
        //Put toggles into list of some kind and automate creation - but then how do we
        //define listener callbacks?
        setBorder(BorderFactory.createLineBorder(Color.black));
        this.setName("Togggle Controls");
        
        this.buttonList = new ArrayList<Button>();
             
        buttonList.add(new BackgroundColorButton(this));
        buttonList.add(new TurtleImageButton(this));
        buttonList.add(new PenColorButton(this));
        buttonList.add(new GridButton(this));   
        for (int i = 0; i < buttonList.size(); i++) {
			add(buttonList.get(i));
		}        
                
        setVisible(true);
    }
    
    public void setBackgroundColor(JGColor color) {
    	System.out.println("Set Background Color clicked");
//    	this.setBackground(Color.GREEN);
    	this.backgroundColor = color;
    }
    
    public JGColor getBackgroundColor() {
    	return this.backgroundColor;
    }
    
    public void setTurtleImage(JGObject image) {
    	System.out.println("Set Turtle Image clicked");
    	this.turtleImage = image;
    }
    
    public JGObject getTurtleImage() {
    	return this.turtleImage;
    }
    
    public void setPenColor(JGColor color) {
    	System.out.println("Set Pen Color clicked");
    	this.penColor = color;
    }
    
    public JGColor getPenColor() {
    	return this.penColor;
    }
    
    public void toggleGrid() {
    	System.out.println("Toggle Grid clicked");
    	this.gridOn = !this.gridOn;
    }
    
    public boolean getGridStatus() {
    	return this.gridOn;
    }
}
