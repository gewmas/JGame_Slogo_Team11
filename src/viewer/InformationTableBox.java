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

//Should also extend EditableListTable?
public class InformationTableBox extends EditableListTable {
    private static final int X_ROW=0;
    private static final int Y_ROW=1;
    private static final int DIR_ROW=2;
    private static final String[] COLUMNNAMES={"Variable","Value"};
    private static final String[] DATA={"Turtle #","x","y","direction","penup"};
//    private static final JLabel HEADER=new JLabel("Data");
    protected JLabel myVariables;
//    protected JList myDefinedCommands;
    protected DefaultListModel myListModel;
    
    public InformationTableBox(int width, int height){
        super(width,height,COLUMNNAMES);
        myListModel=new DefaultListModel();
//        myDefinedCommands=new JList();
        for (String data:DATA){
            myTableModel.addRow(new String[] {data,""});
        }
//        add(HEADER);
//        add(myDefinedCommands);
        setBorder(BorderFactory.createLineBorder(Color.black));
        setVisible(true);
    }
    
    public void setTable(String turtlenum,String x, String y, String dir, String penup){
        String[] parameters=new String[]{turtlenum,x,y,dir,penup};
        for (int i=0;i<parameters.length;i++){
//            System.out.println(parameters[0]+parameters[1]+parameters[2]+parameters[3]);
            myTableModel.setValueAt(parameters[i], i, 1);
        }
    }
}