package viewer;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import jgame.JGColor;

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
		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				buttonPushed();
			}
        });
	}
	
	public void buttonPushed() {
		//overridden by each button to add action for that button
	}
	
}
