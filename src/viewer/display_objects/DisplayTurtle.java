package viewer.display_objects;

import jgame.JGColor;
import jgame.JGObject;
import jgame.JGRectangle;
import jgame.impl.JGEngineInterface;

public class DisplayTurtle extends JGObject{
    private static final int TURTLE_SIZE=32;
    private static final int TURTLE_COLID=1;
    private static final String DISPLAY_TURTLE_NAME="display_turtle";
    private int myImageNumber;
    private double myRotation;
    
    protected JGColor myColor;
    protected JGEngineInterface myEngine;
    protected DisplayRect myBox;
    
    public DisplayTurtle (double x, double y, double direction) {
        super(DISPLAY_TURTLE_NAME, true, x-16, y-16, TURTLE_COLID,null);
        myBox=new DisplayRect(x,y,TURTLE_SIZE,TURTLE_SIZE,this);
        myColor=JGColor.black;
        myEngine=eng;
        myImageNumber=1;
        myRotation=direction;
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
    
    public void setPosition(double x,double y,double direction){
        setPos(x-16,y-16);
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
    public void paint() {}
    
}
