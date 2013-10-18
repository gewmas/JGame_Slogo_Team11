package controller;

import java.util.ArrayList;
import java.util.List;

public class Workspace {

    List<Turtle> turtles;
    List<Turtle> activeTurtles;
    
    String backgroundColor;
    
    public Workspace(){
        turtles = new ArrayList<Turtle>();
        activeTurtles = new ArrayList<Turtle>();
        
        //Assuming always one turtle created for user
        Turtle turtle = new DefaultTurtle();
        turtles.add(turtle);
        activeTurtles.add(turtle);
    }
    
    public List<Turtle> getTurtles () {
        return turtles;
    }
    
    public List<Turtle> getActiveTurtles() {
        return activeTurtles;
    }
    
    public void setActiveTurtle (List<String> turtleIds) {
        activeTurtles.clear();
        //Bad Method, Modify!
        for(Turtle turtle : turtles){
            for(String s : turtleIds){
                if(turtle.getId().equals(s)){
                    activeTurtles.add(turtle);
                }
            }
        }
    }
    
    public void setBackgroundColor (String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public String getBackgroundColor () {
        return backgroundColor;
    }
    
}
