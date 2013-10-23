package viewer;

import javax.swing.table.DefaultTableModel;


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
    
    @Override
    public boolean isCellEditable(int row,int column){
        return column==1;
    }
    
}
