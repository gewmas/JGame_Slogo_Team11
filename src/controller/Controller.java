package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
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
    ResourceBundle messages;
    HashMap<String, String> languageToCountry;
    HashMap<Double, ColorIndex> colorIndexes;

    public Controller () {
        languageToCountry = new HashMap<String, String>();
        languageToCountry.put("en", "US");
        languageToCountry.put("fr", "FR");
        languageToCountry.put("pt", "PT");
        languageToCountry.put("it", "IT");
        setLanguage("en");
        
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
    
    public void setLanguage(String language) {
        
        String country = languageToCountry.get(language);
        
        Locale currentLocale;
        currentLocale = new Locale(language, country);
        messages = ResourceBundle.getBundle("Languages.MessagesBundle", currentLocale);
    }
    
    //save functions/variables of current workspace
    public void saveFile(){
        
    }
    
    //load functions/variables to current workspace
    public void readFile(){
        
    }
    
    public List<Turtle> getTurtles () {
        return currentWorkspace.getTurtles();
    }
    
    public List<Turtle> getActiveTurtles() {
        return currentWorkspace.getActiveTurtles();
    }
    
    public Map<String, Expression> getDefinedFunction () {
        return currentWorkspace.getDefinedFunction();
    }
    
    public Map<String, Expression> getRunningFunction () {
        return currentWorkspace.getRunningFunction();
    }

    public Map<String, Expression> getGlobalVariables () {
        return currentWorkspace.getGlobalVariables();
    }
    
    public Map<String, Map<String, Expression>> getLocalVariables () {
        return currentWorkspace.getLocalVariables();
    }
    
    public ColorIndex getRGBForIndex(String index) {
        return colorIndexes.get(index);
    }
    
    public void addColorIndex(ColorIndex index) {
        colorIndexes.put(index.index, index);
    }

    //Turtle queries function call
    public void clearScreen(){
        
//        ((SLogoViewer) viewer).clearScreen();
    }
    
    public void clearWorkspace(){
        currentWorkspace.clear();
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

    public ResourceBundle getMessages () {
        return messages;
    }
    
}
