package viewer.display_objects;

import jgame.JGObject;
import jgame.impl.JGEngineInterface;


public class DisplayRect extends JGObject {
    private static final String RECTANGLE_NAME="turtle_rect";
    private static final int RECTANGLE_COLID=1;
    private static final int RECTANGLE_THICKNESS=2;
    
    protected JGEngineInterface myEngine;
    protected double myWidth;
    protected double myHeight;
    protected DisplayTurtle myTurtle;

    public DisplayRect (double x, double y,double width, double height, DisplayTurtle turtle) {
        super(RECTANGLE_NAME, true, x, y, RECTANGLE_COLID, null);
        myTurtle=turtle;
        myEngine=eng;
        myWidth=width;
        myHeight=height;
        this.resume_in_view=false;
    }

    public void setSize (double width, double height) {
        myWidth = width;
        myHeight = height;
    }

    @Override
    public void paint() {
        myEngine.drawRect(myTurtle.getLastX(), myTurtle.getLastY(), myWidth, myHeight, false, false, RECTANGLE_THICKNESS, myTurtle.getColor());
    }
}
