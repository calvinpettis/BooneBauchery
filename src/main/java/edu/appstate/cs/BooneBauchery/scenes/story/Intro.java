package edu.appstate.cs.BooneBauchery.scenes.story;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class Intro {
    private Scene introScene;
    private Stage introStage;
    private static final int HEIGHT = 600;
    private static final int WIDTH = 800;

    public Intro()
    {
       // Scene intro = new Scene(mainDisplay, WIDTH, HEIGHT);
    }

    public Scene getIntroScene()
    {
        return introScene;
    }

    public Stage getIntroStage(){
        return introStage;
    }

}
