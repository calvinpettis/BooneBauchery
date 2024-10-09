package edu.appstate.cs.BooneBauchery.scenes;

import javafx.animation.TranslateTransition;
import javafx.scene.Parent;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.util.Duration;

public class MenuSubSceneManager extends SubScene {

    private final static String FONT_PATH = "/assets/Fonts/blood-crow/bloodcrow.ttf";
    //want to animate the background at some point w the layers in the assets folder
    private final static String BACKGROUND_IMAGE = "assets/Buttons/startbttn/MenuScroll.png";


    public MenuSubSceneManager() {
        super(new AnchorPane(), 1280, 720);
        prefWidth(1280);
        prefHeight(720);

        BackgroundImage background = new BackgroundImage(
                new Image(BACKGROUND_IMAGE, 400,600,false, true),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                null);
        AnchorPane root2 = (AnchorPane) this.getRoot();
        root2.setBackground(new Background(background));

        setLayoutX(1380);
        setLayoutY(150);
    }
    /**
     * You move stuff with TranslateTransition.
     */
    public void moveScene()
    {
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(0.3));
        transition.setNode(this);

        transition.setToX(-1340);

        transition.play();
    }

}
