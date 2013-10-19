package controller;

public abstract class Turtle {
    String id;
    TurtleTrace turtleTrace;
    
    public Turtle(){
        turtleTrace = new TurtleTrace();
        id = "1";
    }

    public TurtleTrace getTurtleTrace () {
        return turtleTrace;
    }

    public String getId () {
        return id;
    }
   
}
