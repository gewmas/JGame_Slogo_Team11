package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import javax.swing.JFileChooser;
import jgame.JGColor;
import model.DefaultModel;
import model.Model;
import model.expression.Expression;
import viewer.SLogoViewer;
import viewer.Viewer;
import viewer.toggle.BackgroundColorButton;
import viewer.toggle.PenColorButton;
import Exceptions.SlogoException;


public class Controller implements ControllerToViewInterface, ControllerToModelInterface {
    private static final String CLEARSCREEN = "clearscreen";

    Model model;
    Viewer viewer;

    List<Turtle> turtles;
    List<Turtle> activeTurtles;

    private List<String> commandList;
    private List<String> undoneList;
    private int currentCommand;

    Map<String, Workspace> workspaces;
    Workspace currentWorkspace;
    ResourceBundle messages;
    Map<String, String> languageToCountry;
    Map<Double, ColorIndex> colorIndexes;
    private static final String BACKGROUND = "background";
    private static final String PEN_COLOR = "penColor";
    private static final String PEN_SIZE = "penSize";
    private static final String SHAPE = "shape";

    private List<HashMap<String, Double>> preferencesMap;

    public Controller () {
    	buildLanguageMap();

        model = new DefaultModel(this);
        viewer = new SLogoViewer(this);

        preferencesMap = new ArrayList<HashMap<String, Double>>();
        // default workspace with id "1"
        workspaces = new HashMap<String, Workspace>();
        currentWorkspace = new Workspace();
        workspaces.put("1", currentWorkspace);
        commandList=new ArrayList<String>();
        currentCommand=-1;
    }

    private void buildLanguageMap() {
        languageToCountry = new HashMap<String, String>();
        languageToCountry.put("en", "US");
        languageToCountry.put("fr", "FR");
        languageToCountry.put("pt", "PT");
        languageToCountry.put("it", "IT");
        setLanguage("en");		
	}

	// Take the commands typed by the user and updates the TurtleTrace accordingly.
    @Override
    public void interpretCommand (String userInput) {
        try {
            model.updateTrace(userInput);
            System.out.println("Update Trace Finished!");
        }
        catch (SlogoException e) {
            //e.printStackTrace();
            SlogoError error =
                    new SlogoError("Parse Error",
                                   "A syntax error occured while parsing your script");
            currentWorkspace.setSlogoError(error);
            System.out.println("Error!");
            return;
        }
        // view.paintFrame(getTurtleTraces);
    }
    
	public Map<String, Double> getCurrentPreferences() {
		Map<String, Double> preference = new HashMap<String, Double>();
		preference.put(BACKGROUND, BackgroundColorButton.getColorIdFromColor(this.getBackgroundColor()));
		preference.put(PEN_COLOR, PenColorButton.getColorIdFromColor(this.getPenColor()));
		preference.put(SHAPE, (double) this.getTurtleImage());
//		preference.put(PEN_SIZE, this.getPenSize());
		return preference;
	}
    
    public void savePreferences (Map<String, Double> preference) {
    	this.preferencesMap.add((HashMap<String, Double>) preference);
    }
    
    public void loadPreferences (int index) {
    	Map<String, Double> map = this.preferencesMap.get(index);
    	this.setBackgroundColor(BackgroundColorButton.getColorFromColorId(map.get(BACKGROUND)));
    	this.setPenColor(PenColorButton.getColorFromColorId(map.get(PEN_COLOR)));
//    	this.setPenSize(map.get(PEN_SIZE));
    	this.setTurtleImage(Double.toString(map.get(SHAPE)));
    }
    
    public List<HashMap<String, Double>> getAllPreferences() {
    	return (ArrayList<HashMap<String, Double>>) this.preferencesMap;
    }    

    public void addCommand (String userInput) {
        if (commandList.size() != currentCommand && !commandList.isEmpty()) {
            commandList = commandList.subList(0, currentCommand+1);
        }
        commandList.add(userInput);
        currentCommand++;
        interpretCommand(userInput);
    }

    public void undo () {
        if (currentCommand>-1){
            currentCommand--;
            interpretCommand(CLEARSCREEN);
            for (String command : commandList.subList(0, currentCommand+1)) {
                interpretCommand(command);
            }
        }
    }

    public void redo () {
    	System.out.println(commandList.size());
        if (currentCommand < commandList.size()-1) {
            currentCommand++;
            System.out.println(commandList.get(currentCommand));
            interpretCommand(commandList.get(currentCommand));
        }
    }

    @Override
    public Workspace getCurrentWorkspace () {
        return currentWorkspace;
    }

    public void setCurrentWorkspace (String workspaceId) {
    	System.out.println("adam");
        Workspace tempWorkspace = workspaces.get(workspaceId);

        if (tempWorkspace == null) {
            tempWorkspace = new Workspace();
            workspaces.put(workspaceId, tempWorkspace);
        }

        currentWorkspace = tempWorkspace;
    }

    public void setLanguage (String language) {

        String country = languageToCountry.get(language);

        Locale currentLocale;
        currentLocale = new Locale(language, country);
        messages = ResourceBundle.getBundle("Languages.MessagesBundle", currentLocale);
    }

    // save functions/variables of current workspace
    public void saveFile (String userInput) {
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("/home/me/Documents"));
        int retrival = chooser.showSaveDialog(null);

        if (retrival == JFileChooser.APPROVE_OPTION) {
            try {
                FileWriter fw = new FileWriter(chooser.getSelectedFile() + ".txt");
                fw.write(userInput);
                fw.close();
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    // load functions/variables to current workspace
    public void loadFile () {
        String result = "";
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {

            // load from file
            try {
                File file = fileChooser.getSelectedFile();
                FileInputStream saveFile = new FileInputStream(file);

                int content;
                while ((content = saveFile.read()) != -1) {
                    result += (char) content;
                }

                saveFile.close();
            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            catch (IOException e) {
                e.printStackTrace();
            }

            // System.out.println(result);
            interpretCommand(result);

        }
    }

    @Override
    public List<Turtle> getTurtles () {
        return currentWorkspace.getTurtles();
    }

    @Override
    public List<Turtle> getActiveTurtles () {
        return currentWorkspace.getActiveTurtles();
    }

    // Additional getters/setters
    public void setBackgroundColor (JGColor backgroundColor) {
        ((SLogoViewer) viewer).setBackgroundColor(backgroundColor);
        currentWorkspace.setBackgroundColor(backgroundColor);
    }

    public JGColor getBackgroundColor () {
        return currentWorkspace.getBackgroundColor();
    }

    public void setPenColor (JGColor penColor) {
        ((SLogoViewer) viewer).setPenColor(penColor);
        currentWorkspace.setPenColor(penColor);
    }
    
    public void setTrackedTurtle(String turtleNum){
        ((SLogoViewer) viewer).setTrackedTurtle(turtleNum);
    }

    public JGColor getPenColor () {
        return currentWorkspace.getPenColor();
    }

    public void setTurtleImage (String imageNumber) {
        ((SLogoViewer) viewer).setTurtleImage(Integer.parseInt(imageNumber));
    }
    
    public Double getTurtleImage() {
    	return (double) ((SLogoViewer) viewer).getTurtleImage();
    }

    public void toggleGrid () {
        ((SLogoViewer) viewer).toggleGrid();
    }

    public void toggleHighlightTurtles () {
        // Insert toggle method call here
         ((SLogoViewer)viewer).toggleHighlightTurtles();
    }

    public void toggleData () {
        // Add toggle method here
    }
    
    public void updateUserVariableBox(){
        try{
            Map<String, Expression> variableMap=getGlobalVariables();
            if (variableMap!=null){
                ((SLogoViewer)viewer).updateUserVariableTable(variableMap);
            }
        } catch(Exception e){
            
        }
    }
    
    public void updateUserDefinedCommandsBox(){
        try{
            Map<String, Expression> functionList=getDefinedFunction();
            if (functionList!=null){
                ((SLogoViewer)viewer).updateUserCommandList(functionList);
            }
        } catch(Exception e){
            
        }
    }

    @Override
    public Map<String, Expression> getDefinedFunction () {
        return currentWorkspace.getDefinedFunction();
    }

    @Override
    public Map<String, Expression> getRunningFunction () {
        return currentWorkspace.getRunningFunction();
    }

    @Override
    public Map<String, Expression> getGlobalVariables () {
        return currentWorkspace.getGlobalVariables();
    }

    @Override
    public Map<String, Map<String, Expression>> getLocalVariables () {
        return currentWorkspace.getLocalVariables();
    }

    public ColorIndex getRGBForIndex (String index) {
        return colorIndexes.get(index);
    }

    @Override
    public void addColorIndex (ColorIndex index) {
        colorIndexes.put(index.index, index);
    }

    // Turtle queries function call
    @Override
    public void clearScreen () {
        currentWorkspace.clearScreen();
        ((SLogoViewer) viewer).clearScreen();
    }

    public void clearWorkspace () {
        currentWorkspace.clearWorkspace();
    }

    // Get the given attribute from latest turtletrace and show to user
    @Override
    public void xCor () {
        // view.xCor();
    }

    @Override
    public void penColor () {
        // view.penColor();
    }

    @Override
    public void turtleShape () {
        // view.turtleShape();
    }

    @Override
    public void yCor () {
        // view.yCor();
    }

    @Override
    public void heading () {
        // view.heading();
    }

    @Override
    public void isPenDown () {
        // view.isPenDown();
    }

    @Override
    public void isShowing () {
        // view.isShowing();
    }
    
    public void id(){
        // view show ids
    }

    public ResourceBundle getMessages () {
        return messages;
    }

}
