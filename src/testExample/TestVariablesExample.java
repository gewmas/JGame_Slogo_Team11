package testExample;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class TestVariablesExample extends TestExample{

    @Test
    public void testFdRandom(){
        //http://www.cs.duke.edu/courses/compsci308/fall13/assign/03_slogo/examples/simple/
        
//        make :random sum 1 random 100
//        fd :random
        updateActiveTurtle();
        controller.interpretCommand("make :random sum 1 random 100   fd :random");
        updateLatestCommandOfFirstActiveTurtle();
        assertTrue(x == 0.0);
        assertTrue(y >= 1 && y <= 101);
        assertTrue(direction == 90.0);
        assertTrue(isPenDown);
        assertTrue(isVisible);
        turtleTrace.clearCommandList();
    }
    
}
