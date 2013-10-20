package controller;

import java.util.List;
import jgame.JGColor;

public interface ControllerToViewInterface {

    public void interpretCommand(String userInput);
    public List<Turtle> getTurtles ();
    
    public void setBackgroundColor (JGColor backgroundColor);
    public JGColor getBackgroundColor ();
}
