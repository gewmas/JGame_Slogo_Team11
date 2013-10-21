package viewer.toggle;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.Controller;
import jgame.JGColor;
import viewer.Panel;

public class BackgroundColorButton extends SelectableListButton {
    private static final String BUTTON_TITLE="Set Background";
    private static final String DIALOG_MESSAGE="Please select a background color";
//    private static final JGColor[] BACKGROUND_COLORS = {new JGColor(256,0,0), new JGColor(0,256,0), new JGColor(0,0,256)};
    private static final JGColor[] BG_JGCOLORS={JGColor.black,JGColor.blue,JGColor.cyan,
                                                  JGColor.gray,JGColor.green,JGColor.magenta,
                                                  JGColor.orange,JGColor.pink,JGColor.red,JGColor.white,JGColor.yellow};
    private static final String[] BG_COLORS={"Black","Blue","Cyan","Gray","Green","Magenta","Orange","Pink","Red","White","Yellow"};
    private static final String COMMAND="SETBG";
	protected static Map<Double, JGColor> colorMap;

	public BackgroundColorButton(Controller controller) {
		super(BG_COLORS,BG_COLORS,COMMAND, BUTTON_TITLE, DIALOG_MESSAGE,controller);
		buildColorMap();
	}

    @Override
    public void buttonPushed () {
    	super.buttonPushed();
		buildColorMap();
//    	this.myController.setBackgroundColor(BACKGROUND_COLORS[myList.getSelectedIndex()]);
    	this.myController.setBackgroundColor(BG_JGCOLORS[myList.getSelectedIndex()]);
    }
    
    protected static void buildColorMap() {
		colorMap = new HashMap<Double, JGColor>();
		colorMap.put(0d, new JGColor(256, 0, 0));
		colorMap.put(1d, new JGColor(0, 256, 0));
		colorMap.put(2d, new JGColor(0, 0, 256));
//		colorMap.put(3d, JGColor.gray);
//		colorMap.put(4d, JGColor.green);
//		colorMap.put(5d, JGColor.magenta);
//		colorMap.put(6d, JGColor.orange);
//		colorMap.put(7d, JGColor.pink);
//		colorMap.put(8d, JGColor.red);
//		colorMap.put(9d, JGColor.white);
//		colorMap.put(10d,JGColor.yellow);
    }
    
    public static Double getColorIdFromColor(jgame.JGColor jgColor) {
    	for (Double id : colorMap.keySet()) {
    		if (colorMap.get(id) == jgColor) return id;
    	}
    	return null;
    }
    
    public static jgame.JGColor getColorFromColorId(Double id) {
    	return colorMap.get(id);
    }
	
}
