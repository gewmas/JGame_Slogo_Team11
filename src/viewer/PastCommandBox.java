package viewer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import controller.Controller;

/**
 * @author FrontEnd - Alex, Adam
 */
public class PastCommandBox extends Panel{
	
    private static final String WELCOME="Welcome to SLOGO!";
    JList myPastCommandJList;
    DefaultListModel myListModel;
    List<String> myPastCommands;
    JScrollPane myCommandPane;
    Controller myController;
    
    /**
     * PastCommandBox is a GUI element where previously executed commands are displayed
     * A user can re-execute commands by clicking on a previously run command
     */
    public PastCommandBox(int width, int height,Controller controller){
        super(width,height);
        myController=controller;
        myListModel=new DefaultListModel();
        myPastCommandJList=new JList(myListModel);
        myPastCommandJList.setBackground(this.getBackground());
        myPastCommandJList.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent commandClicked){
                int selectedIndex=myPastCommandJList.getSelectedIndex();
                if (selectedIndex>0){
                    myController.addCommand((String) myListModel.get(selectedIndex));
                }
            }
        });
        add(myPastCommandJList);
        myPastCommands=new ArrayList<String>();
        myListModel.addElement(WELCOME);
        myCommandPane=new JScrollPane(myPastCommandJList);
        myCommandPane.setPreferredSize(new Dimension(width,height-5));
        add(myCommandPane);
    }
    
    public void updateCommands(List<String> commands){
        myListModel.clear();
        myListModel.addElement(WELCOME);
        for (String command:commands){
            myListModel.addElement(command);
        }
    }
}
