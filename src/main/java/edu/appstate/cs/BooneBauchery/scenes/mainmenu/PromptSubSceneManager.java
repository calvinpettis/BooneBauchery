package edu.appstate.cs.BooneBauchery.scenes.mainmenu;

import edu.appstate.cs.BooneBauchery.display.gui.ChoiceButton;
import edu.appstate.cs.BooneBauchery.tools.Scroller;
import javafx.animation.TranslateTransition;
import javafx.scene.Parent;
import javafx.scene.SubScene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * This handles when there is text to display during the game scenes
 */
public class PromptSubSceneManager extends SubScene {

    private static final String panelImage = "assets/Buttons/UIBanners/promptpanel.png";
    private boolean isHidden;

    private static final String FONT_PATH = "assets/Fonts/daemonesque/DAEMONES.TTF";

    private ChoiceButton choice1;
    private ChoiceButton choice2;
    private String prompt;
    private String[] choice;


    public PromptSubSceneManager(String prompt, String[] choice) {
        super(new AnchorPane(), 1280, 720);
        prefWidth(1280);
        prefHeight(720);

        BackgroundImage bg = new BackgroundImage(
                new Image(panelImage, 700, 560, false, true),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                null);
        AnchorPane root2 = (AnchorPane) this.getRoot();
        root2.setBackground(new Background(bg));

        isHidden = true;
        setLayoutX(1500);
        setLayoutY(-10);

        Label promptLabel = new Label();
        try {
            promptLabel.setFont(Font.loadFont(new FileInputStream(FONT_PATH), 20));
        } catch (FileNotFoundException fnfe)
        {
            promptLabel.setFont(Font.font("Verdana", 20));
        }
        promptLabel.setText(prompt);
        promptLabel.setLayoutX(0);
        promptLabel.setLayoutY(0);
        root2.getChildren().add(promptLabel);



    }


    public boolean getHidden() {
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
