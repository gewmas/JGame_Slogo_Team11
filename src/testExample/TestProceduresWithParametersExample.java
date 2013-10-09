package testExample;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class TestProceduresWithParametersExample extends TestExample {
    
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
        controller.interpretCommand("to square [ :distance ]         [           repeat 4 [             fd :distance             rt 90           ]         ]                           to face [ ]         [           pendown square 100           penup forward 20           right 90 forward 25           pendown forward 50           penup back 75           left 90 forward 65           right 90 forward 20           pendown square 15           penup forward 45           pendown square 15                      penup back 15           right 90 forward 20 left 45           pendown square 20         ]                           face       ");
        
        updateLatestCommandOfFirstActiveTurtle();
        assertTrue(x == 0.0);
        assertTrue(y == 100.0);
        assertTrue(direction == 90.0);
        assertTrue(isPenDown);
        assertTrue(isVisible);
        turtleTrace.clearCommandList();
    }
}
