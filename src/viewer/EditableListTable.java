package viewer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 * @author FrontEnd - Alex, Adam
 */
public abstract class EditableListTable extends Panel {
    protected JTable myElementTable; 
    protected DefaultTableModel myTableModel;
    protected JScrollPane myScrollPane;
    protected String[] myColumnNames;
    protected Map<String,Double> myElements;
    
    /**
     * EditableListTable is a type of table where users can edit values in the list manually
     * @param width is physical width of the panel
     * @param height is the physical height of the panel
     * @param columnNames is the names of all columns in this list
     */
    public EditableListTable(int width, int height, String[] columnNames){
        super(width,height);
        myElements=new HashMap<String,Double>();
        myElementTable=new JTable(){
            // We override this class so that elements can be deselected (remove the highlight)
            @Override  
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
