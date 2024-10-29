package edu.appstate.cs.BooneBauchery.scenes.story;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Start {

    private Scene startScene;
    private Stage startStage;
    private Label startPrompt;
    private static final int HEIGHT = 720;
    private static final int WIDTH = 1280;

    private String[] introPrompt = {"You walk outside of the classroom " +
            "and head out into the hall.",
            ""};

    public Start(Stage stage) {
        this.startStage = stage;
        createStartScene();
    }

    public void createStartScene()
    {

    }



}
