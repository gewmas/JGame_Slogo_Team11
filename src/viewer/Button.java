package viewer;

import java.awt.Dimension;

import javax.swing.JButton;

public class Button extends JButton {

    private static final int BUTTON_WIDTH=180;
    private static final int BUTTON_HEIGHT=20;
    protected Panel myPanel;

	public Button(Panel myPanel) {
		this(myPanel, "Button Text");
	}
	
	public Button(Panel myPanel, String buttonText) {
		super(buttonText);
		this.myPanel = myPanel;
		setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
	}
	
	public void buttonPushed() {
		
	}
	
}
