package viewer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import viewer.display_objects.TurtleDisplayWindow;

public class InformationTableBox extends EditableListTable {
    private static final int X_ROW=0;
    private static final int Y_ROW=1;
    private static final int DIR_ROW=2;
    private static final String[] COLUMNNAMES={"Variable","Value"};
    private static final String[] DATA={"Turtle #","x","y","direction","pendown"};
    protected JLabel myVariables;
    protected DefaultListModel myListModel;
    
    /**
     * InformationTableBox is a table that displays information about a turtle in the display
     * You can change which turtle you are viewing information for with the DataPopupButton
     */
    public InformationTableBox(int width, int height){
        super(width,height,COLUMNNAMES);
        myListModel=new DefaultListModel();
        for (String data:DATA){
            myTableModel.addRow(new String[] {data,""});
        }
        setBorder(BorderFactory.createLineBorder(Color.black));
        setVisible(true);
    }
    
    public void setTable(String turtlenum,String x, String y, String dir, String penup){
        String[] parameters=new String[]{turtlenum,x,y,dir,penup};
        for (int i=0;i<parameters.length;i++){
            myTableModel.setValueAt(parameters[i], i, 1);
        }
    }
}
