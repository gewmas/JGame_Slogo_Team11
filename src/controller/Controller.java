package controller;

import java.util.ArrayList;
import java.util.List;
import jgame.JGColor;
import viewer.SLogoViewer;
import viewer.Viewer;
import model.DefaultModel;
import model.Model;


public class Controller implements ControllerToViewInterface, ControllerToModelInterface {
    private static final String CLEARSCREEN="clearscreen";
    
    Model model;
    Viewer viewer;

    List<Turtle> turtles;
    List<Turtle> activeTurtles;
    
    private List<String> commandList;
    private int currentCommand;
    private JGColor backgroundColor;
    private JGColor penColor;
    
    public Controller () {
        model = new DefaultModel(this);
        viewer = new SLogoViewer(this);
        turtles = new ArrayList<Turtle>();
        activeTurtles = new ArrayList<Turtle>();
        
        //Assuming always one turtle created for user
        Turtle turtle = new DefaultTurtle();
        turtles.add(turtle);
        activeTurtles.add(turtle);
        
        commandList=new ArrayList<String>();
        currentCommand=commandList.size();
    }

    // Take the commands typed by the user and updates the TurtleTrace accordingly.
    public void interpretCommand(String userInput) {
        model.updateTrace(userInput);
        // view.paintFrame(getTurtleTraces);
    }
    
    public void addCommand(String userInput){
        if (commandList.size()!=currentCommand){
            commandList=commandList.subList(0, currentCommand);
        }
        commandList.add(userInput);
        currentCommand++;
        interpretCommand(userInput);
    }
    
    public void undo(){
        currentCommand--;
        interpretCommand(CLEARSCREEN);
        for (String command:commandList.subList(0, currentCommand)){
            interpretCommand(command);
        }
    }
    
    public void redo(){
        if (currentCommand<commandList.size()-1){
            currentCommand++;
            interpretCommand(commandList.get(currentCommand));
        }
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
    public void setBackgroundColor (JGColor backgroundColor) {
        ((SLogoViewer)viewer).setBackgroundColor(backgroundColor);
        this.backgroundColor = backgroundColor;
    }

    public JGColor getBackgroundColor () {
        return backgroundColor;
    }
    
    public void setPenColor (JGColor penColor) {
        ((SLogoViewer)viewer).setPenColor(backgroundColor);
        this.penColor = penColor;
    }

    public JGColor getPenColor () {
        return penColor;
    }
    
    public void toggleGrid(){
        ((SLogoViewer)viewer).toggleGrid();;
    }
    
    public void highlightTurtles(Boolean boxOnOff){
        ((SLogoViewer)viewer).highlightTurtles(boxOnOff);
    }
    
    public void toggleData(){
        //Add toggle method here
    }
    
    //Turtle queries function call
    public void clearScreen(){
        ((SLogoViewer) viewer).clearScreen();
//        setBackgroundColor(JGColor.white);
//        setPenColor(JGColor.black);
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
