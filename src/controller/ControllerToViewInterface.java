package controller;

import java.util.List;

public interface ControllerToViewInterface {

    public void interpretCommand(String userInput);
    public List<Turtle> getTurtles ();
    
//    public void setBackgroundColor (String backgroundColor);
//    public String getBackgroundColor ();
}
