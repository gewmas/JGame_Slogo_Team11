package viewer;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JLayeredPane;
import jgame.JGPoint;
import controller.Controller;
import viewer.display_objects.TurtleDisplay;

public class LayeredDisplay extends LayeredPanel {
    protected DisplayBox myDisplayBox;
    protected InformationTable myInformationTable;
    protected TurtleDisplay myTurtleDisplay;
    
    LayeredDisplay(int width, int height,TurtleDisplay turtledisplay, Controller controller){
        super();
        myTurtleDisplay=turtledisplay;
        setPreferredSize(new Dimension(width,height));
        setBorder(BorderFactory.createLineBorder(Color.black));
        myDisplayBox=new DisplayBox(width,height,myTurtleDisplay,controller);
        myDisplayBox.setBounds(0,0,width,height);
        myInformationTable=new InformationTable(200,110 ,myTurtleDisplay);
        myInformationTable.setBounds(0,0,200,110);
        add(myDisplayBox,JLayeredPane.DEFAULT_LAYER);
        myTurtleDisplay.addInformationTable(myInformationTable);
        add(myInformationTable,JLayeredPane.POPUP_LAYER);
        this.setOpaque(false);
//        myDisplayBox.set
    }
}
