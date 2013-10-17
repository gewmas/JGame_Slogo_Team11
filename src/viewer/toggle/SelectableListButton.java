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
import jgame.JGColor;
import viewer.Panel;

public abstract class SelectableListButton extends Button {
        
	private String[] myListStrings;
	private String myDialogMessage;
        protected JList myList;	
	
	public SelectableListButton(Panel panel,String[] listStrings,String buttonTitle,
	                            String dialogMessage) {
		super(panel, buttonTitle);
		myDialogMessage=dialogMessage;
		myListStrings=listStrings;
		myList=new JList(myListStrings);
		myList.addListSelectionListener(new ListSelectionListener(){
		    @Override
		    public void valueChanged(ListSelectionEvent arg0){
		        if (!arg0.getValueIsAdjusting()){
		            callReturn();
		        }
		    }
		});
	}
	
	@Override
        public void buttonPushed() {
            JOptionPane.showMessageDialog(this, myList, myDialogMessage, JOptionPane.PLAIN_MESSAGE);
        }
	
	public abstract void callReturn();
	
	
}
