package edu.appstate.cs.BooneBauchery.scenes.story;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * To make lil clones of our scenes. WIP.
 * TODO: finish
 */
public abstract class gameScene {

    private Scene gameScene;
    private Stage gameStage;
    private Label promptLabel;
    private static final int HEIGHT = 720;
    private static final int WIDTH = 1280;

    public gameScene(Stage stage)
    {
        this.gameStage = stage;
    }

    public Scene getGameScene()
    {
        return gameScene;
    }

    public void createGameScene()
    {
        StackPane layout = new StackPane();

    }


}
