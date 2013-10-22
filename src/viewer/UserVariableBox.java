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
    HashMap<String, Integer> myVariablePositions;
    
    public UserVariableBox(int width, int height){
        super(width,height,columnNames);
        myVariablePositions=new HashMap<String,Integer>();
    }
    
    public void updateVariableTable(Map<String,Expression> variableMap){
        for (int i=0;i<variableMap.size();i++){
            String variableName=(String) variableMap.keySet().toArray()[i];
            Expression variableExpression=variableMap.get(variableName);
            String variableValue=((NumberExpression)variableExpression).getNumber().toString();
            if (!myVariablePositions.containsKey(variableName)){
                myTableModel.addRow(new String[] {variableName,variableValue});
                myVariablePositions.put(variableName, myVariablePositions.size());
            } else {
                myTableModel.setValueAt(variableValue, myVariablePositions.get(variableName), 1);
            }
        }
    }
    
    public void clearVariableTable(){
        myTableModel=new DataTableModel(null,myColumnNames);
    }
    
}
