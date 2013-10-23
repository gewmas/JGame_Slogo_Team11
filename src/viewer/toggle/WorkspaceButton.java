package viewer.toggle;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import controller.Controller;
import controller.Turtle;
import jgame.JGColor;
import viewer.Panel;

/**
 * @author FrontEnd - Alex, Adam
 */
public class WorkspaceButton extends SelectableListButton {
	private static final String BUTTON_TITLE="Change Workspace";
	private static final String DIALOG_MESSAGE="Please select a workspace";
	private static final String WORKSPACE_PROMPT="Workspace ";
	private static final String[] WORKSPACE_VALUES={"Workspace One","Workspace Two","Workspace Three","Workspace Four","Workspace Five"};
	protected int numWorkspaces;
	        
	/**
	 * WorkspaceButton is a GUI button for users to change the current workspace
	 * @param controller is the controller between model and view (MVC)
	 */
	public WorkspaceButton(Controller controller) {
		super(WORKSPACE_VALUES,BUTTON_TITLE, DIALOG_MESSAGE, controller);
		numWorkspaces=1;
	}
	
	@Override
	public void buttonPushed() {
	    myListModel.clear();
	    myListModel.addElement("New Workspace");
	    for (int i=1;i<numWorkspaces+1;i++){
	        myListModel.addElement(WORKSPACE_PROMPT+i);
	    }
	    super.buttonPushed();
	    int selectedItem=myList.getSelectedIndex();
	    if (selectedItem==0){
	        myController.setCurrentWorkspace(String.valueOf(numWorkspaces+1));
	        numWorkspaces++;
	    } else if (selectedItem>0) {
	        myController.setCurrentWorkspace(String.valueOf(selectedItem));
	    }
	}
	 
}
