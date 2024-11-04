package edu.appstate.cs.BooneBauchery.display.gui;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * This is an example class of how to make a button.
 * Looks complicated, but you can copy & paste this class and just modify to make new ones! Can do this for lots of files.
 * We can still keep keyboard-based input for story, just nice to have a start button.
 */
public class PauseButton extends Button {


    //These are the paths to the font, and the style of buttons
    private final String FONT_PATH = "src/main/resources/assets/Fonts/a-dripping-marker/adrip1.ttf";
    //background is transparent bc we have our own image, then put path to file
    private final String BUTTON_UNPRESSED_STYLE = "-fx-background-color: transparent; -fx-background-image: url(/assets/Buttons/UIBttn/pauseUnpressed.png);";
    private final String BUTTON_PRESSED_STYLE = "-fx-background-color: transparent; -fx-background-image: url(/assets/Buttons/UIBttn/pausePressed.png);";

    /**
     * Sets the button up.
     *
     */
    public PauseButton()
    {
        //width of button (play with these to get things looking right, might scale funny idk)
        setPrefWidth(77);
        //height of button
        setPrefHeight(26);
        //default is not pressed image
        setStyle(BUTTON_UNPRESSED_STYLE);
        //Set up what happens if you interact with the button
        initializeButtonListeners();

        setFont(Font.font(FONT_PATH));
    }

    /**
     * This is what it looks like when the button is pressed.
     */
    private void setButtonPressedStyle()
    {
        //add image
        setStyle(BUTTON_PRESSED_STYLE);
        //set height location (4 lower to make it look like button went down)
        setPrefHeight(24);
        //2 pixels smaller than the unpressed one.
        setLayoutY(getLayoutY() + 2);
    }

    /**
     * Sets the style of a released button (or free)
     */
    private void setButtonNotPressedStyle()
    {
        setStyle(BUTTON_UNPRESSED_STYLE);
        setPrefHeight(26);
        setLayoutY(getLayoutY() - 2);
    }

    private void initializeButtonListeners()
    {
        // if you press the button, set correlated style.
        setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                //first check to see if left click
                if (mouseEvent.getButton().equals(MouseButton.PRIMARY))
                {
                    setButtonPressedStyle();
                }
            }
        });
        // set style for mouse released
        setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                //first check to see if left click
                if (mouseEvent.getButton().equals(MouseButton.PRIMARY))
                {
                    setButtonNotPressedStyle();
                }
            }
        });

        //drop shadow effect bc we're fancy
        setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setEffect(new DropShadow());
            }
        });
        //remove drop shadow effect bc we're fancy
        setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setEffect(null);
            }
        });
    }





}
