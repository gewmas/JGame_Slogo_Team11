package viewer.toggle;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import controller.Controller;
import viewer.Panel;
import jgame.JGColor;

public abstract class Button extends JButton {

    private static final int BUTTON_WIDTH=180;
    private static final int BUTTON_HEIGHT=20;
    protected Controller myController;
    
	public Button(Controller controller) {
		this("Button Text", controller);
	}
	
	public Button(String buttonText, Controller controller) {
		super(buttonText);
		setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
		this.myController = controller;
		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				buttonPushed();
			}
        });
//		this.addMouseListener(new MouseAdapter(){
//		    public void mousePressed(MouseEvent e){
//		        buttonPushed(e);
//		    }
//		});
	}
	
	public abstract void buttonPushed();
	
}
