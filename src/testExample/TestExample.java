package testExample;

import static org.junit.Assert.assertTrue;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import controller.Controller;
import controller.Turtle;
import controller.TurtleCommand;
import controller.TurtleTrace;

public class TestExample {
    Controller controller;
    List<Turtle> activeTurtle;
    TurtleTrace turtleTrace;
    List<TurtleCommand> commands;
    TurtleCommand command;
    
    double x = 0.0;
    double y = 0.0;
    double direction = 0.0;
    boolean isPenDown;
    boolean isVisible;
    
    @Before
    public void setUp () throws Exception {
        controller = new Controller();
    }

    @After
    public void tearDown () throws Exception {
        
    }
    
    public void updateActiveTurtle(){
        controller.clearWorkspace();
        activeTurtle = controller.getActiveTurtles();
    }
    
    public void updateLatestCommandOfFirstActiveTurtle(){
        turtleTrace = activeTurtle.get(0).getTurtleTrace();
        //get latest command
        command = turtleTrace.getLatest();
        
        x = command.getX();
        y = command.getY();
        direction = command.getDirection();
        isPenDown = command.isPenDown();
        isVisible = command.isVisible();
    }
    
   
}
