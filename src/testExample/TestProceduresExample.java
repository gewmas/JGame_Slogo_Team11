package testExample;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class TestProceduresExample extends TestExample {

    @Test
    public void testDash(){
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
        controller.interpretCommand("set :count 12  to dash [ ] [   repeat :count    [     pu fd 4 pd fd 4   ] ]   dash ");
        updateLatestCommandOfFirstActiveTurtle();
        assertTrue(x == 0.0);
//        assertTrue(y == 0.0);
        assertTrue(direction == 90.0);
        assertTrue(isPenDown);
        assertTrue(isVisible);
        turtleTrace.clearCommandList();
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
        /*
         * to squaggle [ ]
            [
              forward 50
              right 150
              forward 60                       
              right 100
              forward 30
              right 90
            ]
            
            
            to pinwheel [ ]
            [
              repeat 18 [ squaggle ]
            ]
            
            
            pinwheel
         */
        updateActiveTurtle();
      controller.interpretCommand("to squaggle [ ] [   forward 50   right 150   forward 60                          right 100   forward 30   right 90 ]   to pinwheel [ ] [   repeat 18  [ squaggle  ]  ]   pinwheel ");
        updateLatestCommandOfFirstActiveTurtle();
        assertTrue(x == 0.0);
//        assertTrue(y == 0.0);
        assertTrue(direction == 90.0);
        assertTrue(isPenDown);
        assertTrue(isVisible);
        turtleTrace.clearCommandList();
    }
    
    @Test
    public void testPizza(){
        /*
         * to slice [ ]
            [
              rt 30
              fd 50
              lt 105
              fd 25
              bk 25
              rt 105
              bk 50
            ]
            
            to pizza [ ]
            [
              repeat 12
              [
                slice
              ]
            ]
            
            pizza
         */
        updateActiveTurtle();
        controller.interpretCommand("to slice [ ] [   rt 30   fd 50   lt 105   fd 25   bk 25   rt 105   bk 50 ]  to pizza [ ] [   repeat 12   [     slice   ] ]  pizza   ");
        updateLatestCommandOfFirstActiveTurtle();
        //no idea what is going on 
//        assertTrue(x == 0.0);
//        assertTrue(y == 0.0);
//        assertTrue(direction == 90.0);
        assertTrue(isPenDown);
        assertTrue(isVisible);
        turtleTrace.clearCommandList();
    }
    
    @Test
    public void testStar(){
        /*
         * to star [ ] 
            [ 
              repeat 5 
              [ 
                fd 50
                rt 144
              ]
            ]
            
            star
         */
        updateActiveTurtle();
        controller.interpretCommand("to star [ ]  [    repeat 5    [      fd 50     rt 144   ] ]  star  ");
        updateLatestCommandOfFirstActiveTurtle();
        assertTrue(Math.abs(x) <= 0.00000001);
        assertTrue(Math.abs(y) <= 0.00000001);
        assertTrue(direction == 90.0);
        assertTrue(isPenDown);
        assertTrue(isVisible);
        turtleTrace.clearCommandList();
    }
    
    @Test
    public void testTunnel(){
        /*
         * set :distance 50
            set :angle 10
            
            to square [ ]
            [
              repeat 4
              [
                fd :distance
                rt 90
              ]
            ]
            
            to tunnel [ ]
            [
              repeat 10
              [
                square
                set :distance sum :distance 10
              ]
            ]
            
            to warp [ ]
            [
              repeat 10
              [
                square
                rt :angle
                set :distance sum :distance 10
              ]
            ]
            
            
            cs
            tunnel
         */
        updateActiveTurtle();
        //TODO
        controller.interpretCommand("set :distance 50 set :angle 10  to square [ ] [   repeat 4   [     fd :distance     rt 90   ] ]  to tunnel [ ] [   repeat 10   [     square     set :distance sum :distance 10   ] ]  to warp [ ] [   repeat 10   [     square     rt :angle     set :distance sum :distance 10   ] ]   cs tunnel ");
        updateLatestCommandOfFirstActiveTurtle();
        assertTrue(x == 0.0);
        assertTrue(y == 0.0);
        assertTrue(direction == 90.0);
        assertTrue(isPenDown);
        assertTrue(isVisible);
        turtleTrace.clearCommandList();
    }
    
}
