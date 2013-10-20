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

public class WorkspaceButton extends SelectableListButton {
        private static final String BUTTON_TITLE="Change Workspace";
        private static final String DIALOG_MESSAGE="Please select a workspace";
        private static final String COMMAND="SET WORKSPACE ";
        private static final String[] WORKSPACE_NUMBERS={"1","2","3","4","5"};
        private static final String[] WORKSPACE_VALUES={"Workspace One","Workspace Two","Workspace Three","Workspace Four","Workspace Five"};
	        
	public WorkspaceButton(Controller controller) {
	        super(WORKSPACE_VALUES,WORKSPACE_NUMBERS,COMMAND,
	              BUTTON_TITLE, DIALOG_MESSAGE,controller);
	}
//    @Override
//    public String getCommand () {
//        return COMMAND+WORKSPACE_NUMBERS[myList.getSelectedIndex()];
////        ((Toggles) this.myPanel).setWorkspace(BG_JGCOLORS[myList.getSelectedIndex()]);
//    }
	
}
