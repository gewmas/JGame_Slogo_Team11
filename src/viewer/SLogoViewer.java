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
import viewer.display_objects.TurtleDisplay;
import viewer.toggle.Toggles;

public class SLogoViewer extends Viewer{
    private static int DISPLAY_WIDTH=600;
    private static int DISPLAY_HEIGHT=600;

    protected Panel myLeftPanel;
    protected Panel myRightPanel;
    protected TurtleDisplay myTurtleDisplay;
    protected PastCommandBox myPastCommandBox;
    protected UserDefinedCommandsBox myUserCommandsBox;
    protected UserVariableBox myUserVariableBox;
    protected InformationTable myInformationTableBox;

    public SLogoViewer(Controller controller){
        super();
        //Don't need main panel if we're going to separate into left and right anyway?
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
        myInformationTableBox=new InformationTable(200,110);
        myUserVariableBox=new UserVariableBox(200,180);
        myUserCommandsBox = new UserDefinedCommandsBox(200,180);
        myTurtleDisplay=new DefaultTurtleDisplayBox(new JGPoint(DISPLAY_WIDTH-10,DISPLAY_HEIGHT-10), controller,myInformationTableBox);
        myPastCommandBox=new PastCommandBox(600,140);
        myLeftPanel.add(new DisplayBox(DISPLAY_WIDTH,DISPLAY_HEIGHT,myTurtleDisplay,controller));
        myLeftPanel.add(myPastCommandBox);
        myLeftPanel.add(new CommandEntryBox(600,30,myPastCommandBox,controller));
        
        myRightPanel.add(myInformationTableBox);
        myRightPanel.add(myUserVariableBox);
        myRightPanel.add(myUserCommandsBox);
        myRightPanel.add(new Toggles(200,300,controller));
        pack();
        setVisible(true);
    }

    public void setBackgroundColor (JGColor backgroundColor) {
        myTurtleDisplay.setBackGroundColor(backgroundColor);;
    }

    public void setPenColor (JGColor penColor) {
        myTurtleDisplay.setPenColor(penColor);
    }

    public void toggleGrid(){
        myTurtleDisplay.toggleGrid();
    }

    public void toggleHighlightTurtles(){
        myTurtleDisplay.toggleHighLightTurtles();
    }

    public void clearScreen(){
        myTurtleDisplay.clearScreen();
    }

    public void setTurtleImage(int num) {
        myTurtleDisplay.setTurtleImageNumber(num);
    }

    public int getTurtleImage() {
        return myTurtleDisplay.getTurtleImageNumber();
    }
    
    public void setTrackedTurtle(String turtleNum){
        myTurtleDisplay.setTrackedTurtle(turtleNum);
    }
    
    public void updateUserVariableTable(Map<String, Expression> variableMap){
        myUserVariableBox.updateVariableTable(variableMap);
    }
    
    public void updateUserCommandList(Map<String, Expression> functionList){
        myUserCommandsBox.updateFunctionList(functionList);
    }


}
