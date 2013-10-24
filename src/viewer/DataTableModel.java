package viewer;

import javax.swing.table.DefaultTableModel;

/**
 * @author FrontEnd - Alex, Adam
 */
public class DataTableModel extends DefaultTableModel{

    /**
     * DataTableModel is an extension of DefaultTableModel for use creating information tables in GUI
     */
    public DataTableModel(){
        super();
    }

    public DataTableModel(Object[][] data, Object[] colNames){
        super(data,colNames);
    }

    // Overriding this function allows only the second column in
    // the table to be editable
    @Override
    public boolean isCellEditable(int row,int column){
        return column==1;
    }

}
