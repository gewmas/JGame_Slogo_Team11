package viewer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

//Should also extend EditableListTable?
public class UserDefinedCommandsBox extends Panel {
	
    protected JLabel myVariables;
    protected JList myVariableNameList, myVariableValueList;
    
    public UserDefinedCommandsBox(int width, int height){
        super(width,height);
        myVariableNameList=new JList();
        myVariableValueList=new JList();
        add(myVariableNameList);
        add(myVariableValueList);
        setBorder(BorderFactory.createLineBorder(Color.black));
    }
}
