package viewer.toggle;

import java.awt.Dimension;

import viewer.Button;
import viewer.Panel;

public class PenColorButton extends Button {

	public PenColorButton(Panel myPanel) {
		super(myPanel, "Set Pen Color");
	}
	
	@Override
	public void buttonPushed() {
		//need to add popup to select color
		((Toggles) this.myPanel).setPenColor(null);
	}
	
}
