package testExample;

import static org.junit.Assert.assertTrue;
import org.junit.Test;


public class TestSimpleExample extends TestExample {

    @Test
    public void testForwardComplex () {
        // http://www.cs.duke.edu/courses/compsci308/fall13/assign/03_slogo/examples/simple/

        // # go forward 70 (the hard way)
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
    public void testForwardComplex2 () {
        // # go forward 70 (a different hard way)
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
    public void testForwardForward () {
        // # go forward 100
        // fd fd 50
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
    public void testForwardRandom () {
        // # go forward between 1 and 100
        // fd sum 1 random 100
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
    public void testGrid () {
        // # draw upper right quadrant # draw upper left quadrant # draw lower left quadrant # draw
        // lower right quadrant
        updateActiveTurtle();
        controller
                .interpretCommand("fd 100 rt 90 fd 100 rt 90 fd 100 rt 90 fd 100  fd 100 rt 90 fd 100 rt 90 fd 100 rt 90 fd 100  fd 100 rt 90 fd 100 rt 90 fd 100 rt 90 fd 100  fd 100 rt 90 fd 100 rt 90 fd 100 rt 90 fd 100  ");
        updateLatestCommandOfFirstActiveTurtle();
        assertTrue(x == 0.0);
        assertTrue(y == 0.0);
        assertTrue(direction == 90.0);
        assertTrue(isPenDown);
        assertTrue(isVisible);
        turtleTrace.clearCommandList();
    }

    @Test
    public void testRandomFun () {
        /*
         * fd sum 1 random 100
         * rt random 360
         * fd product random 10 sum 1 random 10
         * lt random 360
         */
        updateActiveTurtle();
        controller
                .interpretCommand("fd sum 1 random 100             rt random 360             fd product random 10 sum 1 random 10             lt random 360  ");
        updateLatestCommandOfFirstActiveTurtle();
        // no idea where the turtle will go
        // assertTrue(x == 0.0);
        // assertTrue(y == 0.0);
        // assertTrue(direction == 90.0);
        assertTrue(isPenDown);
        assertTrue(isVisible);
        turtleTrace.clearCommandList();

    }

    @Test
    public void testRandomFunLots () {
        /*
         * # random fun repeated a lot
            fd sum 1 random 100
            rt random 360
            fd product random 10 sum 1 random 10
            lt random 360
            
            fd sum 1 random 100
            rt random 360
            fd product random 10 sum 1 random 10
            lt random 360
            
            fd sum 1 random 100
            rt random 360
            fd product random 10 sum 1 random 10
            lt random 360
            
            fd sum 1 random 100
            rt random 360
            fd product random 10 sum 1 random 10
            lt random 360
            
            fd sum 1 random 100
            rt random 360
            fd product random 10 sum 1 random 10
            lt random 360
            
            fd sum 1 random 100
            rt random 360
            fd product random 10 sum 1 random 10
            lt random 360
            
            fd sum 1 random 100
            rt random 360
            fd product random 10 sum 1 random 10
            lt random 360
            
            fd sum 1 random 100
            rt random 360
            fd product random 10 sum 1 random 10
            lt random 360
            
            fd sum 1 random 100
            rt random 360
            fd product random 10 sum 1 random 10
            lt random 360
            
            fd sum 1 random 100
            rt random 360
            fd product random 10 sum 1 random 10
            lt random 360
            
            fd sum 1 random 100
            rt random 360
            fd product random 10 sum 1 random 10
            lt random 360
            
            fd sum 1 random 100
            rt random 360
            fd product random 10 sum 1 random 10
            lt random 360
            
            fd sum 1 random 100
            rt random 360
            fd product random 10 sum 1 random 10
            lt random 360
            
            fd sum 1 random 100
            rt random 360
            fd product random 10 sum 1 random 10
            lt random 360
            
            fd sum 1 random 100
            rt random 360
            fd product random 10 sum 1 random 10
            lt random 360
            
            fd sum 1 random 100
            rt random 360
            fd product random 10 sum 1 random 10
            lt random 360
            
            fd sum 1 random 100
            rt random 360
            fd product random 10 sum 1 random 10
            lt random 360
            
            fd sum 1 random 100
            rt random 360
            fd product random 10 sum 1 random 10
            lt random 360
            
            fd sum 1 random 100
            rt random 360
            fd product random 10 sum 1 random 10
            lt random 360
            
            fd sum 1 random 100
            rt random 360
            fd product random 10 sum 1 random 10
            lt random 360
         */
        updateActiveTurtle();
        controller
                .interpretCommand("fd sum 1 random 100 rt random 360 fd product random 10 sum 1 random 10 lt random 360  fd sum 1 random 100 rt random 360 fd product random 10 sum 1 random 10 lt random 360  fd sum 1 random 100 rt random 360 fd product random 10 sum 1 random 10 lt random 360  fd sum 1 random 100 rt random 360 fd product random 10 sum 1 random 10 lt random 360  fd sum 1 random 100 rt random 360 fd product random 10 sum 1 random 10 lt random 360  fd sum 1 random 100 rt random 360 fd product random 10 sum 1 random 10 lt random 360  fd sum 1 random 100 rt random 360 fd product random 10 sum 1 random 10 lt random 360  fd sum 1 random 100 rt random 360 fd product random 10 sum 1 random 10 lt random 360  fd sum 1 random 100 rt random 360 fd product random 10 sum 1 random 10 lt random 360  fd sum 1 random 100 rt random 360 fd product random 10 sum 1 random 10 lt random 360  fd sum 1 random 100 rt random 360 fd product random 10 sum 1 random 10 lt random 360  fd sum 1 random 100 rt random 360 fd product random 10 sum 1 random 10 lt random 360  fd sum 1 random 100 rt random 360 fd product random 10 sum 1 random 10 lt random 360  fd sum 1 random 100 rt random 360 fd product random 10 sum 1 random 10 lt random 360  fd sum 1 random 100 rt random 360 fd product random 10 sum 1 random 10 lt random 360  fd sum 1 random 100 rt random 360 fd product random 10 sum 1 random 10 lt random 360  fd sum 1 random 100 rt random 360 fd product random 10 sum 1 random 10 lt random 360  fd sum 1 random 100 rt random 360 fd product random 10 sum 1 random 10 lt random 360  fd sum 1 random 100 rt random 360 fd product random 10 sum 1 random 10 lt random 360  fd sum 1 random 100 rt random 360 fd product random 10 sum 1 random 10 lt random 360  ");
        updateLatestCommandOfFirstActiveTurtle();
//        assertTrue(x == 0.0);
//        assertTrue(y == 0.0);
//        assertTrue(direction == 90.0);
        assertTrue(isPenDown);
        assertTrue(isVisible);
        turtleTrace.clearCommandList();
    }

    @Test
    public void testSuare () {
        /*
         * # draw a square
         * fd 100
         * rt 90
         * fd 100
         * rt 90
         * fd 100
         * rt 90
         * fd 100
         * rt 90
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

    @Test
    public void testSquareCentered () {
        /*
         * # move to side of square
            pu
            fd 50
            rt 90
            
            # draw square
            pd
            fd 50
            rt 90
            fd 100
            rt 90
            fd 100
            rt 90
            fd 100
            rt 90
            fd 50
            
            # move back to center
            pu
            home
         */
        updateActiveTurtle();
        controller.interpretCommand("pu             fd 50             rt 90                          pd             fd 50             rt 90             fd 100             rt 90             fd 100             rt 90             fd 100             rt 90             fd 50                          pu             home  ");
        updateLatestCommandOfFirstActiveTurtle();
        assertTrue(x == 0.0);
        assertTrue(y == 0.0);
        assertTrue(direction == 0.0);
        assertTrue(!isPenDown);
        assertTrue(isVisible);
        turtleTrace.clearCommandList();
    }

    @Test
    public void testTriangle () {
        /*
         * fd 50
            rt 120
            fd 100
            rt 120
            fd 100
            rt 120
            fd 50
         */
        updateActiveTurtle();
        controller.interpretCommand("fd 50             rt 120             fd 100             rt 120             fd 100             rt 120             fd 50 ");
        updateLatestCommandOfFirstActiveTurtle();
        assertTrue(x == 0.0);
        assertTrue(y == 0.0);
        assertTrue(direction == 90.0);
        assertTrue(isPenDown);
        assertTrue(isVisible);
        turtleTrace.clearCommandList();
    }

}
