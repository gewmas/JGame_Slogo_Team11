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
import viewer.toggle.Toggles;

public class SLogoViewer extends Viewer{
    private static int DISPLAY_WIDTH=600;
    private static int DISPLAY_HEIGHT=600;

    protected Panel myLeftPanel;
    protected Panel myRightPanel;
    protected TurtleDisplayWindow myTurtleDisplay;
    protected PastCommandBox myPastCommandBox;
    protected UserDefinedCommandsBox myUserCommandsBox;
    protected UserVariableBox myUserVariableBox;
    protected InformationTableBox myInformationTableBox;

    public SLogoViewer(Controller controller){
        super();
        myLeftPanel=new Panel();
        myRightPanel=new Panel();
        myLeftPanel.setPreferredSize(new Dimension(600,800));
        myRightPanel.setPreferredSize(new Dimension(200,800));
        myMainPanel.setPreferredSize(new Dimension(800,800));
        FlowLayout myFlow = new FlowLayout();
        myFlow.setAlignment(FlowLayout.LEADING);
        myFlow.setHgap(0);
        myFlow.setVgap(0);
        myMainPanel.setLayout(new BorderLayout());
        myMainPanel.add(myLeftPanel, BorderLayout.WEST);
        myMainPanel.add(myRightPanel, BorderLayout.EAST);

        setTitle("SLogo");
        myInformationTableBox=new InformationTableBox(200,110);
        myUserVariableBox=new UserVariableBox(200,160,controller);
        myUserCommandsBox = new UserDefinedCommandsBox(200,160);
        myTurtleDisplay=new DefaultTurtleDisplayWindow(new JGPoint(DISPLAY_WIDTH-10,DISPLAY_HEIGHT-10), controller,myInformationTableBox);
        myPastCommandBox=new PastCommandBox(600,140,controller);
        myLeftPanel.add(new DisplayBox(DISPLAY_WIDTH,DISPLAY_HEIGHT,myTurtleDisplay,controller));
        myLeftPanel.add(myPastCommandBox);
        myLeftPanel.add(new CommandEntryBox(600,30,myPastCommandBox,controller));
        
        myRightPanel.add(myInformationTableBox);
        myRightPanel.add(myUserVariableBox);
        myRightPanel.add(myUserCommandsBox);
        myRightPanel.add(new Toggles(200,340,controller));
        pack();
        setVisible(true);
    }

    public void setBackgroundColor (JGColor backgroundColor) {
        ((DefaultTurtleDisplayWindow) myTurtleDisplay).setBackGroundColor(backgroundColor);;
    }

    public void setPenColor (JGColor penColor) {
        ((DefaultTurtleDisplayWindow) myTurtleDisplay).setPenColor(penColor);
    }
    
//    public void setPenSize (double pensize) {
//        myTurtleDisplay.setPenSize(pensize);
//    }

    public void toggleGrid(){
        ((DefaultTurtleDisplayWindow) myTurtleDisplay).toggleGrid();
    }

    public void toggleHighlightTurtles(){
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

}
