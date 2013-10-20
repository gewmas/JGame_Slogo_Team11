package viewer.toggle;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import controller.Controller;
import jgame.JGColor;
import viewer.Panel;

public class PenColorButton extends SelectableListButton {

    private static final String BUTTON_TITLE="Set Pen Color";
    private static final String DIALOG_MESSAGE="Please select a pen color";
//    private static final JGColor[] PEN_JGCOLORS={JGColor.black,JGColor.blue,JGColor.cyan,
//                                              JGColor.gray,JGColor.green,JGColor.magenta,
//                                              JGColor.orange,JGColor.pink,JGColor.red,JGColor.white,JGColor.yellow};
    private static final String[] PEN_COLORS={"Black","Blue","Cyan","Gray","Green","Magenta","Orange","Pink","Red","White","Yellow"};
    private static final String COMMAND="SETPEN ";
    
	public PenColorButton(Controller controller) {
            super(PEN_COLORS, PEN_COLORS, COMMAND, BUTTON_TITLE, DIALOG_MESSAGE,controller);
	}
	
//	@Override
//	    public void callReturn () {
//	        ((Toggles) this.myPanel).setPenColor(PEN_JGCOLORS[myList.getSelectedIndex()]);
//	    }
	        
	
}
