package test;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import viewer.SLogoViewer;
import viewer.Viewer;
import controller.Controller;
import controller.Turtle;
import controller.TurtleCommand;
import controller.TurtleTrace;

public class TestViewer {
//    private static final String[] DEFAULTPARAMETERS=new String[]{"1","0.0","0.0","90.0","true"};
    Controller controller=new Controller();
    Viewer viewer=controller.getViewer();
    List<Turtle> activeTurtle;
    
    @Before
    public void setUp () throws Exception {
//        controller= new Controller();
//        viewer=controller.getViewer();
    }

    @After
    public void tearDown () throws Exception {
        
    }
    
    // Get the latest active turtle from the model
    public void updateActiveTurtle(){
        activeTurtle = controller.getActiveTurtles();
    }
    
    //Get parameters of the turtle in the model
    public String[] getParamOfModelTurtle(){
        updateActiveTurtle();
        if (activeTurtle==null) {
            return null;
        }
        TurtleTrace turtleTrace = activeTurtle.get(0).getTurtleTrace();
        //get latest command
        TurtleCommand command = turtleTrace.getLatest();
        String turtleID=activeTurtle.get(0).getId();
        
        return new String[]{turtleID,
                            String.valueOf(command.getX()),
                            String.valueOf(command.getY()),
                            String.valueOf(command.getDirection()),
                            String.valueOf(command.isPenDown())};
    }
    
    //Get parameters of active turtle in the viewer
    public String[] getTurtleParameters(String[] defaultParams){
        String[] turtleParameters=null;
        // Wait until the turtle has been generated and moved away from the position specified
        // by defaultParams
        while (turtleParameters==null || compareStringArray(turtleParameters,defaultParams)){
           String[] paramReference=((SLogoViewer)viewer).getTurtleParameters();
           if (paramReference!=null) {
               turtleParameters=paramReference.clone();
           }
           System.out.println(turtleParameters);
        }
        return turtleParameters;
    }
    
    //Compare two String[] arrays to ensure that they are equal
    public boolean compareStringArray(String[] array1, String[] array2){
        if (array1.length!=array2.length) return false;
        for (int i=0;i<array1.length;i++){
            if (!array1[i].equals(array2[i])) return false;
        }
        return true;
    }
    
    // Reset the screen
    public void reset(){
        String command="clearscreen";
        controller.addCommand(command);
    }
    
    // Main testing method
    // Gets the latest parameters from the model and viewer and compares
    // them.
    public String[] assertCorrectDisplayTurtle(String[] defaultParams){
        String[] turtleParameters=getTurtleParameters(defaultParams);
        String[] correctParameters=null;
        while (correctParameters==null){
            correctParameters=getParamOfModelTurtle();
        }
        assertTrue(turtleParameters.length==5);
        assertTrue(turtleParameters[0].equals(correctParameters[0]));
        assertTrue(turtleParameters[1].equals(correctParameters[1]));
        assertTrue(turtleParameters[2].equals(correctParameters[2]));
        assertTrue(turtleParameters[3].equals(correctParameters[3]));
        assertTrue(turtleParameters[4].equals(correctParameters[4]));
        return turtleParameters;
    }
    // All tests need to be in one method, as each new test method will create a new
    // instance of jgame, but jgame is static so later tests will not work.
    @Test
    public void testViewer(){
        // Test that the turtle is created correctly
        String[] lastParam=assertCorrectDisplayTurtle(new String[]{});
        String command="fd 100";
        //Test turtle movement
        controller.addCommand(command);
        lastParam=assertCorrectDisplayTurtle(lastParam);
        //Test turtle rotation
        controller.addCommand("rt 90");
        lastParam=assertCorrectDisplayTurtle(lastParam);
        //Test turtle pen
        controller.addCommand("penup");
        lastParam=assertCorrectDisplayTurtle(lastParam);
    }
}
