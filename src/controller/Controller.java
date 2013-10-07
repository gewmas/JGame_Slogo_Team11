package controller;

import java.util.ArrayList;
import java.util.List;
import model.DefaultModel;
import model.Model;


public class Controller {
    Model model;
    // View view;

    List<Turtle> turtles;
    List<Turtle> activeTurtles;
    String backgroundColor;

    public Controller () {
        model = new DefaultModel(this);
        turtles = new ArrayList<Turtle>();
        activeTurtles = new ArrayList<Turtle>();
        
        //Assuming always one turtle created for user
        Turtle turtle = new DefaultTurtle();
        turtles.add(turtle);
        activeTurtles.add(turtle);
    }

    // Take the commands typed by the user and updates the TurtleTrace accordingly.
    public void interpretCommand(String userInput) {
        model.updateTrace(userInput);
        // view.paintFrame(getTurtleTraces);
    }

    public List<Turtle> getTurtles () {
        return turtles;
    }

    // public abstract AGColor getBackgroundColor();
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

    public List<Turtle> getActiveTurtles() {
        return activeTurtles;
    }
    
    

    // Returns the active TurtleTrace object which is outlined below
//    private List<TurtleTrace> getTurtleTraces () {
//        List<TurtleTrace> turtleTraces = new ArrayList<TurtleTrace>();
//
//        for (Turtle turtle : turtles) {
//            turtleTraces.add(turtle.getTurtleTrace());
//        }
//
//        return turtleTraces;
//    }

    // Additional getters/setters
    public void setBackgroundColor (String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public String getBackgroundColor () {
        return backgroundColor;
    }
    
    public static void main(String[] args){
        Controller controller = new Controller();
//        controller.interpretCommand("fd sum 8 9 bk 8 lt 1 rt 2 seth 4");
        controller.interpretCommand("to method [ :x ] [ fd :x ] method 10");
    }
    
    /* public static void main(String[] args){
    //      List<String> commandInput = new ArrayList<String>(Arrays.asList("sum", "sum", "2", "sum", "1", "sum", "5", "sum", "8", "9", "10"));
    //      List<String> commandInput = new ArrayList<String>(Arrays.asList("sum", "9", "10"));

    //      List<String> commandInput = new ArrayList<String>(Arrays.asList("fd", "sum", "sum", "2", "sum", "1", "sum", "5", "sum", "8", "9", "10"));
    
    
    DefaultModel model = new DefaultModel();
//    model.updateTrace("sum sum 2 sum 1 sum 5 sum 8 9 10");
    model.updateTrace("fd sum sum 2 sum 1 sum 5 sum 8 9 10");
//    model.updateTrace("repeat sum 1 2 [ fd sum 1 2 ]");
//    model.updateTrace("repeat :count  [ fd sum 1 2 ]");
//    model.updateTrace("repeat sum 1 2 [ fd sum 1 2 ] fd sum 1 2");
    model.updateTrace("repeat sum 1 2 [ fd sum 1 2 repeat 3 [ fd sum 1 2 ] ] fd sum 1 2");
//    model.updateTrace("to dash [ :count ] [ repeat :count  [   fd 4  fd 4 ]  ]   ");
    
}*/

}
