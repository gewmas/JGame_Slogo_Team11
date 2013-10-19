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
   

    @Test
    public void testDoubleTriangle () {
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
        controller.interpretCommand("setxy -300 0 repeat 8 [ forward 50 repeat 3 [ fd 50 rt 120 ] ] setxy -300 0 repeat 8 [ forward 50 repeat 3 [ fd 50 lt 120 ] ]");

        updateLatestCommandOfFirstActiveTurtle();
        assertTrue(x == -300.0);
        assertTrue(y == 400.0);
        assertTrue(direction == 90.0);
        assertTrue(isPenDown);
        assertTrue(isVisible);
        turtleTrace.clearCommandList();
    }

    @Test
    public void testDragon(){
        /*
         * repeat 4
        [
          fd 100
          rt 90
          fd 100
          rt 90
          fd 50
          rt 90
          fd 50
          rt 90
          fd 100
          rt 90
          fd 25
          rt 90
          fd 25
          rt 90
          fd 50
        ]
         */
        updateActiveTurtle();
        controller.interpretCommand("repeat 4 [   fd 100   rt 90   fd 100   rt 90   fd 50   rt 90   fd 50   rt 90   fd 100   rt 90   fd 25   rt 90   fd 25   rt 90   fd 50 ] ");
        updateLatestCommandOfFirstActiveTurtle();
        assertTrue(x == 0.0);
        assertTrue(y == 0.0);
        assertTrue(direction == 90.0);
        assertTrue(isPenDown);
        assertTrue(isVisible);
        turtleTrace.clearCommandList();

    }
    
    @Test
    public void testFlower(){
        /*
         * repeat 6
        [
          repeat 2
          [
            repeat 30
            [
              fd 1
              rt 2
            ]
            rt 120
          ]
          rt 60
        ]
         */
        updateActiveTurtle();
        controller.interpretCommand("repeat 6         [           repeat 2           [             repeat 30             [               fd 1               rt 2             ]             rt 120           ]           rt 60         ]  ");
        updateLatestCommandOfFirstActiveTurtle();
        assertTrue(Math.abs(x) <= 0.000001);
        assertTrue(Math.abs(y) <= 0.000001);
        assertTrue(direction == 90.0);
        assertTrue(isPenDown);
        assertTrue(isVisible);
        turtleTrace.clearCommandList();

    }
    
    @Test
    public void testPinwheel(){
        /*
         * repeat 18
        [
          forward 50
          right 150
          forward 60                       
          right 100
          forward 30
          right 90
        ]
         */
        updateActiveTurtle();
        controller.interpretCommand("repeat 18 [   forward 50   right 150   forward 60                          right 100   forward 30   right 90 ]   ");
        updateLatestCommandOfFirstActiveTurtle();
        assertTrue(Math.abs(x) <= 0.000001);
        assertTrue(Math.abs(y) <= 0.000001);
        assertTrue(direction == 90.0);
        assertTrue(isPenDown);
        assertTrue(isVisible);
        turtleTrace.clearCommandList();
    }
    
    @Test
    public void testRandom(){
        /*
         * repeat 16 
        [
          fd random 500
          rt random 360
        ]
         */
        updateActiveTurtle();
        controller.interpretCommand("repeat 16  [   fd random 500   rt random 360 ]  ");
        updateLatestCommandOfFirstActiveTurtle();
//        assertTrue(Math.abs(x) <= 0.000001);
//        assertTrue(Math.abs(y) <= 0.000001);
//        assertTrue(direction == 90.0);
        assertTrue(isPenDown);
        assertTrue(isVisible);
        turtleTrace.clearCommandList();
    }
    
    @Test
    public void testSpiroSmall(){
        /*
         * home

        repeat 30 
        [
          repeat 20 
          [
            fd 10
            rt 10
          ]
          repeat 10
          [
            fd 20
            rt 100
          ]
        ]
         */
        updateActiveTurtle();
        controller.interpretCommand("home  repeat 30  [   repeat 20    [     fd 10     rt 10   ]   repeat 10   [     fd 20     rt 100   ] ] ");
        updateLatestCommandOfFirstActiveTurtle();
        assertTrue(Math.abs(x) <= 0.000001);
        assertTrue(Math.abs(y) <= 0.000001);
        assertTrue(direction == 90.0);
        assertTrue(isPenDown);
        assertTrue(isVisible);
        turtleTrace.clearCommandList();
    }

    @Test
    public void testStar(){
        /*
         * repeat 5 
        [ 
          fd 50
          rt 144
        ]
         */
        updateActiveTurtle();
        controller.interpretCommand("repeat 5  [    fd 50   rt 144 ]  ");
        updateLatestCommandOfFirstActiveTurtle();
        assertTrue(Math.abs(x) <= 0.000001);
        assertTrue(Math.abs(y) <= 0.000001);
        assertTrue(direction == 90.0);
        assertTrue(isPenDown);
        assertTrue(isVisible);
        turtleTrace.clearCommandList();
    }
    
    @Test
    public void testStop(){
        /*
         * repeat 8 [
          fd 10
          rt 45
        ]
         */
        updateActiveTurtle();
        controller.interpretCommand("repeat 8 [   fd 10   rt 45 ]  ");
        updateLatestCommandOfFirstActiveTurtle();
        assertTrue(Math.abs(x) <= 0.000001);
        assertTrue(Math.abs(y) <= 0.000001);
        assertTrue(direction == 90.0);
        assertTrue(isPenDown);
        assertTrue(isVisible);
        turtleTrace.clearCommandList();
    }
    
}
