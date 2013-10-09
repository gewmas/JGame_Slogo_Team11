package viewer;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class PastCommandBox extends Panel{
    JList myPastCommandJList;
    DefaultListModel myListModel;
    List<String> myPastCommands;
    JScrollPane myCommandPane;
    public PastCommandBox(int width, int height){
        super(width,height);
        myListModel=new DefaultListModel();
        myPastCommandJList=new JList(myListModel);
        myPastCommandJList.setBackground(this.getBackground());
        add(myPastCommandJList);
        myPastCommands=new ArrayList<String>();
        myListModel.addElement("Hi");
        myCommandPane=new JScrollPane(myPastCommandJList);
        myCommandPane.setPreferredSize(new Dimension(width,height-5));
        add(myCommandPane);
    }
    
    public void addCommand(String command){
        myPastCommands.add(command);
        myListModel.addElement(command);
    }
}
