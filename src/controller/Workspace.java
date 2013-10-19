package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import model.expression.Expression;
import model.expression.ScopedExpression;

public class Workspace {

    private List<Turtle> turtles;
    private List<Turtle> activeTurtles;

    private SlogoError error;
    
    private Map<String, Expression> definedFunction;
    private Map<String, Expression> runningFunction;
    private Map<String, Expression> globalVariables;
    
    private String backgroundColor;
    
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
    
    public Map<String, Expression> getDefinedFunction () {
        return definedFunction;
    }

    public Map<String, Expression> getRunningFunction () {
        return runningFunction;
    }

    public Map<String, Expression> getGlobalVariables () {
        return globalVariables;
    }
    
    public Map<String,  Map<String, Expression>> getLocalVariables () {
        Map<String,  Map<String, Expression>> allLocalVariables = new HashMap<String,  Map<String, Expression>>();
        
        //loop through all local variables in running function
        for(Entry<String, Expression> e : runningFunction.entrySet()){
           String functionId = e.getKey();
           
           ScopedExpression scopedExpression = (ScopedExpression) e.getValue();
           Map<String, Expression> functionLocalVariables = scopedExpression.getLocalVariables();
           
           allLocalVariables.put(functionId, functionLocalVariables);
        }
        
        return allLocalVariables;
    }

    public void setBackgroundColor (String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public String getBackgroundColor () {
        return backgroundColor;
    }
    
    public SlogoError getError () {
        return error;
    }

    public void setSlogoError (SlogoError error) {
        this.error = error;
    }
    
}
