package viewer.toggle;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import viewer.Panel;

public class GridButton extends Button {

	public GridButton(Panel myPanel) {
		super(myPanel, "Toggle Grid");
	}
	
	@Override
	public void buttonPushed() {
		((Toggles) this.myPanel).toggleGrid();
	}
	
}
