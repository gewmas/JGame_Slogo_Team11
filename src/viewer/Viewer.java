package viewer;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import jgame.JGPoint;

/**
 * @author FrontEnd - Alex, Adam
 */
public abstract class Viewer extends Frame {
    private static final int[] MAIN=new int[]{800,800};
    
    protected Panel myMainPanel;
    
    /**
     * Frame class extends Frame superclass to add a few desired features for our displays
     * This class will be further extended by SLogoViewer with the specifics of our GUI
     */
    public Viewer() {
        super();
        setLayout(new FlowLayout());
        myMainPanel = new Panel(MAIN[0],MAIN[1]);
        getContentPane().add(myMainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void addPanel(Panel panel) {
        myMainPanel.add(panel,BorderLayout.CENTER);
        pack();
        setVisible(true);
    }
    
    public Panel getMyMainPanel() {
    	return this.myMainPanel;
    }
    
}
