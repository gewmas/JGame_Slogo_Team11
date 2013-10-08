package viewer;

import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class Panel extends JPanel {

	protected List<JComponent> componentList;
	protected LayoutManager layout;
	
	public Panel() {
		this(new FlowLayout());
	}
	
	public Panel(LayoutManager layout) {
		super(layout);
		this.layout = layout;
		componentList = new ArrayList<JComponent>();
	}
	
}
