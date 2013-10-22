package viewer.toggle;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import controller.Controller;

public class HelpButton extends Button {

    private static final String LABEL="Help";
    private static final String HELP_URI = "http://www.cs.duke.edu/courses/cps108/current/assign/03_slogo/commands.php";
	
	public HelpButton(Controller controller) {
		super(LABEL, controller);
	}

	@Override
	public void buttonPushed() {
	    try {
	        URI helpPage=new URI(HELP_URI);
	        
	        Desktop helpWindow = Desktop.getDesktop();
	        helpWindow.browse(helpPage);
	    }
	    catch (URISyntaxException e) {
	    }
	    catch (IOException e) {
	        e.printStackTrace();
	    }
	}

}
