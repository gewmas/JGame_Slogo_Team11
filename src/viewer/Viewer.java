package viewer;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class Viewer extends Frame{
	
    protected Panel myMainPanel;
    
    public Viewer() {
        super();
        setLayout(new FlowLayout());
        myMainPanel = new Panel();
        getContentPane().add(myMainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void addPanel(Panel panel) {
        myMainPanel.add(panel,BorderLayout.CENTER);
        pack();
        setVisible(true);
    }
    
}
