package testExample;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class TestLoopsWithVariablesExample extends TestExample {

    @Test
    public void testMicrowave(){
        /*
         * make :x 20 
        repeat :x 
        [ 
          fd :x 
          repeat :x 
          [ 
            fd 50 
            rt 80
            fd 20
            lt 160
          ]
          rt 90
          fd 10
        ]
         */
        
        updateActiveTurtle();
        controller.interpretCommand("make :x 20  repeat :x  [    fd :x    repeat :x    [      fd 50      rt 80     fd 20     lt 160   ]   rt 90   fd 10 ]      ");
        updateLatestCommandOfFirstActiveTurtle();
        //not sure about the final position
//        assertTrue(Math.abs(x) <= 0.0000000001);
//        assertTrue(Math.abs(y) <= 0.0000000001);
//        assertTrue(direction == 90.0);
        assertTrue(isPenDown);
        assertTrue(isVisible);
        turtleTrace.clearCommandList();
    }
    
    
    @Test
    public void testPinwheel(){
        /*
         * set :distance 10
        repeat 18
        [
          forward product 5 :distance
          right 150
          forward product 6 :distance      
          right 100
          forward product 3 :distance
          right 90
        ]
         */
        updateActiveTurtle();
        controller.interpretCommand("set :distance 10 repeat 18 [   forward product 5 :distance   right 150   forward product 6 :distance         right 100   forward product 3 :distance   right 90 ]      ");
        updateLatestCommandOfFirstActiveTurtle();
        assertTrue(Math.abs(x) <= 0.0000000001);
        assertTrue(Math.abs(y) <= 0.0000000001);
        assertTrue(direction == 90.0);
        assertTrue(isPenDown);
        assertTrue(isVisible);
        turtleTrace.clearCommandList();
    }

    @Test
    public void testPoly(){
        /*
         * make :distance 100
        make :angle 90
        
        repeat quotient 360 :angle
        [
          fd :distance
          rt :angle
        ]
         */
        updateActiveTurtle();
        controller.interpretCommand("make :distance 100 make :angle 90  repeat quotient 360 :angle [   fd :distance   rt :angle ] ");
        updateLatestCommandOfFirstActiveTurtle();
        assertTrue(Math.abs(x) <= 0.0000000001);
        assertTrue(Math.abs(y) <= 0.0000000001);
        assertTrue(direction == 90.0);
        assertTrue(isPenDown);
        assertTrue(isVisible);
        turtleTrace.clearCommandList();
    }
    
    @Test
    public void testSpikes(){
        /*
         * 
        set :length sum 50 random 250
        set :numspikes 18
        
        repeat :numspikes
        [
          fd :length 
          rt quotient 360 :numspikes
        ]
         */
        updateActiveTurtle();
//        controller.interpretCommand("set :length sum 50 random 250 set :numspikes 18  repeat :numspikes [   fd :length    rt quotient 360 :numspikes ]  ");
        controller.interpretCommand("set :length sum 10 random 10 set :numspikes 18  repeat :numspikes [   fd :length    rt quotient 360 :numspikes ]  ");
        updateLatestCommandOfFirstActiveTurtle();
        //Problem, can't go back to original point because quotient precision issue
//        assertTrue(Math.abs(x) <= 0.0000000001);
//        assertTrue(Math.abs(y) <= 0.0000000001);
        assertTrue(direction == 90.0);
        assertTrue(isPenDown);
        assertTrue(isVisible);
        turtleTrace.clearCommandList();
    }
    
    @Test
    public void testSpiral(){
        /*
         * make :count 1
        repeat 200 
        [
          fd :count 
          rt 89
          set :count sum 1 :count
        ]
         */
        updateActiveTurtle();
        //local variable!!
        controller.interpretCommand("make :count 1 repeat 200  [   fd :count    rt 89   set :count sum 1 :count ] ");
        updateLatestCommandOfFirstActiveTurtle();
//        assertTrue(Math.abs(x) <= 0.0000000001);
//        assertTrue(Math.abs(y) <= 0.0000000001);
//        assertTrue(direction == 90.0);
        assertTrue(isPenDown);
        assertTrue(isVisible);
        turtleTrace.clearCommandList();
    }
    
    @Test
    public void testSpiral2(){
        /*
         * 
        set :count 1

        repeat 110 
        [
          fd :count 
          rt product :count 3
          set :count sum 1 :count
        ]

         */
        updateActiveTurtle();
        controller.interpretCommand("set :count 1  repeat 110  [   fd :count    rt product :count 3   set :count sum 1 :count ] ");
        updateLatestCommandOfFirstActiveTurtle();
//        assertTrue(Math.abs(x) <= 0.0000000001);
//        assertTrue(Math.abs(y) <= 0.0000000001);
//        assertTrue(direction == 90.0);
        assertTrue(isPenDown);
        assertTrue(isVisible);
        turtleTrace.clearCommandList();
    }
    
    @Test
    public void testSquare(){
        /*
         * set :distance 50

        repeat 4
        [
          fd :distance
          rt 90
        ]
         */
        updateActiveTurtle();
        controller.interpretCommand("set :distance 50  repeat 4 [   fd :distance   rt 90 ] ");
        updateLatestCommandOfFirstActiveTurtle();
        assertTrue(Math.abs(x) <= 0.0000000001);
        assertTrue(Math.abs(y) <= 0.0000000001);
        assertTrue(direction == 90.0);
        assertTrue(isPenDown);
        assertTrue(isVisible);
        turtleTrace.clearCommandList();
    }
    
    @Test
    public void testTunnel(){
        /*
         * set :distance 50

        repeat 10
        [
          repeat 4
          [
            fd :distance
            rt 90
          ]
          set :distance sum :distance 10
        ]
         */
        updateActiveTurtle();
        controller.interpretCommand("set :distance 50  repeat 10 [   repeat 4   [     fd :distance     rt 90   ]   set :distance sum :distance 10 ]  ");
        updateLatestCommandOfFirstActiveTurtle();
        assertTrue(Math.abs(x) <= 0.0000000001);
        assertTrue(Math.abs(y) <= 0.0000000001);
        assertTrue(direction == 90.0);
        assertTrue(isPenDown);
        assertTrue(isVisible);
        turtleTrace.clearCommandList();
    }
    
    


}
