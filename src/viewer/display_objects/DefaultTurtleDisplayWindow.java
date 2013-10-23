package viewer.display_objects;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import controller.Controller;
import controller.Turtle;
import controller.TurtleCommand;
import controller.TurtleTrace;
import viewer.InformationTableBox;
import jgame.JGColor;
import jgame.JGPoint;
import jgame.platform.JGEngine;


/** Tutorial example 1: a minimal program.  A "bare skeleton" program
 * displaying a moving text "hello world".
 *
 * In order to run as both applet and application, you need to define a main()
 * method (this is the entry point for an application) and a parameterless
 * constructor (this is the entry point for an applet).  We use a second
 * constructor with a size parameter to initialise the engine as an
 * application.
 *
 * @author FrontEnd - Alex, Adam
 */
public class DefaultTurtleDisplayWindow extends TurtleDisplayWindow {
        private static final int ZERO_OFFSET=50;
    
	public DefaultTurtleDisplayWindow(Controller controller,InformationTableBox infotable) {
		this(new JGPoint(500,500),controller,infotable); 
	}

	/** We use a separate constructor for starting as an application. */
	public DefaultTurtleDisplayWindow(JGPoint size, Controller controller,InformationTableBox infotable) {
		super(size,controller,infotable); 
	}
	
	public void addPath(double x1, double y1, double x2, double y2,double size){
            myPaths.add(new DisplayPath(x1,y1,x2,y2,size,myPenColor));
        }
        
    public void setBackGroundColor(JGColor color){
        setBGColor(color);
    }
    
    public void setPenColor(JGColor color){
        myPenColor=color;
    }
    
//        public void setPenSize(double pensize){
//            myPenSize=pensize;
//        }
    
    public void toggleGrid(){
        myGrid.toggleOn();
    }
    
    public void toggleHighLightTurtles(){
        myHighlightTurtles=!myHighlightTurtles;
    }
    
    public boolean isHighlightTurtles() {
    	return this.myHighlightTurtles;
    }
    
    public void setTrackedTurtle(String turtleNum){
        myTrackedTurtle=turtleNum;
    }
    
    public void setTurtleImageNumber(int imageNum){
        myTurtleImageNumber=imageNum;
        if (myActiveTurtles!=null){
            for (DisplayTurtle turtle:myActiveTurtles.values()){
                turtle.setImageNumber(imageNum);
                turtle.setRotation(turtle.getRotation());
            }
        }
    }
    
    public int getTurtleImageNumber() {
        return myActiveTurtles.get("1").getImageNumber();
    }
}