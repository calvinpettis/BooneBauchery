package edu.appstate.cs.BooneBauchery.scenes.mainmenu;

import javafx.animation.TranslateTransition;
import javafx.scene.Parent;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.util.Duration;

public class PauseSubSceneManager extends SubScene {

    private final static String FONT_PATH = "/assets/Fonts/blood-crow/bloodcrow.ttf";
    //want to animate the background at some point w the layers in the assets folder
    private final static String BACKGROUND_IMAGE = "assets/Buttons/startbttn/pauseTile.png";


    //we will use this to know wether to close a window on a button press.
    private boolean isHidden;


    public PauseSubSceneManager() {
        //Make a new window display, set to width and height of the other ones.
        super(new AnchorPane(), 1280, 720);
        prefWidth(1280);
        prefHeight(720);

        BackgroundImage background = new BackgroundImage(
                new Image(BACKGROUND_IMAGE, 333,500,false, true),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                null);
        AnchorPane root2 = (AnchorPane) this.getRoot();
        root2.setBackground(new Background(background));


        isHidden = true;
        setLayoutX(1380);
        setLayoutY(210);
    }



    /**
     * You move stuff with TranslateTransition.
     */
    public void moveScene()
    {
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(0.3));
        transition.setNode(this);

        //Method that displays or removes sub menu if button is clicked again
        if(isHidden) {
            transition.setToX(-1340);
            isHidden = false;
        }
        else
        {
            transition.setToX(0);
            isHidden = true;
        }
        transition.play();
    }

    public AnchorPane getPane()
    {
        return (AnchorPane) this.getRoot();
    }

}
