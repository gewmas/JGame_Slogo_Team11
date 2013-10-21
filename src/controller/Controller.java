package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import javax.swing.JFileChooser;
import jgame.JGColor;
import model.DefaultModel;
import model.Model;
import model.expression.Expression;
import viewer.SLogoViewer;
import viewer.Viewer;
import Exceptions.SlogoException;


public class Controller implements ControllerToViewInterface, ControllerToModelInterface {
    private static final String CLEARSCREEN = "clearscreen";

    Model model;
    Viewer viewer;

    List<Turtle> turtles;
    List<Turtle> activeTurtles;

    private List<String> commandList;
    private int currentCommand;

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

        // default workspace with id "1"
        workspaces = new HashMap<String, Workspace>();
        currentWorkspace = new Workspace();
        workspaces.put("1", currentWorkspace);

    }

    // Take the commands typed by the user and updates the TurtleTrace accordingly.
    @Override
    public void interpretCommand (String userInput) {
        try {
            model.updateTrace(userInput);
            System.out.println("Update Trace Finished!");
        }
        catch (SlogoException e) {
            // e.printStackTrace();
            SlogoError error =
                    new SlogoError("Parse Error",
                                   "A syntax error occured while parsing your script");
            currentWorkspace.setSlogoError(error);
            System.out.println("Error!");
            return;
        }
        // view.paintFrame(getTurtleTraces);
    }

    public void addCommand (String userInput) {
        if (commandList.size() != currentCommand) {
            commandList = commandList.subList(0, currentCommand);
        }
        commandList.add(userInput);
        currentCommand++;
        interpretCommand(userInput);
    }

    public void undo () {
        currentCommand--;
        interpretCommand(CLEARSCREEN);
        for (String command : commandList.subList(0, currentCommand)) {
            interpretCommand(command);
        }
    }

    public void redo () {
        if (currentCommand < commandList.size() - 1) {
            currentCommand++;
            interpretCommand(commandList.get(currentCommand));
        }
    }

    @Override
    public Workspace getCurrentWorkspace () {
        return currentWorkspace;
    }

    public void setCurrentWorkspace (String workspaceId) {
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
    @Override
    public void setBackgroundColor (JGColor backgroundColor) {
        ((SLogoViewer) viewer).setBackgroundColor(backgroundColor);
        currentWorkspace.setBackgroundColor(backgroundColor);
    }

    @Override
    public JGColor getBackgroundColor () {
        return currentWorkspace.getBackgroundColor();
    }

    public void setPenColor (JGColor penColor) {
        ((SLogoViewer) viewer).setPenColor(penColor);
        currentWorkspace.setPenColor(penColor);
    }

    public JGColor getPenColor () {
        return currentWorkspace.getPenColor();
    }

    public void setTurtleImage (int imageNum) {
        // Insert method call here
    }

    public void toggleGrid () {
        ((SLogoViewer) viewer).toggleGrid();
        ;
    }

    public void toggleHighlightTurtles () {
        // Insert toggle method call here
        // ((SLogoViewer)viewer).highlightTurtles(boxOnOff);
    }

    public void toggleData () {
        // Add toggle method here
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
