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
import viewer.display_objects.DefaultTurtleDisplayWindow;
import viewer.display_objects.TurtleDisplayWindow;

/**
 * @author FrontEnd - Alex, Adam
 */
public class ToggleBox extends Panel {
	
    protected List<Button> buttonList;
    private JGColor backgroundColor;
    private int turtleImageNum;
    private JGColor penColor;
    private TurtleDisplayWindow myTurtleDisplay;
    private boolean gridOn;
    
	/**
	 * ToggleBox is the GUI box in the bottom right of our display
	 * This panel contains all clickable buttons defined in this package
	 */
    public ToggleBox(int width, int height, Controller controller){
        super(width,height);
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
        buttonList.add(new SetLanguageButton(controller));
        buttonList.add(new HelpButton(controller));

        for (int i = 0; i < buttonList.size(); i++) {
			add(buttonList.get(i));
		}        
        
        setVisible(true);
    }
    
    public void setBackgroundColor(JGColor color) {
    	((DefaultTurtleDisplayWindow) myTurtleDisplay).setBackGroundColor(color);
    	this.backgroundColor = color;
    }
    
    public JGColor getBackgroundColor() {
    	return this.backgroundColor;
    }
    
    public void setTurtleImage(int imageNum) {
        ((DefaultTurtleDisplayWindow) myTurtleDisplay).setTurtleImageNumber(imageNum);
        this.turtleImageNum = imageNum;
    }
    
    public int getTurtleImage() {
    	return this.turtleImageNum;
    }
    
    public void setPenColor(JGColor color) {
    	((DefaultTurtleDisplayWindow) myTurtleDisplay).setPenColor(color);
    	this.penColor = color;
    }
    
    public JGColor getPenColor() {
    	return this.penColor;
    }
    
    public void toggleGrid() {
    	((DefaultTurtleDisplayWindow) myTurtleDisplay).toggleGrid();
    	this.gridOn = !this.gridOn;
    }
    
    public boolean getGridStatus() {
    	return this.gridOn;
    }
    
    public List<Button> getButtonList() {
    	return this.buttonList;
    }
}
