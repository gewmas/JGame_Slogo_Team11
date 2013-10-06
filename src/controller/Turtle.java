package controller;

public abstract class Turtle {
    String id;
    TurtleTrace turtleTrace;
    
    public Turtle(){
        turtleTrace = new TurtleTrace();
    }

    public TurtleTrace getTurtleTrace () {
        return turtleTrace;
    }

    public String getId () {
        return id;
    }
   
}
