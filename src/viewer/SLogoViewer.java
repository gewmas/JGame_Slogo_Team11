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
        myLeftPanel=new JPanel(new FlowLayout());
        myRightPanel=new JPanel(new FlowLayout());
        myLeftPanel.setPreferredSize(new Dimension(500,600));
        myRightPanel.setPreferredSize(new Dimension(300,600));
        myMainPanel.setPreferredSize(new Dimension(800,600));
        FlowLayout myFlow = new FlowLayout();
        myFlow.setAlignment(FlowLayout.LEADING);
        
        myFlow.setHgap(0);
        myFlow.setVgap(0);
        myMainPanel.setLayout(new BorderLayout());
        myMainPanel.add(myLeftPanel, BorderLayout.WEST);
        myMainPanel.add(myRightPanel, BorderLayout.EAST);
        
        setTitle("SLogo");
        setPreferredSize(new Dimension(800,600));
        /*JLabel yellowLabel = new JLabel();
        yellowLabel.setOpaque(true);
        yellowLabel.setBackground(new Color(248, 213, 131));
        yellowLabel.setPreferredSize(new Dimension(200, 180));
 
        //Set the menu bar and add the label to the content pane.
        getContentPane().add(yellowLabel, BorderLayout.CENTER);
        */
        /*myPanel.add(new UserVariableBox());//,BorderLayout.EAST);
        myPanel.add(new Display());//,BorderLayout.WEST);
        //myPanel.add(new ToggleControls());//,BorderLayout.SOUTH);
        myPanel.add(new CommandBox());//,BorderLayout.SOUTH);*/
        myLeftPanel.add(new Display());
        myLeftPanel.add(new CommandBox());
        myRightPanel.add(new UserVariableBox());
        myRightPanel.add(new ToggleControls());
        pack();
        setVisible(true);
    }
}
