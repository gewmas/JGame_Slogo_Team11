package viewer.toggle;

import controller.Controller;
import controller.TurtleCommand;

/**
 * @author FrontEnd - Alex, Adam
 */
public class LoadPreferencesButton extends SelectableListButton {

    private static final String BUTTON_TITLE = "Load Preferences";
    private static final String DIALOG_MESSAGE = "Please select preferences to load.";

    protected static String[] PREFERENCES = {};

    /**
     * LoadPreferencesButton is a GUI button for users to load previously saved GUI preferences
     * @param controller is the controller between model and view (MVC)
     */
    public LoadPreferencesButton(Controller controller) {
        super(PREFERENCES, BUTTON_TITLE, DIALOG_MESSAGE, controller);
    }

    private int getAllPreferenceNames() {
        return this.myController.getAllPreferences().size();
    }

    @Override
    public void buttonPushed() {
        this.myListModel.clear();
        int numOptions = getAllPreferenceNames();
        for (int i = 0; i < numOptions; i++) {
            myListModel.addElement(String.valueOf(i));
        }
        super.buttonPushed();
        if (!myListModel.isEmpty()) {
            int selected = myList.getSelectedIndex();
            if (selected > -1) {
                this.myController.loadPreferences(selected);				
            }
        }
    }
}
