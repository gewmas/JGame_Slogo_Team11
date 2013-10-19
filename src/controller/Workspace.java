package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import model.expression.Expression;
import model.expression.ScopedExpression;

public class Workspace {

    private HashMap<String, Turtle> turtles;
    private List<Turtle> activeTurtles;

    private SlogoError error;
    
    private Map<String, Expression> definedFunction;
    private Map<String, Expression> runningFunction;
    private Map<String, Expression> globalVariables;
    
    private String backgroundColor;
    
    public Workspace(){
        turtles = new HashMap<String, Turtle>();
        activeTurtles = new ArrayList<Turtle>();
        
        //Assuming always one turtle created for user
        Turtle turtle = new DefaultTurtle();
        turtles.put(turtle.id, turtle);
        activeTurtles.add(turtle);
        
        definedFunction = new HashMap<String, Expression>();
        runningFunction = new HashMap<String, Expression>();
        globalVariables = new HashMap<String, Expression>();
                
    }
    
    public List<Turtle> getTurtles () {
        ArrayList<Turtle> turtleList = new ArrayList<Turtle>();
        for(Entry<String, Turtle> e : turtles.entrySet()){
            turtleList.add(e.getValue());
        }
        return turtleList;
    }
    
    public List<Turtle> getActiveTurtles() {
        return activeTurtles;
    }
    
    public void setActiveTurtle (List<String> turtleIds) {
        activeTurtles.clear();
        //Bad Method, Modify!
        for(Entry<String, Turtle> e : turtles.entrySet()){
            for(String s : turtleIds){
                if(e.getValue().getId().equals(s)){
                    activeTurtles.add(e.getValue());
                }
            }
        }
    }
    
    public void setEvenActiveTurtle () {
        ArrayList<String> newActive = new ArrayList<String>();
        for(Entry<String, Turtle> e : turtles.entrySet()){
            if((Integer.parseInt(e.getKey()) % 2) == 0) {
                newActive.add(e.getKey());
            }
        }
        setActiveTurtle(newActive);
    }
    
    public void setOddActiveTurtle () {
        ArrayList<String> newActive = new ArrayList<String>();
        for(Entry<String, Turtle> e : turtles.entrySet()){
            if((Integer.parseInt(e.getKey()) % 2) != 0) {
                newActive.add(e.getKey());
            }
        }
        setActiveTurtle(newActive);
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
    
    public void clear(){
        definedFunction.clear();
        runningFunction.clear();
        globalVariables.clear();
    }
    
}
