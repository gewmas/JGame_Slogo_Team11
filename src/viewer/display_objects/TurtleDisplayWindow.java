package viewer.display_objects;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import viewer.InformationTableBox;
import controller.Controller;
import controller.Turtle;
import controller.TurtleCommand;
import controller.TurtleTrace;
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
public abstract class TurtleDisplayWindow extends JGEngine {
    protected static final int ZERO_OFFSET=50;
    private static final int NUM_TILES_WIDTH=20;
    private static final int NUM_TILES_HEIGHT=20;
    private static final int NUM_GRID_X=20;
    private static final int NUM_GRID_Y=20;
    private static final String GRAPHICS_LINK="turtle_pics.tbl";
    
    protected List<DisplayPath> myPaths;
    protected double myWidth, myHeight;
    protected Controller myController;
    protected Map<String, DisplayTurtle> myActiveTurtles;
    protected Map<String, Integer> myTurtleCommandNumbers;
    protected DisplayGrid myGrid;
    protected JGColor myPenColor;
    protected boolean myHighlightTurtles;
    protected InformationTableBox myInfoTable;
    protected TurtleCommand myEndCommand;
    protected String myTrackedTurtle;
    protected int myTurtleImageNumber;

    /** The parameterless constructor is called by the browser, in case we're
     * an applet. */
    public TurtleDisplayWindow(Controller controller,InformationTableBox infotable) {
        this(new JGPoint(500,500),controller,infotable); 
    }

    /** We use a separate constructor for starting as an application. */
    public TurtleDisplayWindow(JGPoint size, Controller controller, InformationTableBox infotable) {
        myWidth=(int)(size.x/NUM_TILES_WIDTH)*(NUM_TILES_WIDTH);
        myHeight=(int)(size.y/NUM_TILES_HEIGHT)*(NUM_TILES_HEIGHT);
        myController=controller;
        myInfoTable=infotable;
        initEngineComponent(size.x,size.y); 
    }

    /** This method is called by the engine when it is ready to intialise the
     * canvas (for an applet, this is after the browser has called init()).
     * Note that applet parameters become available here and not
     * earlier (don't try to access them from within the parameterless
     * constructor!).  Use isApplet() to check if we started as an applet.
     */
    public void initCanvas() {
    	setCanvasSettings(
			(int) NUM_TILES_WIDTH,  // width of the canvas in tiles
			(int) NUM_TILES_HEIGHT,  // height of the canvas in tiles
			(int) myWidth/NUM_TILES_WIDTH,  // width of one tile
			(int) myHeight/NUM_TILES_WIDTH,  // height of one tile
			null,// foreground colour -> use default colour white
			JGColor.white,// background colour -> use default colour black
			null // standard font -> use default font
        );
    }

    /** This method is called when the engine has finished initialising and is
     * ready to produce frames.  Note that the engine logic runs in its own
     * thread, separate from the AWT event thread, which is used for painting
     * only.  This method is the first to be called from within its thread.
     * During this method, the game window shows the intro screen. */
    public void initGame() {
        setFrameRate(
            35,// 35 = frame rate, 35 frames per second
            2  //  2 = frame skip, skip at most 2 frames before displaying
        );
        defineMedia(GRAPHICS_LINK);
        myPenColor=JGColor.black;
        myPaths=new ArrayList<DisplayPath>();
        myActiveTurtles=new HashMap<String,DisplayTurtle>();
        myTurtleCommandNumbers=new HashMap<String,Integer>();
        myGrid=new DisplayGrid((int)(myWidth),(int)(myHeight),NUM_GRID_X,NUM_GRID_Y);
        myHighlightTurtles=false;
        myPenColor=JGColor.black;
        myTrackedTurtle="1";
        myTurtleImageNumber=1;
    }
        
    // Clears the screen of turtles, run when the user runs the clearscreen command
    public void clearScreen(){
        Point2D origin=getDisplayCoordinates(0,0);
        if(myPaths == null) return;
        for (DisplayPath path:myPaths){
            path.remove();
        }
        myPaths.clear();
        myTurtleCommandNumbers.clear();
        for (DisplayTurtle turtle:myActiveTurtles.values()){
            turtle.remove();
        }
        myActiveTurtles.clear();
    }
     
    // Converts coordinates from the model into coordinates in the game frame (origin in the center)    
    protected Point2D getDisplayCoordinates(double x, double y){
        return new Point2D.Double(myWidth/2+x,-y+myHeight-ZERO_OFFSET);
    }
       
    public void setTurtlePosition(String id,double x, double y,double direction){
        if (myActiveTurtles.containsKey(id)){
            myActiveTurtles.get(id).setPosition(x, y,direction);
        } else {
            myActiveTurtles.put(id, new DisplayTurtle(x, y,direction,myTurtleImageNumber));
        }
    }

    // Gets the list of turtles from the controller and draws new ones only
    private void drawTurtle(){
        try {
        	for (Turtle turtle : myController.getTurtles()) {
    	        List<TurtleCommand> myTurtleCommandList = turtle.getTurtleTrace().getCommandList();
    	        String turtleID=turtle.getId();
                if (!myTurtleCommandList.isEmpty()) {
                    int startingValue=0;
                    if (myTurtleCommandNumbers.containsKey(turtleID)) {
                        startingValue=myTurtleCommandNumbers.get(turtleID);
                    }
                    for (int i=startingValue+1;i<myTurtleCommandList.size();i++){
                        TurtleCommand lastCommand=myTurtleCommandList.get(i-1);
                        Point2D lastPos=getDisplayCoordinates(lastCommand.getX(),lastCommand.getY());
                        TurtleCommand thisCommand=myTurtleCommandList.get(i);
                        Point2D thisPos=getDisplayCoordinates(thisCommand.getX(),thisCommand.getY());
                        if (lastCommand.isPenDown()){
                        	myPaths.add(new DisplayPath(lastPos.getX(), 
                                                        lastPos.getY(),
                                                        thisPos.getX(),
                                                        thisPos.getY(),
                                                        lastCommand.getPenSize(),
                                                        myPenColor));
                        }
                    }
                    myEndCommand=myTurtleCommandList.get(myTurtleCommandList.size()-1);
                    Point2D endPos=getDisplayCoordinates(myEndCommand.getX(),myEndCommand.getY());
                    myTurtleCommandNumbers.put(turtleID,myTurtleCommandList.size()-1);
                    setTurtlePosition(turtleID,endPos.getX(),endPos.getY(),myEndCommand.getDirection());
                    if (myController.getActiveTurtles().contains(turtle) && myHighlightTurtles) {
                        myActiveTurtles.get(turtleID).activateBox();
                    } else {
                        myActiveTurtles.get(turtleID).suspendBox();
                    }
                    if (turtleID.equals(myTrackedTurtle)){
                        updateDataTable(myEndCommand);
                    }
                }
            }
        } catch (Exception e) {
        }
    }
        
    // Updates the GUI table for turtle data
    public void updateDataTable(TurtleCommand turtle){
        if (turtle!=null){
            myInfoTable.setTable(myTrackedTurtle,String.valueOf(turtle.getX()), String.valueOf(turtle.getY()),
                                 String.valueOf(turtle.getDirection()), String.valueOf(turtle.isPenDown()));
        }
    }
        
    /** Game logic is done here.  No painting can be done here, define
    * paintFrame to do that. */
    public void doFrame() {
        drawTurtle();
        moveObjects();
        myController.updateUserVariableBox();
        myController.updateUserDefinedCommandsBox();
    }
    
    public boolean isHighlightTurtles() {
    	return this.myHighlightTurtles;
    }
    
    public String getTrackedTurtle() {
    	return this.myTrackedTurtle;
    }
        
	/** Any graphics drawing beside objects or tiles should be done here.
     * Usually, only status / HUD information needs to be drawn here. */
    public void paintFrame() {}
}