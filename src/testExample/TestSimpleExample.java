package testExample;

import static org.junit.Assert.assertTrue;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import controller.Controller;
import controller.Turtle;
import controller.TurtleCommand;
import controller.TurtleTrace;

public class TestSimpleExample extends TestExample{
    
    @Test
    public void testForwardComplex(){
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
    }

    @Test
    public void testForwardComplex2(){
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
    }
    
    
    @Test
    public void testForwardForward(){
//        # go forward 100
//        fd fd 50
        updateActiveTurtle();
        controller.interpretCommand("fd fd fd fd 50");
        updateLatestCommandOfFirstActiveTurtle();
        assertTrue(x == 0.0);
        assertTrue(y == 200.0);
        assertTrue(direction == 90.0);
        assertTrue(isPenDown);
        assertTrue(isVisible);
        turtleTrace.clearCommandList();
    }
    
    @Test
    public void testForwardRandom(){
//        # go forward between 1 and 100
//        fd sum 1 random 100
        updateActiveTurtle();
        controller.interpretCommand("fd sum 1 random 100");
        updateLatestCommandOfFirstActiveTurtle();
        assertTrue(x == 0.0);
        assertTrue(y >= 1 && y <= 100);
        assertTrue(direction == 90.0);
        assertTrue(isPenDown);
        assertTrue(isVisible);
        turtleTrace.clearCommandList();
    }
    
    @Test
    public void testSuare(){
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
    
}
