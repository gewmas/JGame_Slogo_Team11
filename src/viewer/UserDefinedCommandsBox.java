package viewer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Label;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import model.expression.Expression;
import model.expression.NumberExpression;

public class UserDefinedCommandsBox extends Panel {
    private static final JLabel HEADER=new JLabel("User Defined Functions");
    protected JLabel myVariables;
    protected JList myDefinedCommands;
    protected DefaultListModel myListModel;
    protected JScrollPane myScrollPane;
    
    public UserDefinedCommandsBox(int width, int height){
        super(width,height);
        myListModel=new DefaultListModel();
        myDefinedCommands=new JList(myListModel);
        add(HEADER);
        myScrollPane=new JScrollPane(myDefinedCommands);
        myScrollPane.setPreferredSize(new Dimension(width-5,height-30));
        myScrollPane.setBackground(this.getBackground());
        add(myScrollPane);
        setBorder(BorderFactory.createLineBorder(Color.black));
    }
    
    public void updateFunctionList(Map<String,Expression> variableMap){
        for (int i=0;i<variableMap.size();i++){
            String functionName=(String) variableMap.keySet().toArray()[i];
            if (myListModel.indexOf(functionName)==-1){
                myListModel.addElement(functionName);
            }
        }
    }
    
    public void clearFunctionList(){
        myListModel.clear();
    }

}
