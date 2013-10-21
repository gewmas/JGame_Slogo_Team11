package testExample;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class TestProceduresWithParametersExample extends TestExample {
    
    @Test
    public void testDash(){
        /*
         * to dash [ :count ]
        [
          repeat :count 
          [
            pu fd 4 pd fd 4
          ]      
        ]
        
        dash 1
         */
        updateActiveTurtle();
        controller.interpretCommand("to dash [ :count ]         [           repeat :count            [             pu fd 4 pd fd 4           ]               ]   dash  10"); 
        updateLatestCommandOfFirstActiveTurtle();
//        assertTrue(x == 0.0);
//        assertTrue(y == 100.0);
        assertTrue(direction == 90.0);
        assertTrue(isPenDown);
        assertTrue(isVisible);
        turtleTrace.clearCommandList();
    }
    
    @Test
    public void testFace () {
        /*
         * 
         * to square [ :distance ]
        [
          repeat 4 [
            fd :distance
            rt 90
          ]
        ]
        
        
        to face [ ]
        [
          pendown square 100
          penup forward 20
          right 90 forward 25
          pendown forward 50
          penup back 75
          left 90 forward 65
          right 90 forward 20
          pendown square 15
          penup forward 45
          pendown square 15           
          penup back 15
          right 90 forward 20 left 45
          pendown square 20
        ]
        
        
        face
        
         */
        
        updateActiveTurtle();
        //Test ExpressionList, Passed..  To be done: createTurtleCommand
        controller.interpretCommand("to square [  :distance  ]         [           repeat 4 [             fd :distance             rt 90           ]         ]                           to face [ ]         [           pendown square 100           penup forward 20           right 90 forward 25           pendown forward 50           penup back 75           left 90 forward 65           right 90 forward 20           pendown square 15           penup forward 45           pendown square 15                      penup back 15           right 90 forward 20 left 45           pendown square 20         ]                           face       ");
        
        updateLatestCommandOfFirstActiveTurtle();
//        assertTrue(x == 0.0);
//        assertTrue(y == 100.0);
//        assertTrue(direction == 0.0);
        assertTrue(isPenDown);
        assertTrue(isVisible);
        turtleTrace.clearCommandList();
    }
    
    @Test
    public void testFlower(){
      //TODO
        /*
         * to arc [ :incr :degrees ]
        [
          repeat quotient :degrees 2
          [
            fd :incr rt 2
          ]
        ]
        
        to petal [ :size ]
        [
          repeat 2
          [
            arc :size 60
            rt 120
          ]
        ]
        
        to flower [ :length ]
        [
          repeat 6
          [
            petal :length
            rt 60
          ]
        ]
        
        
        flower 100

         */
        updateActiveTurtle();
        controller.interpretCommand("to arc [ :incr :degrees ] [   repeat quotient :degrees 2   [     fd :incr rt 2   ] ]  to petal [ :size ] [   repeat 2   [     arc :size 60     rt 120   ] ]  to flower [ :length ] [   repeat 6   [     petal :length     rt 60   ] ]   flower 100 ");
        updateLatestCommandOfFirstActiveTurtle();
        assertTrue(x == 0.0);
        assertTrue(y == 100.0);
        assertTrue(direction == 90.0);
        assertTrue(isPenDown);
        assertTrue(isVisible);
        turtleTrace.clearCommandList();
    }
    
    @Test
    public void testHouse(){
      //TODO
        /*
         * to poly [ :numsides :length ]
        [
          repeat :numsides
          [
            fd :length 
            rt quotient 360 :numsides
          ]
        ]
        
        to square [ :side ]
        [
          poly 4 :side
        ]
        
        to triangle [ :side ]
        [
          poly 3 :side
        ]
        
        
        to house [ :size ]
        [
          square :size
          fd :size rt 30
          triangle :size
        ]
        
        
        house
         */
        updateActiveTurtle();
        controller.interpretCommand("to poly [ :numsides :length ] [   repeat :numsides   [     fd :length      rt quotient 360 :numsides   ] ]  to square [ :side ] [   poly 4 :side ]  to triangle [ :side ] [   poly 3 :side ]   to house [ :size ] [   square :size   fd :size rt 30   triangle :size ]   house ");
        updateLatestCommandOfFirstActiveTurtle();
        assertTrue(x == 0.0);
        assertTrue(y == 100.0);
        assertTrue(direction == 90.0);
        assertTrue(isPenDown);
        assertTrue(isVisible);
        turtleTrace.clearCommandList();
    }
    
    @Test
    public void testPolyFun(){
      //TODO
        /*
         * to poly [ :length :angle ]
            [
              repeat 100
              [
                fd :length 
                rt :angle
              ]
            ]
            
            
            to outlinepoly [ :length :angle ]
            [
              repeat 100
              [
                fd :length 
                rt :angle
                fd :length 
                rt product 2 :angle
              ]
            ]
            
            
            # try these
            # outlinepoly 50 45
            # outlinepoly 50 125
            # outlinepoly 50 144
            
            # poly 50 60
            # poly 50 135
            # poly 50 144
         */
        updateActiveTurtle();
        controller.interpretCommand("to poly [ :length :angle ]             [               repeat 100               [                 fd :length                  rt :angle               ]             ]                                       to outlinepoly [ :length :angle ]             [               repeat 100               [                 fd :length                  rt :angle                 fd :length                  rt product 2 :angle               ]             ]   "
                                    + "   outlinepoly 50 45 ");
        updateLatestCommandOfFirstActiveTurtle();
        assertTrue(x == 0.0);
        assertTrue(y == 100.0);
        assertTrue(direction == 90.0);
        assertTrue(isPenDown);
        assertTrue(isVisible);
        turtleTrace.clearCommandList();
    }
    
    @Test
    public void testRandomRange(){
      //TODO
        /*
         * to random_in_range [ :min :max ]
        [
          random sum :min sum 1 difference :max :min
        ]
        
        
        to random_move [ :fdmin :fdmax :ltmin :ltmax ]
        [
          repeat 100
          [
            lt random_in_range :ltmin :ltmax
            fd random_in_range :fdmin :fdmax
          ]
        ]
        
        
        random_move 5 15 -10 5

         */
        updateActiveTurtle();
        controller.interpretCommand("to random_in_range [ :min :max ] [   random sum :min sum 1 difference :max :min ]   to random_move [ :fdmin :fdmax :ltmin :ltmax ] [   repeat 100   [     lt random_in_range :ltmin :ltmax     fd random_in_range :fdmin :fdmax   ] ]   random_move 20 50 -45 45  ");
        updateLatestCommandOfFirstActiveTurtle();
        assertTrue(x == 0.0);
        assertTrue(y == 100.0);
        assertTrue(direction == 90.0);
        assertTrue(isPenDown);
        assertTrue(isVisible);
        turtleTrace.clearCommandList();
    }
    
    @Test
    public void testRegularShape(){
      //TODO
        /*
         * to regularShape [ :distance :angle ]
        [
          repeat quotient 360 :angle
          [
            fd :distance
            rt :angle
          ]
        ]
        
        cs
        regularShape

         */
        updateActiveTurtle();
        controller.interpretCommand("to regularShape [ :distance :angle ] [   repeat quotient 360 :angle   [     fd :distance     rt :angle   ] ]  cs regularShape  ");
        updateLatestCommandOfFirstActiveTurtle();
        assertTrue(x == 0.0);
        assertTrue(y == 100.0);
        assertTrue(direction == 90.0);
        assertTrue(isPenDown);
        assertTrue(isVisible);
        turtleTrace.clearCommandList();
    }
    
    @Test
    public void testSquare(){
      //TODO
        /*
         * to square [ :distance ]
        [
          repeat 4 [
            fd :distance
            rt 90
          ]
        ]
        
        sqaure 10

         */
        updateActiveTurtle();
        controller.interpretCommand("to square [ :distance ]         [           repeat 4 [             fd :distance             rt 90           ]         ]                  sqaure 10  ");
        updateLatestCommandOfFirstActiveTurtle();
        assertTrue(x == 0.0);
        assertTrue(y == 100.0);
        assertTrue(direction == 90.0);
        assertTrue(isPenDown);
        assertTrue(isVisible);
        turtleTrace.clearCommandList();
    }
}
