package viewer.display_objects;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import viewer.InformationTable;
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
 */
public abstract class TurtleDisplay extends JGEngine {
        private static final int ZERO_OFFSET=50;
        private static final int NUM_TILES_WIDTH=20;
        private static final int NUM_TILES_HEIGHT=20;
        private static final int NUM_GRID_X=20;
        private static final int NUM_GRID_Y=20;
    
        protected List<DisplayPath> myPaths;
        protected DisplayTurtle myDisplayTurtle;
        protected double myWidth, myHeight;
        protected Controller myController;
//        protected List<TurtleCommand> myTurtleCommandList;
        protected HashMap<String, DisplayTurtle> myActiveTurtles;
        protected HashMap<String, Integer> myTurtleCommandNumbers;
        protected int myTurtleNumber;
        protected DisplayGrid myGrid;
        protected JGColor myPenColor;
        protected boolean myHighlightTurtles;
        protected InformationTable myInfoTable;
        protected TurtleCommand endCommand;
        /** The parameterless constructor is called by the browser, in case we're
         * an applet. */
        public TurtleDisplay(Controller controller) {
                // This inits the engine as an applet.
                this(new JGPoint(500,500),controller); 
        }

        /** We use a separate constructor for starting as an application. */
        public TurtleDisplay(JGPoint size, Controller controller) {
            myWidth=(int)(size.x/NUM_TILES_WIDTH)*(NUM_TILES_WIDTH);
            myHeight=(int)(size.y/NUM_TILES_HEIGHT)*(NUM_TILES_HEIGHT);
            myController=controller;
            myTurtleNumber=1;
            // This inits the engine as an application.
            initEngineComponent(size.x,size.y); 
        }

        /** This method is called by the engine when it is ready to intialise the
         * canvas (for an applet, this is after the browser has called init()).
         * Note that applet parameters become available here and not
         * earlier (don't try to access them from within the parameterless
         * constructor!).  Use isApplet() to check if we started as an applet.
         */
        public void initCanvas() {
                // The only thing we need to do in this method is to tell the engine
                // what canvas settings to use.  We should not yet call any of the
                // other game engine methods here!
                setCanvasSettings(
                        (int) NUM_TILES_WIDTH,  // width of the canvas in tiles
                        (int) NUM_TILES_HEIGHT,  // height of the canvas in tiles
                        (int) myWidth/NUM_TILES_WIDTH,  // width of one tile
                        (int) myHeight/NUM_TILES_WIDTH,  // height of one tile
                             //    (note: total size = 20*16=320  x  15*16=240)
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
                // We can set the frame rate, load graphics, etc, at this point. 
                // (note that we can also do any of these later on if we wish)
                setFrameRate(
                        35,// 35 = frame rate, 35 frames per second
                        2  //  2 = frame skip, skip at most 2 frames before displaying
                           //      a frame again
                );
                defineMedia("turtle_pics.tbl");
                myPenColor=JGColor.black;
                myPaths=new ArrayList<DisplayPath>();
                Point2D thispoint=getDisplayCoordinates(0,0);
//                myDisplayTurtle=new DisplayTurtle(thispoint.getX(),thispoint.getY(),90);
                myActiveTurtles=new HashMap<String,DisplayTurtle>();
                myTurtleCommandNumbers=new HashMap<String,Integer>();
                //myDisplayTurtle.setGraphic("turtle1up");
                myGrid=new DisplayGrid((int)(myWidth),(int)(myHeight),NUM_GRID_X,NUM_GRID_Y);
                myHighlightTurtles=false;
                myPenColor=JGColor.black;
        }
        
        public void clearScreen(){
            Point2D origin=getDisplayCoordinates(0,0);
//            myDisplayTurtle.setPosition(origin.getX(), origin.getY(),90);
//            myDisplayTurtle.setRotation(90);
//            myTurtleCommandList.clear();
            for (DisplayPath path:myPaths){
                path.remove();
            }
            myPaths.clear();
//            myTurtleNumber=1;
            myTurtleCommandNumbers.clear();
            for (DisplayTurtle turtle:myActiveTurtles.values()){
                turtle.remove();
            }
            myActiveTurtles.clear();
            System.out.println("");
        }
        
        public void addPath(double x1, double y1, double x2, double y2){
            myPaths.add(new DisplayPath(x1,y1,x2,y2,myPenColor));
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
        
        public void highLightTurtles(boolean highlight){
            myHighlightTurtles=highlight;
        }
        
        protected Point2D getDisplayCoordinates(double x, double y){
            return new Point2D.Double(myWidth/2+x,-y+myHeight-ZERO_OFFSET);
        }
        
        public void setTurtlePosition(String id,double x, double y,double direction){
            if (myActiveTurtles.containsKey(id)){
                myActiveTurtles.get(id).setPosition(x, y,direction);
            } else {
                myActiveTurtles.put(id, new DisplayTurtle(x, y,direction));
            }
        }
        
        public void setTurtleImageNumber(int imageNum){
            for (DisplayTurtle turtle:myActiveTurtles.values()){
                turtle.setImageNumber(imageNum);
                turtle.setRotation(turtle.getRotation());
            }
        }

        private void drawTurtle(){
            try {
            	for (Turtle turtle : myController.getTurtles()) {
            	        List<TurtleCommand> myTurtleCommandList = turtle.getTurtleTrace().getCommandList();
			String turtleID=turtle.getId();
	                if (!myTurtleCommandList.isEmpty()) {
	                    int startingValue=0;
	                    if (myTurtleCommandNumbers.containsKey(turtleID)) {
	                        startingValue=myTurtleCommandNumbers.get(turtleID);
//	                        System.out.println(startingValue);
	                    }
	                    for (int i=startingValue+1;i<myTurtleCommandList.size();i++){
	                        TurtleCommand lastCommand=myTurtleCommandList.get(i-1);
	                        Point2D lastPos=getDisplayCoordinates(lastCommand.getX(),lastCommand.getY());
	                        TurtleCommand thisCommand=myTurtleCommandList.get(i);
	                        Point2D thisPos=getDisplayCoordinates(thisCommand.getX(),thisCommand.getY());
//	                        System.out.println(i);
//	                        if (lastCommand.isPenDown()){
	                            //System.out.println(lastCommand.getX()+" "+lastCommand.getY()+" "+thisCommand.getX()+" "+thisCommand.getY());
	                            myPaths.add(new DisplayPath(lastPos.getX(), 
	                                                        lastPos.getY(),
	                                                        thisPos.getX(),
	                                                        thisPos.getY(),
	                                                        myPenColor));
//	                        }
	                    }
	                    endCommand=myTurtleCommandList.get(myTurtleCommandList.size()-1);
	                    Point2D endPos=getDisplayCoordinates(endCommand.getX(),endCommand.getY());
	                    myTurtleCommandNumbers.put(turtleID,myTurtleCommandList.size()-1);
	                    setTurtlePosition(turtleID,endPos.getX(),endPos.getY(),endCommand.getDirection());
//	                    myDisplayTurtle.setRotation(endCommand.getDirection());
	                    if (endCommand.isActive() && myHighlightTurtles) myDisplayTurtle.activateBox();
	                    else myDisplayTurtle.suspendBox();
	                }
                }
            } catch (Exception e){

            }
        }
        
        public void updateDataTable(){
            if (endCommand!=null){
                myInfoTable.setTable("0",String.valueOf(endCommand.getX()), String.valueOf(endCommand.getY())
                                     , String.valueOf(endCommand.getDirection()), String.valueOf(endCommand.isPenDown()));
            }
        }
        
        public void addInformationTable(InformationTable table){
            myInfoTable=table;
        }
        
        public void highlightActiveTurtles(){
            for (DisplayTurtle myTurtle:myActiveTurtles.values()){
                myTurtle.suspendBox();
            }
            if (myHighlightTurtles){
                for (Turtle turtle:myController.getActiveTurtles()){
                    myActiveTurtles.get(Integer.parseInt(turtle.getId())).activateBox();
                }
            }
        }
        
        /** Game logic is done here.  No painting can be done here, define
        * paintFrame to do that. */
        public void doFrame() {
            drawTurtle();
            updateDataTable();
            highlightActiveTurtles();
            moveObjects();
        }
        
        /** Any graphics drawing beside objects or tiles should be done here.
         * Usually, only status / HUD information needs to be drawn here. */
        public void paintFrame() {
                
        }
}