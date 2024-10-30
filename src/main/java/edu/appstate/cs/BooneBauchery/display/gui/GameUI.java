package edu.appstate.cs.BooneBauchery.display.gui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Going to make this class as an overlay we can call for our UI.
 * This should have a pause button in top left that can be clicked or called with esc
 * 
 */
public class GameUI {

    private static final String PROMPT_PANEL_FILE = "assets/Buttons/UIBanners/gamePanel.png";
    private StackPane overlay;
    private VBox layout;
    private Scene uiScene;
    private Stage uiStage;
    private Button pauseBttn;
    private static final int HEIGHT = 720;
    private static final int WIDTH = 1280;

    private GameUI(Stage stage)
    {
        layout = new VBox();
        initializeUI();
        uiScene = new Scene(layout, WIDTH, HEIGHT);
        uiStage.setScene(uiScene);
    }

    private void initializeUI()
    {

    }
}
