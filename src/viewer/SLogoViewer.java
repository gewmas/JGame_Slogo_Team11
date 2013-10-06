package viewer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SLogoViewer extends Viewer{
    JPanel myLeftPanel;
    JPanel myRightPanel;
    public SLogoViewer(){
        super();
        //Don't need main panel if we're going to separate into left and right anyway?
        myLeftPanel=new JPanel(new FlowLayout());
        myRightPanel=new JPanel(new FlowLayout());
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
        myLeftPanel.add(new Display(600,500));
        myLeftPanel.add(new CommandEntryBox(600,20));
        myRightPanel.add(new UserVariableBox(200,300));
        myRightPanel.add(new ToggleControls(200,200));
        pack();
        setVisible(true);
    }
}
