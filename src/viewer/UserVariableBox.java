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
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import controller.Controller;
import model.expression.Expression;
import model.expression.MakeExpression;
import model.expression.NumberExpression;

/**
 * @author FrontEnd - Alex, Adam
 */
public class UserVariableBox extends EditableListTable{
	
    protected static final String[] COLUMNNAMES={"Variable","Value"};
    protected static final String SET_VARIABLE_COMMAND="MAKE ";
    protected JLabel myVariables;
    protected JList myVariableNameList, myVariableValueList;
    protected HashMap<String, Integer> myVariablePositions;
    protected Controller myController;
    protected boolean update;    
    
    /**
     * UserVariableBox is a GUI element where users can see the names and values of previously defined variables
     * Users can change the value of a variable by clicking in the table and changing the value manually
     */
    public UserVariableBox(int width, int height, Controller controller){
        super(width,height,COLUMNNAMES);
        myController=controller;
        myVariablePositions=new HashMap<String,Integer>();
        update=true;
        addTableListener();
    }
    
    public void updateVariableTable(Map<String,Expression> variableMap){
        update=false;
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
        update=true;
    }
    
    public void addTableListener(){
        myTableModel.addTableModelListener(new TableModelListener(){
            public void tableChanged(TableModelEvent e){
                if (update){
                    for (int i=e.getFirstRow();i<=e.getLastRow();i++){
                        System.out.println("Change!");
                        myController.interpretCommand(SET_VARIABLE_COMMAND+
                                myTableModel.getValueAt(i, 0)+" "+myTableModel.getValueAt(i,1));
                    }
                }
            }
        });
    }
    
    public void clearVariableTable(){
        update=false;
        myTableModel=new DataTableModel(null,myColumnNames);
        addTableListener();
        myElementTable.setModel(myTableModel);
        myVariablePositions.clear();
        update=true;
    }
    
}
