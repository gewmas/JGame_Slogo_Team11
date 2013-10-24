package viewer.display_objects;

import controller.Controller;
import viewer.InformationTableBox;
import jgame.JGColor;
import jgame.JGPoint;

/** 
 * @author FrontEnd - Alex, Adam
 */
public class DefaultTurtleDisplayWindow extends TurtleDisplayWindow {
    /**
     * DefaultTurtleDisplayWindow is the JPanel extension of the JGame display of the turtle.
     * It contains all of the implementation specific methods used by the controller and other
     * classes.
     */

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