package controller;

public class DefaultTurtle extends Turtle {

    String color;
    
    public DefaultTurtle(){
        super();
    }
    
    public void setTurtleColor(String color){
        this.color = color;
    }
    
    public String getTurtleColor(){
        return color;
    }
    
}
