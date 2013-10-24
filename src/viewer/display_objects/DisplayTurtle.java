package viewer.display_objects;

import jgame.JGColor;
import jgame.JGObject;
import jgame.JGRectangle;
import jgame.impl.JGEngineInterface;

/**
 * @author FrontEnd - Alex, Adam
 */
public class DisplayTurtle extends JGObject{
    private static final int TURTLE_SIZE=32;
    private static final int TURTLE_COLID=1;
    // As JGame paints the object with the top left corner at the position,
    // we must offset the position of the object so that it paints in the correct
    // position. This isn't a problem since we don't care where the turtle is in the game.
    // Also, turtles may have different sizes when facing up and left.
    private static final int[] TURTLE_UP_OFFSETS={16,16,11,16,16,10};
    private static final int[] TURTLE_LEFT_OFFSETS={16,16,16,10};
    private static final String DISPLAY_TURTLE_NAME="display_turtle";
    private int[] offsets;
    private int myImageNumber;
    private double myRotation;
    
    protected JGColor myColor;
    protected JGEngineInterface myEngine;
    protected DisplayHighlightRect myBox;
    
    /**
     * DisplayTurtle objects are the visible turtles in the display for users to see the results of their commands
     * @param x is the initial x-coordinate
     * @param y is the initial y-coordinate
     * @param direction is the initial angular direction
     */
    public DisplayTurtle (double x, double y, double direction, int imageNum) {
        super(DISPLAY_TURTLE_NAME, true, x-TURTLE_UP_OFFSETS[2*(imageNum-1)], y-TURTLE_UP_OFFSETS[2*(imageNum-1)+1], TURTLE_COLID,null);
        myBox=new DisplayHighlightRect(x,y,TURTLE_SIZE,TURTLE_SIZE,this);
        myColor=JGColor.black;
        myEngine=eng;
        myImageNumber=imageNum;
        myRotation=direction;
        offsets=TURTLE_UP_OFFSETS;
        setRotation(myRotation);
    }
        
    public double getRotation(){
        return myRotation;
    }
    
    public int getImageNumber () {
        return myImageNumber;
    }

    public void setImageNumber (int imageNumber) {
        this.myImageNumber = imageNumber;
    }
    
    public void setRotation(double direction){
        if (-45<=direction && direction<45) {
            setGraphic("turtle"+myImageNumber+"right");
            offsets=TURTLE_LEFT_OFFSETS;
        }
        if (45<=direction && direction<135) {
            setGraphic("turtle"+myImageNumber+"up");
            offsets=TURTLE_UP_OFFSETS;
        }
        if (135<=direction || direction<-135) {
            setGraphic("turtle"+myImageNumber+"left");
            offsets=TURTLE_LEFT_OFFSETS;
        }
        if (-135<=direction && direction<-45) {
            setGraphic("turtle"+myImageNumber+"down");
            offsets=TURTLE_UP_OFFSETS;
        }
        myRotation=direction;
    }
    
    public void setPosition(double x,double y,double direction){
        setPos(x-offsets[2*(myImageNumber-1)],y-offsets[2*(myImageNumber-1)+1]);
        setRotation(direction);
    }
    
    public void activateBox(){
        myBox.resume();
    }
    
    public void suspendBox(){
        myBox.suspend();
    }
    
    public JGColor getColor(){
        return myColor;
    }
    
    @Override
    public void remove(){
        myBox.remove();
        super.remove();
    }
    
    @Override
    public void paint() {}
    
}
