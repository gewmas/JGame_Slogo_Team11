package viewer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import model.expression.Expression;
import model.expression.MakeExpression;
import model.expression.NumberExpression;

public class UserVariableBox extends EditableListTable{
    protected static final String[] columnNames={"Variable","Value"};

    protected JLabel myVariables;
    protected HashMap<String,String> myElementMap;
    protected JList myVariableNameList, myVariableValueList;
    public UserVariableBox(int width, int height){
        super(width,height,columnNames);
        //String[] test={"Hi","Hello"};
//        Map<String, Expression> map = MakeExpression.getVariables();
//        for (String key : map.keySet()) {
//			String[] row = {key, map.get(key).toString()};
//            myTableModel.addRow(row);
//		}
        //Automate value entry?*/
    }
    
    public static void addVariable(String key, String value) {
    	String[] row = {key, value};
    	myTableModel.addRow(row);
    }
}
