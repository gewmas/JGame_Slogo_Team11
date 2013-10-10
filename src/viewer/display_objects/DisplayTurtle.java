package viewer.display_objects;

import jgame.JGColor;
import jgame.JGObject;
import jgame.impl.JGEngineInterface;

public class DisplayTurtle extends JGObject{
    
    private static final int TURTLE_COLID=1;
    private static final String DISPLAY_TURTLE_NAME="display_turtle";
    private int myImageNumber;
    private double myRotation;
    
    protected JGColor myColor;
    protected JGEngineInterface myEngine;
    
    public DisplayTurtle (double x,
                          double y) {
        super(DISPLAY_TURTLE_NAME, true, x-16, y-16, TURTLE_COLID,null);
        myColor=JGColor.blue;
        myEngine=eng;
        myImageNumber=1;
        myRotation=90;
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
        if (-45<=direction && direction<45) setGraphic("turtle"+myImageNumber+"right");
        if (45<=direction && direction<135) setGraphic("turtle"+myImageNumber+"up");
        if (135<=direction || direction<-135) setGraphic("turtle"+myImageNumber+"left");
        if (-135<=direction && direction<-45) setGraphic("turtle"+myImageNumber+"down");
        myRotation=direction;
    }
    
    public void setPosition(double x,double y){
        setPos(x-16,y-16);
    }
    
}
