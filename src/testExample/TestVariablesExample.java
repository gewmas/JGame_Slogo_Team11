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
    
    
    @Test
    public void testSquare(){

        /*
         * make :distance 50

            fd :distance
            rt 90
            fd :distance
            rt 90
            fd :distance
            rt 90
            fd :distance
            rt 90
         */
        
        updateActiveTurtle();
        controller.interpretCommand("make :distance 50              fd :distance             rt 90             fd :distance             rt 90             fd :distance             rt 90             fd :distance             rt 90 ");
        updateLatestCommandOfFirstActiveTurtle();
        assertTrue(x == 0.0);
        assertTrue(y == 0.0);
        assertTrue(direction == 90.0);
        assertTrue(isPenDown);
        assertTrue(isVisible);
        turtleTrace.clearCommandList();

    }
    
    @Test
    public void testSquareCentered(){

        /*
         * make :distance 100

            # move to side of square
            pu
            fd quotient :distance 2
            rt 90
            
            # draw square
            pd
            fd quotient :distance 2
            rt 90
            fd :distance
            rt 90
            fd :distance
            rt 90
            fd :distance
            rt 90
            fd quotient :distance 2
            
            # move back to center
            pu
            home
         */

        updateActiveTurtle();
        controller.interpretCommand("make :distance 100              pu             fd quotient :distance 2             rt 90                          pd             fd quotient :distance 2             rt 90             fd :distance             rt 90             fd :distance             rt 90             fd :distance             rt 90             fd quotient :distance 2                          pu             home");
        updateLatestCommandOfFirstActiveTurtle();
        assertTrue(x == 0.0);
        assertTrue(y == 0.0);
        assertTrue(direction == 0.0);
        assertTrue(!isPenDown);
        assertTrue(isVisible);
        turtleTrace.clearCommandList();
    }
    
    @Test
    public void testSquareRandom(){

        /*
         * make :random sum 1 random 100

            fd :random
            rt 90
            fd :random
            rt 90
            fd :random
            rt 90
            fd :random
            rt 90
         */

        updateActiveTurtle();
        controller.interpretCommand("make :random sum 1 random 100              fd :random             rt 90             fd :random             rt 90             fd :random             rt 90             fd :random             rt 90 ");
        updateLatestCommandOfFirstActiveTurtle();
//        assertTrue(x == 0.0);
//        assertTrue(y == 0.0);
        assertTrue(direction == 90.0);
        assertTrue(isPenDown);
        assertTrue(isVisible);
        turtleTrace.clearCommandList();
    }
}
