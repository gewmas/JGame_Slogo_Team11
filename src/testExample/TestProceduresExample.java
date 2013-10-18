package testExample;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class TestProceduresExample extends TestExample {

    @Test
    public void testDash(){
      //TODO
        /*
         * 
         */

    }
    
    @Test
    public void testGeometry () {
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
        controller.interpretCommand("to triangle [ ]   [  repeat 3 [ fd 50   rt 120  ]  ] " +
                        "to circle [ ] [  repeat 360 [ fd 1  rt 1  ] ]  " +
                        "to square [ ]  [ repeat 4 [ fd 100 rt 90  ]  fd 100  ]" +
                        " triangle " +
                        " circle " +
                        " square");
        
        updateLatestCommandOfFirstActiveTurtle();
        assertTrue(x == 0.0);
        assertTrue(y == 100.0);
        assertTrue(direction == 90.0);
        assertTrue(isPenDown);
        assertTrue(isVisible);
        turtleTrace.clearCommandList();
    }
    
    @Test
    public void testPinwheel(){
      //TODO
        /*
         * 
         */

    }
    
    @Test
    public void testPizza(){
      //TODO
        /*
         * 
         */

    }
    
    @Test
    public void testStar(){
      //TODO
        /*
         * 
         */

    }
    
    @Test
    public void testTunnel(){
      //TODO
        /*
         * 
         */

    }
    
}
