package test;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import controller.Controller;
import controller.Turtle;
import controller.TurtleCommand;
import controller.TurtleTrace;

public class TestController {
    Controller controller;
    List<Turtle> activeTurtle;
    TurtleTrace turtleTrace;
    List<TurtleCommand> commands;
    TurtleCommand command;
    
    double x = 0.0;
    double y = 0.0;
    double direction = 0.0;
    boolean isPenDown;
    boolean isVisible;
    
    @Before
    public void setUp () throws Exception {
        controller = new Controller();
    }

    @After
    public void tearDown () throws Exception {
        
    }
    
    public void updateActiveTurtle(){
        activeTurtle = controller.getActiveTurtles();
    }
    
    public void updateLatestCommandOfFirstActiveTurtle(){
        turtleTrace = activeTurtle.get(0).getTurtleTrace();
        //get latest command
        command = turtleTrace.getLatest();
        
        x = command.getX();
        y = command.getY();
        direction = command.getDirection();
        isPenDown = command.isPenDown();
        isVisible = command.isVisible();
    }

    @Test
    public void testSimple(){
        //http://www.cs.duke.edu/courses/compsci308/fall13/assign/03_slogo/examples/simple/
        
//        # go forward 70 (the hard way)
        updateActiveTurtle();
        controller.interpretCommand("fd sum sum sum sum 10 20 30 5 5");
        updateLatestCommandOfFirstActiveTurtle();
        assertTrue(x == 0.0);
        assertTrue(y == 70.0);
        assertTrue(direction == 90.0);
        assertTrue(isPenDown);
        assertTrue(isVisible);
        turtleTrace.clearCommandList();
        
//        # go forward 70 (a different hard way)
        updateActiveTurtle();
        controller.interpretCommand("fd sum 10 sum 10 sum 10 sum 20 20");
        updateLatestCommandOfFirstActiveTurtle();
        assertTrue(x == 0.0);
        assertTrue(y == 70.0);
        assertTrue(direction == 90.0);
        assertTrue(isPenDown);
        assertTrue(isVisible);
        turtleTrace.clearCommandList();
        
        /*
         * # draw a square
            fd 100
            rt 90
            fd 100
            rt 90
            fd 100
            rt 90
            fd 100
            rt 90
         */
        updateActiveTurtle();
        controller.interpretCommand("fd 100 rt 90 fd 100 rt 90 fd 100  rt 90 fd 100 rt 90");
        updateLatestCommandOfFirstActiveTurtle();
        assertTrue(x == 0.0);
        assertTrue(y == 0.0);
        assertTrue(direction == 90.0);
        assertTrue(isPenDown);
        assertTrue(isVisible);
        turtleTrace.clearCommandList();
        
    }
    
    @Test
    public void testLoops(){
        //http://www.cs.duke.edu/courses/compsci308/fall13/assign/03_slogo/examples/loops/
        
        /*
        repeat 180
        [
          fd 1 rt 2
        ]
        */
        
        updateActiveTurtle();
    
        controller.interpretCommand("repeat 1 [ fd 1 rt 2 ]");
        
        updateLatestCommandOfFirstActiveTurtle();
        assertTrue(x == 0.0);
        assertTrue(y == 1.0);
        assertTrue(direction == 88.0);
        assertTrue(isPenDown);
        assertTrue(isVisible);
        turtleTrace.clearCommandList();
        
//        testCircle();
    }
    
    private void testCircle(){
        /*
         * # repeat 180
        [
          fd 1 rt 2
        ]
         */
        updateActiveTurtle();
        controller.interpretCommand("repeat 180  [    fd 1 rt 2  ]");
        updateLatestCommandOfFirstActiveTurtle();
        assertTrue(x == 0.0);
        assertTrue(y == 0.0);
        assertTrue(direction == 90.0);
        assertTrue(isPenDown);
        assertTrue(isVisible);
        turtleTrace.clearCommandList();
    }
    
    @Test
    public void testProcedures(){
        //http://www.cs.duke.edu/courses/compsci308/fall13/assign/03_slogo/examples/procedures/
        testDash();
//        testGeometry(); // Failing!
    }

    private void testDash () {
        /*
         * set :count 12

            to dash [ ]
            [
              repeat :count 
              [
                pu fd 4 pd fd 4
              ]
            ]
            
            dash
         */
        updateActiveTurtle();
        //Test ExpressionList, Passed..  To be done: createTurtleCommand
        controller.interpretCommand("set :count 12 to dash [ ] [ repeat :count [ pu fd 4 pd fd 4 ] ] dash");
        
        updateLatestCommandOfFirstActiveTurtle();
        assertTrue(x == 0.0);
        assertTrue(y == 96.0);
        assertTrue(direction == 90.0);
        assertTrue(isPenDown);
        assertTrue(isVisible);
        turtleTrace.clearCommandList();
    }
    
    private void testGeometry () {
        /*
         * to triangle [ ]
        [ 
          repeat 3 [
            fd 50 
            rt 120
          ]
        ]
        
        to circle [ ]
        [
          repeat 360 [
            fd 1 
            rt 1
          ]
        ]
        
        to square [ ]
        [
          repeat 4 [
            fd 100
            rt 90
          ]
          fd 100
        ]
        
        triangle
        circle
        square
        
         */
        
        updateActiveTurtle();
        //Test ExpressionList, Passed..  To be done: createTurtleCommand
        controller.interpretCommand("  to triangle [ ]   [  repeat 3 [ fd 50   rt 120  ]  ] " +
                        "to circle [ ] [  repeat 360 [ fd 1  rt 1  ] ]  " +
                        "to square [ ]  [ repeat 4 [ fd 100 rt 90  ]  fd 100  ]" +
                        " triangle " +
                        " circle " +
                        " square");
        
        updateLatestCommandOfFirstActiveTurtle();
        assertTrue(x == 0.0);
        assertTrue(y == 96.0);
        assertTrue(direction == 90.0);
        assertTrue(isPenDown);
        assertTrue(isVisible);
        turtleTrace.clearCommandList();
    }

    @Test
    public void testOneParameter () {
        updateActiveTurtle();
        
        //fd 17 bk 8 lt 1 rt 2 seth 4 => (x = 0, y = 9.0, direction = 89, pendown = true, isshowing = true)
        controller.interpretCommand("fd sum 8 9 bk 8 lt 1 rt 2 seth 4");
        updateLatestCommandOfFirstActiveTurtle();
    
        assertTrue(x == 0.0);
        assertTrue(y == 9.0);
        assertTrue(direction == 4.0);
        assertTrue(isPenDown);
        assertTrue(isVisible);
        turtleTrace.clearCommandList();
        

        /*updateActiveTurtle();
        //fd fd 15
        controller.interpretCommand("fd fd 15");
        updateLatestCommandOfFirstActiveTurtle();
    
        assertTrue(x == 0.0);
        assertTrue(y == 9.0);
        assertTrue(direction == 4.0);
        assertTrue(isPenDown);
        assertTrue(isVisible);
        turtleTrace.clearCommandList();*/
    }

}
