package viewer;

import java.awt.Dimension;
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
	
	/**
	 * Panel extends JPanel to make our use of this concept more easily compatible with our SLogo program
	 */
	public Panel(){
	    this(new FlowLayout());
	}
	
	public Panel(LayoutManager layout) {
		super(layout);
		componentList = new ArrayList<JComponent>();
	}
	
	public Panel(int width,int height) {
            this(width,height,new FlowLayout());
    }
	
	public Panel(int width,int height,LayoutManager layout) {
		this(layout);
		this.layout = layout;
		setPreferredSize(new Dimension(width,height));
	}
	
	public void addComponent(JComponent component){
	    addComponent(component,componentList.size());
	}
	
	public void addComponent(JComponent component,int index){
	    componentList.add(index,component);
	    add(component);
	}
	
}
