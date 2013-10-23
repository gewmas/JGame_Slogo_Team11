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
import javax.swing.ListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import controller.Controller;
import jgame.JGColor;
import viewer.Panel;

/**
 * @author FrontEnd - Alex, Adam
 */
public abstract class SelectableListButton extends Button {

	private String[] myListStrings;
    private String myDialogMessage;
    protected JList myList;	
    protected Controller myController;
    protected DefaultListModel myListModel;

	/**
	 * SelectableListButton is an extension of the Button class
	 * This class is used for buttons that bring up popup menus
	 */
    public SelectableListButton(String[] listStrings,
                                String buttonTitle,String dialogMessage, Controller controller) {
        super(buttonTitle, controller);
        myController=controller;
        myDialogMessage=dialogMessage;
        myListStrings=listStrings;
        myListModel=new DefaultListModel();
        for (String val:myListStrings){
            myListModel.addElement(val);
        }
        myList=new JList(myListModel);
    }

    @Override
    public void buttonPushed() {
        JOptionPane.showMessageDialog(this, myList, myDialogMessage, JOptionPane.PLAIN_MESSAGE);
    }

}
