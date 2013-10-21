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

public class UserVariableBox extends EditableListTable{
    protected static final String[] columnNames={"Variable","Value"};

    protected JLabel myVariables;
    protected HashMap<String,String> myElementMap;
    protected JList myVariableNameList, myVariableValueList;
    public UserVariableBox(int width, int height){
        super(width,height,columnNames);
        /*String[] test={"Hi","Hello"};
        for (int i = 0; i < 5; i++) {
            myTableModel.addRow(test);
		}
        //Automate value entry?*/
        
    }
}
