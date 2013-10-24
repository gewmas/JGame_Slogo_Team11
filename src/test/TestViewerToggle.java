package test;

import static org.junit.Assert.*;

import java.util.Map;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import viewer.SLogoViewer;
import viewer.toggle.BackgroundColorButton;
import viewer.toggle.BoxButton;
import viewer.toggle.DataPopupButton;
import viewer.toggle.GridButton;
import viewer.toggle.HelpButton;
import viewer.toggle.LoadPreferencesButton;
import viewer.toggle.PenColorButton;
import viewer.toggle.RedoButton;
import viewer.toggle.SavePreferencesButton;
import viewer.toggle.SetLanguageButton;
import viewer.toggle.ToggleBox;
import viewer.toggle.TurtleImageButton;
import viewer.toggle.UndoButton;
import viewer.toggle.WorkspaceButton;
import controller.Controller;

public class TestViewerToggle extends TestCase {

	Controller controller; 
	ToggleBox toggles;
	public static final int WORKSPACE_BUTTON = 0;
	public static final int BACKGROUND_COLOR_BUTTON = 1;
	public static final int TURTLE_IMAGE_BUTTON = 2;
	public static final int PEN_COLOR_BUTTON = 3;
	public static final int GRID_BUTTON = 4;
	public static final int BOX_BUTTON = 5;
	public static final int DATA_POPUP_BUTTON = 6;
	public static final int UNDO_BUTTON = 7;
	public static final int REDO_BUTTON = 8;
	public static final int SAVE_PREFERENCES_BUTTON = 9;
	public static final int LOAD_PREFERENCES_BUTTON = 10;

	@Before
	public void setUp() throws Exception {
		controller = new Controller();
		toggles = ((SLogoViewer) controller.getViewer()).getToggles();
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testToggles() {
		workspaceButton();
		backgroundColor();
		turtleImage();
		penColor();
		grid();
		box();
		dataPopup();
		undoRedo();
		saveLoadPreferences();
	}
	
	@Test
	public void workspaceButton() {
		WorkspaceButton workspaceButton = (WorkspaceButton) toggles.getButtonList().get(WORKSPACE_BUTTON);
		workspaceButton.buttonPushed();
		int myChoice = workspaceButton.getMyList().getSelectedIndex();
		if (myChoice == 0) {
			assertTrue(controller.getCurrentWorkspace().getWorkspaceId().equals(String.valueOf(workspaceButton.getMyList().getComponentCount()+1)));
		} else {
			assertTrue(controller.getCurrentWorkspace().getWorkspaceId().equals(String.valueOf(myChoice)));
		}
	}

	@Test
	public void backgroundColor() {
		BackgroundColorButton backgroundColorButton = (BackgroundColorButton) toggles.getButtonList().get(BACKGROUND_COLOR_BUTTON);
		backgroundColorButton.buttonPushed();
		int myChoice = backgroundColorButton.getMyList().getSelectedIndex();
		assertTrue(controller.getCurrentWorkspace().getBackgroundColor().equals(backgroundColorButton.getColorFromColorId(Double.valueOf(myChoice))));
	}
	
	@Test
	public void turtleImage() {
		TurtleImageButton turtleImageButton = (TurtleImageButton) toggles.getButtonList().get(TURTLE_IMAGE_BUTTON);
		turtleImageButton.buttonPushed();
		int myChoice = turtleImageButton.getMyList().getSelectedIndex();
		assertTrue(controller.getCurrentWorkspace().getTurtleImage().equals(Double.valueOf(myChoice+1)));
	}
	
	@Test
	public void penColor() {
		PenColorButton penColorButton = (PenColorButton) toggles.getButtonList().get(PEN_COLOR_BUTTON);
		penColorButton.buttonPushed();
		int myChoice = penColorButton.getMyList().getSelectedIndex();
		assertTrue(controller.getCurrentWorkspace().getPenColor().equals(penColorButton.getColorFromColorId(Double.valueOf(myChoice))));
	}
	
	@Test
	public void grid() {
		GridButton gridButton = (GridButton) toggles.getButtonList().get(GRID_BUTTON);
		boolean gridStatus = controller.getCurrentWorkspace().isGridOn();
		gridButton.buttonPushed();
		assertTrue(gridStatus != controller.getCurrentWorkspace().isGridOn());
	}
	
	@Test
	public void box() {
		BoxButton boxButton = (BoxButton) toggles.getButtonList().get(BOX_BUTTON);
		boolean turtleHighlights = ((SLogoViewer) controller.getViewer()).getTurtleDisplay().isHighlightTurtles();
		boxButton.buttonPushed();
		assertTrue(turtleHighlights != ((SLogoViewer) controller.getViewer()).getTurtleDisplay().isHighlightTurtles());
	}
	
	@Test
	public void dataPopup() {
		DataPopupButton dataPopupButton = (DataPopupButton) toggles.getButtonList().get(DATA_POPUP_BUTTON);
		String trackedTurtle = ((SLogoViewer) controller.getViewer()).getTurtleDisplay().getTrackedTurtle();
		assertTrue(trackedTurtle == "1");
		//add an extra turtle to choose from
		String newTurtleId = "2";
		controller.addCommand("TELL [ " + newTurtleId + " ]");
		dataPopupButton.buttonPushed();
		String myChoice = (String) dataPopupButton.getMyList().getSelectedValue();
		assertTrue(((SLogoViewer) controller.getViewer()).getTurtleDisplay().getTrackedTurtle() == myChoice);
	}
	
	@Test
	public void undoRedo() {
		UndoButton undoButton = (UndoButton) toggles.getButtonList().get(UNDO_BUTTON);
		RedoButton redoButton = (RedoButton) toggles.getButtonList().get(REDO_BUTTON);
		int listSize = controller.getCurrentCommands().size();
		controller.addCommand("MAKE x 5");
		assertTrue(controller.getCurrentCommands().size() == listSize + 1);
		listSize = controller.getCurrentCommands().size();
		undoButton.buttonPushed();
		assertTrue(controller.getCurrentCommands().size() == listSize - 1);
		listSize = controller.getCurrentCommands().size();
		redoButton.buttonPushed();
		assertTrue(controller.getCurrentCommands().size() == listSize + 1);
	}

	@Test
	public void saveLoadPreferences() {
		SavePreferencesButton savePreferencesButton = (SavePreferencesButton) toggles.getButtonList().get(SAVE_PREFERENCES_BUTTON);
		LoadPreferencesButton loadPreferencesButton = (LoadPreferencesButton) toggles.getButtonList().get(LOAD_PREFERENCES_BUTTON);
		assertTrue(controller.getPreferencesMap().size() == 0);
		Map currentPreferences = controller.getCurrentPreferences();
		savePreferencesButton.buttonPushed();
		assertTrue(controller.getPreferencesMap().size() == 1);
		int myChoice = 0;
		loadPreferencesButton.buttonPushed();
		assertTrue(controller.getCurrentPreferences().equals(currentPreferences));
		assertTrue(controller.getCurrentPreferences().equals(controller.getPreferencesMap().get(myChoice)));
	}
	
}
