package controller;

import java.util.List;
import java.util.Map;
import model.expression.Expression;

public interface ControllerToModelInterface {
    public List<Turtle> getActiveTurtles();
//    public void setActiveTurtle (List<String> turtleIds);
    public Map<String, Expression> getDefinedFunction();
    public Map<String, Expression> getRunningFunction ();
    public Map<String, Expression> getGlobalVariables();
    public Map<String, Map<String, Expression>> getLocalVariables();
    
    
    //Turtle queries function call
    public void clearScreen();
    public void xCor();
    public void yCor();
    public void heading();
    public void isPenDown();
    public void isShowing();
    public void penColor ();
    public void turtleShape ();
}
