package viewer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.List;
import java.util.Map;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.expression.Expression;
import jgame.JGColor;
import jgame.JGPoint;
import controller.Controller;
import viewer.display_objects.DefaultTurtleDisplayWindow;
import viewer.display_objects.TurtleDisplayWindow;
import viewer.toggle.ToggleBox;

/**
 * @author FrontEnd - Alex, Adam
 */
public class SLogoViewer extends Viewer{
    // All panel sizes are stored here
    private static final int[] LEFT=new int[]{600,800};
    private static final int[] RIGHT=new int[]{200,800};
    
    private static final int[] INFOBOX=new int[]{200,100};
    private static final int[] USERVARBOX=new int[]{200,160};
    private static final int[] USERCOMMBOX=new int[]{200,160};
    private static final int[] DISPLAYBOX=new int[]{600,600};
    private static final int[] PASTCOMMBOX=new int[]{600,140};
    private static final int[] TOGGLEBOX=new int[]{200,340};
    private static final int[] COMMENTRYBOX=new int[]{600,30};
    
    protected Panel myLeftPanel;
    protected Panel myRightPanel;
    protected TurtleDisplayWindow myTurtleDisplay;
    protected PastCommandBox myPastCommandBox;
    protected UserDefinedCommandsBox myUserCommandsBox;
    protected UserVariableBox myUserVariableBox;
    protected InformationTableBox myInformationTableBox;
    protected ToggleBox myToggles;
    
    /**
     * SLogoViewer is our container GUI class. This class holds all GUI elements for user interaction
     * @param controller is the controller between view and model (MVC)
     */
    public SLogoViewer(Controller controller){
        super();
        myLeftPanel=new Panel(LEFT[0],LEFT[1]);
        myRightPanel=new Panel(RIGHT[0],RIGHT[1]);
        myMainPanel.setLayout(new BorderLayout());
        myMainPanel.add(myLeftPanel, BorderLayout.WEST);
        myMainPanel.add(myRightPanel, BorderLayout.EAST);

        setTitle("SLogo");
        myInformationTableBox=new InformationTableBox(INFOBOX[0],INFOBOX[1]);
        myUserVariableBox=new UserVariableBox(USERVARBOX[0],USERVARBOX[1],controller);
        myUserCommandsBox = new UserDefinedCommandsBox(USERCOMMBOX[0],USERCOMMBOX[1]);
        myTurtleDisplay=new DefaultTurtleDisplayWindow(new JGPoint(DISPLAYBOX[0]-10,DISPLAYBOX[1]-10), controller,myInformationTableBox);
        myPastCommandBox=new PastCommandBox(PASTCOMMBOX[0],PASTCOMMBOX[1],controller);
        myToggles = new ToggleBox(TOGGLEBOX[0],TOGGLEBOX[1],controller);
        
        myLeftPanel.add(new DisplayBox(DISPLAYBOX[0],DISPLAYBOX[1],myTurtleDisplay,controller));
        myLeftPanel.add(myPastCommandBox);
        myLeftPanel.add(new CommandEntryBox(COMMENTRYBOX[0],COMMENTRYBOX[1],myPastCommandBox,controller));
        
        myRightPanel.add(myInformationTableBox);
        myRightPanel.add(myUserVariableBox);
        myRightPanel.add(myUserCommandsBox);
        myRightPanel.add(myToggles);
        pack();
        setVisible(true);
    }

    // Methods to interact with the JGame class
    
    public void setBackgroundColor (JGColor backgroundColor) {
        ((DefaultTurtleDisplayWindow) myTurtleDisplay).setBackGroundColor(backgroundColor);;
    }

    public void setPenColor (JGColor penColor) {
        ((DefaultTurtleDisplayWindow) myTurtleDisplay).setPenColor(penColor);
    }

    public void toggleGrid(){
        ((DefaultTurtleDisplayWindow) myTurtleDisplay).toggleGrid();
    }

    public void toggleHighlightTurtles() {
        ((DefaultTurtleDisplayWindow) myTurtleDisplay).toggleHighLightTurtles();
    }

    public void clearScreen(){
        myTurtleDisplay.clearScreen();
    }

    public void setTurtleImage(int num) {
        ((DefaultTurtleDisplayWindow) myTurtleDisplay).setTurtleImageNumber(num);
    }

    public int getTurtleImage() {
        return ((DefaultTurtleDisplayWindow) myTurtleDisplay).getTurtleImageNumber();
    }
    
    public void setTrackedTurtle(String turtleNum){
        ((DefaultTurtleDisplayWindow) myTurtleDisplay).setTrackedTurtle(turtleNum);
    }
    
    public void updateUserVariableTable(Map<String, Expression> variableMap){
        myUserVariableBox.updateVariableTable(variableMap);
    }
    
    public void updateUserCommandList(Map<String, Expression> functionList){
        myUserCommandsBox.updateFunctionList(functionList);
    }
    
    public void updatePastCommandsBox(List<String> commands){
        myPastCommandBox.updateCommands(commands);
    }

    public void clearDataTables(){
        myUserVariableBox.clearVariableTable();
        myUserCommandsBox.clearFunctionList();
    }
    
    // All methods below this are for testing purposes only
    public String[] getTurtleParameters() {
        return myInformationTableBox.getTurtleParameters();
    }

    public Panel getMyRightPanel() {
    	return this.myRightPanel;
    }
    
    public Panel getMyLeftPanel() {
    	return this.myLeftPanel;
    }
    
    public ToggleBox getToggles() {
    	return this.myToggles;
    }
    
    public TurtleDisplayWindow getTurtleDisplay() {
    	return this.myTurtleDisplay;
    }

}
