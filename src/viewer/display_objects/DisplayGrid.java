package viewer.display_objects;

import jgame.JGColor;
import jgame.JGObject;
import jgame.impl.JGEngineInterface;

public class DisplayGrid extends JGObject{
    private static final int GRID_COLID=4;
    private static final double GRID_THICKNESS=2;
    private static final JGColor GRID_COLOR=JGColor.blue;
    protected int myDisplayWidth;
    protected int myDisplayHeight;
    protected int myHorizontalSeparation;
    protected int myVerticalSeparation;
    protected JGEngineInterface myEngine;
    
    public DisplayGrid(int displayWidth, int displayHeight,int numHorizontal, int numVertical){
        super("Grid", true, displayWidth/2, displayHeight/2, GRID_COLID,null);
        myDisplayWidth=displayWidth;
        myDisplayHeight=displayHeight;
        myHorizontalSeparation=myDisplayWidth/numHorizontal;
        myVerticalSeparation=myDisplayWidth/numVertical;
        myEngine=eng;
        //System.out.println(myDisplayWidth + " " + myDisplayHeight);
        resume_in_view=false;
        suspend();
    }
    
    public void toggleOn(){
        if (is_suspended){
            resume();
        } else {
            suspend();
        }
    }
    
    @Override
    public void move(){
        
    }    
    
    @Override
    public void paint(){
        //Draw horizontal lines
        for (int row=myVerticalSeparation;row<myEngine.pfHeight();row+=myVerticalSeparation){
            myEngine.drawLine(0, row,myEngine.pfWidth(),row,GRID_THICKNESS,GRID_COLOR);
        }
        for (int col=myHorizontalSeparation;col<myEngine.pfWidth();col+=myHorizontalSeparation){
            myEngine.drawLine(col,0,col,myEngine.pfHeight(),GRID_THICKNESS,GRID_COLOR);
        }
    }
    
    
}
