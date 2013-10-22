package viewer;

import java.awt.Color;
import java.awt.Label;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;

//Should also extend EditableListTable?
public class UserDefinedCommandsBox extends Panel {
    private static final JLabel HEADER=new JLabel("User Defined Functions");
    protected JLabel myVariables;
    protected static JList myDefinedCommands;
    protected static DefaultListModel myListModel;
    
    public UserDefinedCommandsBox(int width, int height){
        super(width,height);
        myListModel=new DefaultListModel();
        myDefinedCommands=new JList(myListModel);
        add(HEADER);
        add(myDefinedCommands);
        setBorder(BorderFactory.createLineBorder(Color.black));
//        myListModel.addElement(new Function Name);;
    }
    
    public static void addFunction(String key) {
    	System.out.println("hello");
    	myDefinedCommands.add(new Label(key));
    	myListModel.addElement(new Label(key));
    }

}
