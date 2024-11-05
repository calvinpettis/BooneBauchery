package edu.appstate.cs.BooneBauchery.scenes.mainmenu;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import edu.appstate.cs.BooneBauchery.display.Display;
import edu.appstate.cs.BooneBauchery.display.gui.MenuButton;
import javafx.animation.TranslateTransition;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.SubScene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;

public class PauseSubSceneManager extends SubScene {

    private final static String FONT_PATH = "src/main/resources/assets/Fonts/a-dripping-marker/adrip1.ttf";
    //want to animate the background at some point w the layers in the assets folder
    private final static String BACKGROUND_IMAGE = "assets/Buttons/startbttn/pauseTile.png";

    //we will use this to know wether to close a window on a button press.
    private boolean isHidden;
    private MenuButton exitButton;

    public PauseSubSceneManager() {

        //Make a new window display, set to width and height of the other ones.
        super(new AnchorPane(), 1280, 720);

        prefWidth(1280);
        prefHeight(720);

        BackgroundImage background = new BackgroundImage(
                new Image(BACKGROUND_IMAGE, 326,495,false, true),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                null);
        AnchorPane root2 = (AnchorPane) this.getRoot();
        root2.setBackground(new Background(background));


        isHidden = true;
        setLayoutX(1380);
        setLayoutY(110);
        //TODO: make this go back to main menu rather than just closing out (separate class for button)
        exitButton = new MenuButton("EXIT");
        exitButton.setLayoutX(70);
        exitButton.setLayoutY(390);
        try {
            exitButton.setFont(Font.loadFont(new FileInputStream(FONT_PATH), 23));
            
        } catch (FileNotFoundException e) {
            exitButton.setFont(Font.font("Verdana", 23));
        }
        exitButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getButton().equals(MouseButton.PRIMARY))
                {
                    System.exit(0);
                }
            }
        });
        root2.getChildren().add(exitButton);

    }

    public boolean getHidden()
    {
        return isHidden;
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
            transition.setToX(-920);
            toFront();
            isHidden = false;
        }
        else
        {
            isHidden = true;
            transition.setToX(0);

        }
        transition.play();
    }

    public AnchorPane getPane()
    {
        return (AnchorPane) this.getRoot();
    }

}
