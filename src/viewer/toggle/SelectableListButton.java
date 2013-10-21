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

public abstract class SelectableListButton extends Button {
        
	private String[] myListStrings;
	private String[] myListValues;
	private String myDialogMessage;
	private String myCommand;
    protected JList myList;	
    protected Controller myController;
	
	public SelectableListButton(String[] listStrings,String[] listValues,String command
	                            ,String buttonTitle,String dialogMessage, Controller controller) {
		super(buttonTitle, controller);
		myController=controller;
		myDialogMessage=dialogMessage;
		myListStrings=listStrings;
		myListValues=listValues;
		myCommand=command;
		myList=new JList(myListStrings);
		myList.addListSelectionListener(new ListSelectionListener(){
		    @Override
		    public void valueChanged(ListSelectionEvent arg0){
		        if (!arg0.getValueIsAdjusting()){
		            myController.interpretCommand(myCommand+myListValues[myList.getSelectedIndex()]);;
		        }
		    }
		});
	}
	
	@Override
        public void buttonPushed() {
            JOptionPane.showMessageDialog(this, myList, myDialogMessage, JOptionPane.PLAIN_MESSAGE);
        }
	
//	public abstract String getCommand();
	
}
