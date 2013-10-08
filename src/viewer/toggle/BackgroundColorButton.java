package viewer.toggle;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import jgame.JGColor;
import viewer.Button;
import viewer.Panel;

public class BackgroundColorButton extends Button {

	public BackgroundColorButton(Panel myPanel) {
		super(myPanel, "Set Background Color");
	}
	
	@Override
	public void buttonPushed() {
		//need to add popup to select color
		((Toggles) this.myPanel).setBackgroundColor(null);
	}
	
}
