package controller;

public abstract class Turtle {
    String id;
    TurtleTrace turtleTrace;
    
    public Turtle(){
        this("1");
    }
    
    public Turtle(String id){
        turtleTrace = new TurtleTrace();
        this.id = id;
    }

    public TurtleTrace getTurtleTrace () {
        return turtleTrace;
    }

    public String getId () {
        return id;
    }
    
    public void clearTurtleTrace(){
        turtleTrace.clearCommandList();
    }
   
}
