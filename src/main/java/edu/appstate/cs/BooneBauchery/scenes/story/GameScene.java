package edu.appstate.cs.BooneBauchery.scenes.story;

import edu.appstate.cs.BooneBauchery.display.gui.ChoiceButton;
import edu.appstate.cs.BooneBauchery.display.gui.MenuButton;
import edu.appstate.cs.BooneBauchery.display.gui.PauseButton;
import edu.appstate.cs.BooneBauchery.scenes.mainmenu.MenuSubSceneManager;
import edu.appstate.cs.BooneBauchery.scenes.mainmenu.PauseSubSceneManager;
import edu.appstate.cs.BooneBauchery.scenes.mainmenu.PromptSubSceneManager;
import edu.appstate.cs.BooneBauchery.tools.Scroller;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * This is a template class we can use as a scene generator for making quicker scenes.
 * TODO: finish UI
 */
public abstract class GameScene extends Scene{

    protected Stage gameStage;
    protected Label promptLabel;
    protected AnchorPane root;
    protected static final int HEIGHT = 720;
    protected static final int WIDTH = 1280;
    protected boolean isGameOver = false;
    protected boolean answer1;
    protected boolean answer2;
    protected PauseSubSceneManager pauseSubScene;
    protected PauseSubSceneManager sceneToHide;
    protected PromptSubSceneManager promptSubScene;
    protected PromptSubSceneManager prompt2hide;
    protected String prompt;
    protected String[] choice;
    private boolean answerChosen;
    private ChoiceButton choice1;
    private ChoiceButton choice2;


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
        this.setFill(Color.BLACK);
        root.setBackground(new Background(backgroundImage));
    }

    /**
     * Messy, but you only have to call setUI() for it to load everything
     */
    protected void setUI()
    {
       PauseButton pauseBttn = new PauseButton();
       pauseBttn.setLayoutX(5);
       pauseBttn.setLayoutY(5);

       root.getChildren().add(pauseBttn);
       pauseSubScene = new PauseSubSceneManager();
       root.getChildren().add(pauseSubScene);
       pauseBttn.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent actionEvent) {
              showSubScene(pauseSubScene);
           }
       });

       promptSubScene = new PromptSubSceneManager(prompt, choice);
       root.getChildren().add(promptSubScene);

    }

    /**
     * Fixes the issue where multiple screens can stack on top of eachother
     * @param subScene the scene to be checked if it needs to be hidden or not
     */
    private void showSubScene(PauseSubSceneManager subScene)
    {
        // sceneToHide is set to null outside of this method
        if (sceneToHide != null && sceneToHide != subScene)
        {
            sceneToHide.moveScene();
        }
        subScene.moveScene();
        if (!subScene.getHidden()) {
            sceneToHide = subScene;
        }
        else
        {
            sceneToHide = null;
        }
    }

}
