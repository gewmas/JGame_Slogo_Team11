package viewer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public abstract class EditableListTable extends JPanel{
    protected JTable myElementTable; 
    protected DefaultTableModel myTableModel;
    
    protected HashMap<String,Double> myElements;
    public EditableListTable(int width, int height, String[] columnNames){
        myElements=new HashMap<String,Double>();
        myElementTable=new JTable(){
            @Override  
            //Override method to allow cells to be deselected
            public void changeSelection(int rowIndex, int columnIndex,  
                    boolean toggle, boolean extend) {  
                super.changeSelection(rowIndex, columnIndex, true, false);  
            }  
        };
        
        myTableModel=new DataTableModel(null,columnNames);
        myElementTable.setModel(myTableModel);
        add(myElementTable);
        setBorder(BorderFactory.createLineBorder(Color.black));
        setPreferredSize(new Dimension(width,height));
    }
}
