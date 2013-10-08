package viewer.toggle;

import java.awt.Dimension;

import viewer.Button;
import viewer.Panel;

public class TurtleImageButton extends Button {

	public TurtleImageButton(Panel myPanel) {
		super(myPanel, "Set Turtle Image");
	}
	
	@Override
	public void buttonPushed() {
		//need to add popup to select image
		((Toggles) this.myPanel).setTurtleImage(null);
	}
	
}
