package viewer.toggle;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JPopupMenu;

import jgame.JGColor;
import viewer.Button;
import viewer.Panel;

public class BackgroundColorButton extends Button {

	private JPopupMenu menu;
	
	public BackgroundColorButton(Panel myPanel) {
		super(myPanel, "Set Background Color");
		this.menu = new JPopupMenu();
		menu.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("pop up");
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("pop down");
			}
		});
		menu.addComponentListener(new ComponentListener() {
			@Override
			public void componentHidden(ComponentEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void componentMoved(ComponentEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void componentResized(ComponentEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void componentShown(ComponentEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		setFocusable(true);
		menu.setFocusable(true);
	}
	
	@Override
	public void buttonPushed() {
		//need to add popup to select color
		((Toggles) this.myPanel).setBackgroundColor(null);
	}
	
}
