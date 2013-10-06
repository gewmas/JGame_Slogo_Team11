package controller;

import java.util.List;

public abstract class Controller {
    List<Turtle> turtles;
    List<Turtle> activeTurtle;
    //AGColor backgroundColor;
    
    // Take the commands typed by the user and updates the TurtleTrace accordingly.
    public abstract void interpretCommand (String userInput);

    // Returns the active TurtleTrace object which is outlined below
    public abstract TurtleTrace getTurtleTrace();

    // Getters and setters of turtle so turtle object never directly manipulated by view
    public abstract void setTurtleColor();
    public abstract void getTurtleColor();
    public abstract void setTurtlePenUp();
    public abstract void setTurtlePenDown();
    public abstract void setTurtleImage();
    public abstract void getTurtleImage();
    public abstract void getTurtlePenColor();
    public abstract void setTurtlePenColor();

    // Additional getters/setters
    public abstract void setBackgroundColor();
    //public abstract AGColor getBackgroundColor();
    public abstract void setActiveTurtle(int turtleId);
    
    
}
