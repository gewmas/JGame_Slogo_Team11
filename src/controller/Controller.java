package controller;

import java.util.ArrayList;
import java.util.List;
import viewer.SLogoViewer;
import viewer.Viewer;
import model.DefaultModel;
import model.Model;


public class Controller implements ControllerToViewInterface, ControllerToModelInterface {
    Model model;
    Viewer viewer;

    List<Turtle> turtles;
    List<Turtle> activeTurtles;
    String backgroundColor;

    public Controller () {
        model = new DefaultModel(this);
//        viewer = new SLogoViewer(); // new SLogoViewer(ControllerToViewInterface this);
        
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

    //Now getTurtles & getActiveTurtle return the same only turtle
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
    
    
    //Turtle queries function call
    public void clearScreen(){
        //view.clearScreen()
    }
    
    public void xCor(){
      //view.xCor();
    }
    
    public void yCor(){
      //view.yCor();
    }
    
    public void heading(){
      //view.heading();
    }
    
    public void isPenDown(){
      //view.isPenDown();
    }
    
    public void isShowing(){
      //view.isShowing();
    }
                          
    
    
}
