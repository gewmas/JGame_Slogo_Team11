package viewer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public abstract class EditableListTable extends Panel {
    protected JTable myElementTable; 
    protected DefaultTableModel myTableModel;
    protected JScrollPane myScrollPane;
    protected String[] myColumnNames;
    
    protected HashMap<String,Double> myElements;
    public EditableListTable(int width, int height, String[] columnNames){
        super(width,height);
        myElements=new HashMap<String,Double>();
        myElementTable=new JTable(){
            @Override  
            //Override method to allow cells to be deselected
            public void changeSelection(int rowIndex, int columnIndex,  
                    boolean toggle, boolean extend) {  
                super.changeSelection(rowIndex, columnIndex, true, false);  
            }  
        };       
        myColumnNames=columnNames;
        myTableModel=new DataTableModel(null,columnNames);
        myElementTable.setModel(myTableModel);
        myElementTable.setBackground(this.getBackground());
        myElementTable.setGridColor(Color.black); 
        myScrollPane=new JScrollPane(myElementTable);
        myScrollPane.setPreferredSize(new Dimension(width-5,height-5));
        myScrollPane.setBackground(this.getBackground());
        add(myScrollPane);
    }
}
