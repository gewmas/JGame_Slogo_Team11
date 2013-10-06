package viewer;

import java.awt.Dimension;

import javax.swing.JButton;

public class Button extends JButton {

    protected static final int BUTTON_WIDTH=180;
    protected static final int BUTTON_HEIGHT=20;

	public Button() {
		this("Button Text");
	}
	
	public Button(String buttonText) {
		super(buttonText);
		setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
	}
}
