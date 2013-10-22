package viewer.toggle;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import controller.Controller;

public class HelpButton extends Button {

    private static final String LABEL="Help";
	
	public HelpButton(Controller controller) {
		super(LABEL, controller);
	}

	@Override
	public void buttonPushed() {
	    try {
	        URI helpPage=new URI("http://www.cs.duke.edu/courses/cps108/current/assign/03_slogo/commands.php");

	        Desktop helpWindow = Desktop.getDesktop();
	        helpWindow.browse(helpPage);
	    }
	    catch (URISyntaxException e) {
	    }
	    catch (IOException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	}

}
