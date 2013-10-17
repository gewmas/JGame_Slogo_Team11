package viewer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

//Should also extend EditableListTable?
public class UserDefinedCommandsBox extends Panel {
    private static final JLabel HEADER=new JLabel("User Defined Functions");
    protected JLabel myVariables;
    protected JList myDefinedCommands;
    protected DefaultListModel myListModel;
    
    public UserDefinedCommandsBox(int width, int height){
        super(width,height);
        myListModel=new DefaultListModel();
        myDefinedCommands=new JList();
        add(HEADER);
        add(myDefinedCommands);
        setBorder(BorderFactory.createLineBorder(Color.black));
    }
}
