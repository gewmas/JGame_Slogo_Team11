package controller;

/**
 * Default turtle represented by color
 * 
 * @author Yuhua, Fabio
 */
public class DefaultTurtle extends Turtle {

    String color;
    
    public DefaultTurtle(){
        super();
    }
    
    public DefaultTurtle(String id){
        super(id);
    }
    
    public void setTurtleColor(String color){
        this.color = color;
    }
    
    public String getTurtleColor(){
        return color;
    }
    
}
