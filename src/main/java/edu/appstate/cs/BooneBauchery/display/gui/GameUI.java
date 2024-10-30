package edu.appstate.cs.BooneBauchery.display.gui;

import edu.appstate.cs.BooneBauchery.scenes.mainmenu.PauseMenuSceneManager;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Going to make this class as an overlay we can call for our UI.
 * This should have a pause button in top left that can be clicked or called with esc
 *
 */
public class GameUI {

    private static final String PROMPT_PANEL_FILE = "assets/Buttons/UIBanners/gamePanel.png";
    private AnchorPane overlay;
    private VBox layout;
    private Scene uiScene;
    private Stage uiStage;
    private static final int HEIGHT = 720;
    private static final int WIDTH = 1280;

    private PauseMenuSceneManager pauseSubScene;

    private PauseMenuSceneManager sceneToHide;

    private GameUI()
    {
        overlay = new AnchorPane();
        layout = new VBox();
        layout.setSpacing(10);
        initializeUI();
        overlay.getChildren().add(layout);
    }

    private void initializeUI()
    {
        createPauseButton();
    }

    private void showPause(PauseMenuSceneManager subScene)
    {
        if (sceneToHide != null)
        {
            sceneToHide.moveScene();
        }
        subScene.moveScene();
        sceneToHide = subScene;
    }

    private void createPauseButton()
    {
        PauseButton pauseBttn = new PauseButton();
        pauseBttn.setLayoutX(0);
        pauseBttn.setLayoutY(0);
        overlay.getChildren().add(pauseBttn);
        pauseBttn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                showPause(pauseSubScene);
            }
        });
        pauseBttn.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {

            }
        });
    }

}
