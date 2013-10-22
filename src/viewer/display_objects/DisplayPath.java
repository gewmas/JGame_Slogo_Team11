package viewer.display_objects;

import jgame.JGColor;
import jgame.JGObject;
import jgame.impl.JGEngineInterface;

public class DisplayPath extends JGObject{

    private static final int PATH_COLID=2;
    private static final double PATH_THICKNESS=2;
    private static final String DISPLAY_PATH_NAME="display_path";
    
    protected JGColor myColor;
    protected JGEngineInterface myEngine;
    protected double myStartX,myStartY,myEndX,myEndY;
    
    public DisplayPath (double x1,
                          double y1,double x2,double y2,double penSize,JGColor color) {
        super(DISPLAY_PATH_NAME, true, x1, y1, PATH_COLID,null);
        myColor=color;
        myEngine=eng;
        myStartX=x1;
        myStartY=y1;
        myEndX=x2;
        myEndY=y2;
    }
    
    public void move(){
    }
    
    public void paint(){
        myEngine.drawLine(myStartX,myStartY,myEndX,myEndY,PATH_THICKNESS, myColor);
    }
    
}
