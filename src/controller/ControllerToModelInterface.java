package controller;

import java.util.List;

public interface ControllerToModelInterface {
    public List<Turtle> getActiveTurtles();
//    public void setActiveTurtle (List<String> turtleIds);
    
    
    //Turtle queries function call
    public void clearScreen();
    public void xCor();
    public void yCor();
    public void heading();
    public void isPenDown();
    public void isShowing();
}
