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
//        String[] test={"Hi","Hello"};
//        Map<String, Expression> map = MakeExpression.getVariables();
//        for (String key : map.keySet()) {
////			String[] row = {key, map.get(key).toString()};
//            myTableModel.addRow(test);
//		}
    }
    
    public void updateVariableTable(Map<String,Expression> variableMap){
        for (int i=0;i<variableMap.size();i++){
            String variableName=(String) variableMap.keySet().toArray()[i];
            Expression variableExpression=variableMap.get(variableName);
            String variableValue=((NumberExpression)variableExpression).getNumber().toString();
            if (i<myTableModel.getRowCount()){
                if(!(myTableModel.getValueAt(i,1).equals(variableValue))){
                    myTableModel.setValueAt(variableValue, i, 1);
                }
            } else {
                myTableModel.addRow(new String[] {variableName,variableValue});
            }
        }
    }
    
    public void clearVariableTable(){
        myTableModel=new DataTableModel(null,myColumnNames);
    }
    
//    public void addVariable(String key, Expression expression) {
//        myTableModel.getRowCount();
//    	String expressionValue = ((NumberExpression) expression).getNumber().toString();
//    	String[] row = {key, expressionValue};
//    	System.out.println(key + " " + expressionValue);
////    	System.out.println(myTableModel.getColumnCount());
//    	myTableModel.addRow(row);
//    }
    
    
}
