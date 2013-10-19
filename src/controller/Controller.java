package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import Exceptions.SlogoException;
import viewer.SLogoViewer;
import viewer.Viewer;
import model.DefaultModel;
import model.Model;
import model.expression.Expression;


public class Controller implements ControllerToModelInterface, ControllerToViewInterface {
    Model model;
    Viewer viewer;

    Map<String, Workspace> workspaces;
    Workspace currentWorkspace;

    public Controller () {
        model = new DefaultModel(this);
        viewer = new SLogoViewer(this);
        
        //default workspace with id "1"
        workspaces = new HashMap<String, Workspace>();
        currentWorkspace = new Workspace();
        workspaces.put("1", currentWorkspace);
    }

    // Take the commands typed by the user and updates the TurtleTrace accordingly.
    public void interpretCommand(String userInput) {
        try {
            model.updateTrace(userInput);
        } catch (SlogoException e) {
            //e.printStackTrace();
            SlogoError error = new SlogoError("Parse Error", "A syntax error occured while parsing your script");
            currentWorkspace.setSlogoError(error);
            return;
        }
        // view.paintFrame(getTurtleTraces);
    }

    public Workspace getCurrentWorkspace () {
        return currentWorkspace;
    }

    public void setCurrentWorkspace (String workspaceId) {
        Workspace tempWorkspace = workspaces.get(workspaceId);
        
        if(tempWorkspace == null){
            tempWorkspace = new Workspace();
            workspaces.put(workspaceId, tempWorkspace);
        }
        
        currentWorkspace = tempWorkspace;
    }
    
    public List<Turtle> getTurtles () {
        return currentWorkspace.getTurtles();
    }
    
    public List<Turtle> getActiveTurtles() {
        return currentWorkspace.getActiveTurtles();
    }
    
    public Map<String, Expression> getFunctionMap () {
        return currentWorkspace.getDefinedFunction();
    }

    public Map<String, Expression> getGlobalVariables () {
        return currentWorkspace.getGlobalVariables();
    }
    
    public Map<String, Map<String, Expression>> getLocalVariables () {
        return currentWorkspace.getLocalVariables();
    }

    //Turtle queries function call
    public void clearScreen(){
//        ((SLogoViewer) viewer).clearScreen();
    }
    
    // Get the given attribute from latest turtletrace and show to user
    public void xCor(){
      //view.xCor();
    }
    
    public void penColor() {
        //view.penColor();
    }
    
    public void turtleShape() {
        //view.turtleShape();
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
