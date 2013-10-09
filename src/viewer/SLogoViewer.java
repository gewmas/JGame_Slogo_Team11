package viewer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import jgame.JGPoint;
import controller.Controller;
import viewer.toggle.Toggles;

public class SLogoViewer extends Viewer{
    private static int DISPLAY_WIDTH=600;
    private static int DISPLAY_HEIGHT=450;
    
    protected Panel myLeftPanel;
    protected Panel myRightPanel;
    protected TurtleDisplay myTurtleDisplay;
    protected PastCommandBox myPastCommandBox;
    
    public SLogoViewer(Controller controller){
        super();
        //Don't need main panel if we're going to separate into left and right anyway?
        myLeftPanel=new Panel();
        myRightPanel=new Panel();
        myLeftPanel.setPreferredSize(new Dimension(600,600));
        myRightPanel.setPreferredSize(new Dimension(200,600));
        myMainPanel.setPreferredSize(new Dimension(800,600));
        FlowLayout myFlow = new FlowLayout();
        myFlow.setAlignment(FlowLayout.LEADING);
        myFlow.setHgap(0);
        myFlow.setVgap(0);
        myMainPanel.setLayout(new BorderLayout());
        myMainPanel.add(myLeftPanel, BorderLayout.WEST);
        myMainPanel.add(myRightPanel, BorderLayout.EAST);
        
        setTitle("SLogo");
        myTurtleDisplay=new DefaultTurtleDisplayBox(new JGPoint(DISPLAY_WIDTH-10,DISPLAY_HEIGHT-10), controller);
        myPastCommandBox=new PastCommandBox(600,80);
        myLeftPanel.add(new DisplayBox(DISPLAY_WIDTH,DISPLAY_HEIGHT,myTurtleDisplay,controller));
        myLeftPanel.add(myPastCommandBox);
        myLeftPanel.add(new CommandEntryBox(600,30,myPastCommandBox,controller));
        myRightPanel.add(new UserVariableBox(200,200));
        myRightPanel.add(new UserDefinedCommandsBox(200,200));
        myRightPanel.add(new Toggles(200,200,myTurtleDisplay));
        pack();
        setVisible(true);
    }
}
