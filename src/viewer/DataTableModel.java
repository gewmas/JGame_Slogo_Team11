package viewer;

import javax.swing.table.DefaultTableModel;


public class DataTableModel extends DefaultTableModel{
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
