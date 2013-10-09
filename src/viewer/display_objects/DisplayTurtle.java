package viewer.display_objects;

import jgame.JGColor;
import jgame.JGObject;
import jgame.impl.JGEngineInterface;

public class DisplayTurtle extends JGObject{

    private static final int TURTLE_COLID=1;
    private static final String DISPLAY_TURTLE_NAME="display_turtle";
    private static final int TURTLE_RADIUS=20;
    
    protected JGColor myColor;
    protected JGEngineInterface myEngine;
    
    public DisplayTurtle (double x,
                          double y) {
        super(DISPLAY_TURTLE_NAME, true, x, y, TURTLE_COLID,null);
        myColor=JGColor.blue;
        myEngine=eng;
    }
    
    public void move(){
    }
    
    public void setPosition(double x,double y){
        setPos(x,y);
    }
    
    public void paint(){
        myEngine.drawOval(x,y,TURTLE_RADIUS,TURTLE_RADIUS,true,true, 5, myColor);
    }
    
}
