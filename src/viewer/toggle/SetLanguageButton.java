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
import java.util.Set;
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

public class SetLanguageButton extends SelectableListButton {
	private static final String BUTTON_TITLE="Set SLogo Language";
	private static final String DIALOG_MESSAGE="Please select a Language";
	protected Set<String> myLanguages;
	        
	/**
	 * SetLanguageButton is a GUI button for users to choose which language to use 
	 * @param controller is the controller between model and view (MVC)
	 */
	public SetLanguageButton(Controller controller) {
		super(new String[]{}, BUTTON_TITLE, DIALOG_MESSAGE, controller);
		myLanguages=myController.getLanguages();
		for (String language:myLanguages){
		    myListModel.addElement(language);
		}
	}
	
	@Override
	public void buttonPushed() {
	    super.buttonPushed();
	    int selectedItem=myList.getSelectedIndex();
	    if (selectedItem!=-1){
	        myController.setLanguage((String) myListModel.get(selectedItem));
	    } 
	}
	 
}
