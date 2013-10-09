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

   
    
<<<<<<< HEAD
 
=======
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
>>>>>>> b35c2de86f655b29829ff34c024041b2aa7f28fc
    
   
    

    
    

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
