package testExample;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class TestLoopsExample extends TestExample {

    @Test
    public void testCircle(){

//      repeat 180
//      [
//      fd 1 rt 2
//      ]
        updateActiveTurtle();
        controller.interpretCommand("repeat 180   [  fd 1 rt 2  ] ");
        updateLatestCommandOfFirstActiveTurtle();
        assertTrue(Math.abs(x) <= 0.0000000001);
        assertTrue(Math.abs(y) <= 0.0000000001);
        assertTrue(direction == 90.0);
        assertTrue(isPenDown);
        assertTrue(isVisible);
        turtleTrace.clearCommandList();
    }

    @Test
    public void testCircles () {
        /*
         * 
         * repeat 9
            [
             repeat 180
                [
                    fd 1 rt 2
                ]       
             rt 40
            ]
         */
        updateActiveTurtle();
        //Test ExpressionList, Passed..  To be done: createTurtleCommand
        controller.interpretCommand("repeat 9 [ repeat 180 [ fd 1 rt 2 ] rt 40 ]");

        updateLatestCommandOfFirstActiveTurtle();
        assertTrue(Math.abs(x) <= 0.0000000001);
        assertTrue(Math.abs(y) <= 0.0000000001);
        assertTrue(direction == 90.0);
        assertTrue(isPenDown);
        assertTrue(isVisible);
        turtleTrace.clearCommandList();
    }
    
    @Test
    public void doubleTriangle () {
        /*
         * 
         * setxy -300 0
           repeat 8
           [
              forward 50
              repeat 3
               [
                fd 50
                rt 120
               ]
            ]

            setxy -300 0
            repeat 8
            [
              forward 50
              repeat 3
              [
                fd 50
                lt 120
               ]
            ]
         */
        updateActiveTurtle();
        //Test ExpressionList, Passed..  To be done: createTurtleCommand
//        controller.interpretCommand("setxy -300 0 repeat 8 [ forward 50 repeat 3 [ fd 50 rt 120 ] ] setxy -300 0 repeat 8 [ forward 50 repeat 3 [ fd 50 lt 120 ] ]");
//
//        updateLatestCommandOfFirstActiveTurtle();
//        assertTrue(Math.abs(x) <= 0.0000000001);
//        assertTrue(Math.abs(y) <= 0.0000000001);
//        assertTrue(direction == 90.0);
//        assertTrue(isPenDown);
//        assertTrue(isVisible);
//        turtleTrace.clearCommandList();
    }

    @Test
    public void testDash () {
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


}
