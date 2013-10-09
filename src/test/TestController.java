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
