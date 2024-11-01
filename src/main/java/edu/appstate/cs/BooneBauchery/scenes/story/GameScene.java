package edu.appstate.cs.BooneBauchery.scenes.story;

import edu.appstate.cs.BooneBauchery.display.gui.PauseButton;
import edu.appstate.cs.BooneBauchery.scenes.mainmenu.PauseSubSceneManager;
import edu.appstate.cs.BooneBauchery.tools.Scroller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * To make easy lil clones of our scenes. Can use this repeatedly
 * TODO: finish
 */
public abstract class GameScene extends Scene{

    protected Scene gameScene;
    protected Stage gameStage;
    protected Label promptLabel;
    protected Pane root;
    protected static final int HEIGHT = 720;
    protected static final int WIDTH = 1280;
    protected boolean isGameOver = false;
    protected boolean answer1;
    protected boolean answer2;
    protected PauseSubSceneManager pauseSubScene;
    protected Label scrollingPrompt;


    public GameScene(Stage stage)
    {
        super(new AnchorPane(), WIDTH, HEIGHT);
        this.gameStage = stage;
        this.root = (AnchorPane) this.getRoot();
        setupScene();
    }

    public abstract void setupScene();

    protected void setBackground(String path)
    {
        Image bg = new Image(path);
        BackgroundImage backgroundImage = new BackgroundImage(bg,
                BackgroundRepeat.REPEAT,
                BackgroundRepeat.REPEAT,
                BackgroundPosition.DEFAULT,
                null);
        root.setBackground(new Background(backgroundImage));
    }

    protected void loadPrompts(String[] prompt, String FontPath)
    {
        Scroller scroller = new Scroller(prompt, FontPath);

    }

    protected void setUI()
    {
       PauseButton pauseBttn = new PauseButton();
       pauseBttn.setLayoutX(0);
       pauseBttn.setLayoutY(0);

       root.getChildren().add(pauseBttn);
       pauseBttn.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent actionEvent) {
               pauseSubScene.moveScene();
           }
       });
       pauseSubScene = new PauseSubSceneManager();
       root.getChildren().add(pauseSubScene);



    }

}
