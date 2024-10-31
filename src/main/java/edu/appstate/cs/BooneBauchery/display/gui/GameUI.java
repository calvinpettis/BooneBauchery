package edu.appstate.cs.BooneBauchery.display.gui;

import edu.appstate.cs.BooneBauchery.scenes.mainmenu.PauseMenuSceneManager;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Going to make this class as an overlay we can call for our UI. Ties all parts together
 * This should have a pause button in top left that can be clicked or called with esc
 * TODO: Add features as we please
 *
 */
public class GameUI {

    private static final String PROMPT_PANEL_FILE = "assets/Buttons/UIBanners/gamePanel.png";
    private AnchorPane overlay;

    private PauseMenuSceneManager pauseSubScene;

    private PauseMenuSceneManager sceneToHide;

    public GameUI() {

        overlay = new AnchorPane();
        initializeUI();
    }

    private void initializeUI()
    {
        createButtons();
        createSubScenes();
    }

    public AnchorPane getOverlay()
    {
        return overlay;
    }

    private void createSubScenes()
    {
       pauseSubScene = new PauseMenuSceneManager();
       overlay.getChildren().add(pauseSubScene);
    }

    private void createButtons()
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
        pauseBttn.setLayoutX(100);
        pauseBttn.setLayoutY(100);
        pauseBttn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                showPause(pauseSubScene);
            }
        });
        overlay.getChildren().add(pauseBttn);
    }


}
