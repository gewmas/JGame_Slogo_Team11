package viewer.toggle;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
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
//        private static final JGColor[] BG_JGCOLORS={JGColor.black,JGColor.blue,JGColor.cyan,
//                                                  JGColor.gray,JGColor.green,JGColor.magenta,
//                                                  JGColor.orange,JGColor.pink,JGColor.red,JGColor.white,JGColor.yellow};
        private static final String[] BG_COLORS={"Black","Blue","Cyan","Gray","Green","Magenta","Orange","Pink","Red","White","Yellow"};
	private static final String COMMAND="SETBG ";
	public BackgroundColorButton(Controller controller) {
	        super(BG_COLORS,BG_COLORS,COMMAND, BUTTON_TITLE, DIALOG_MESSAGE,controller);
	}
	
	

//    @Override
//    public void callReturn () {
//        ((Toggles) this.myPanel).setBackgroundColor(BG_JGCOLORS[myList.getSelectedIndex()]);
//    }
	
}
