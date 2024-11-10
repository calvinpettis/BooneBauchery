package edu.appstate.cs.BooneBauchery.display.gui;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ChoiceButton extends Button {

    //These are the paths to the font, and the style of buttons
    private final String FONT_PATH = "src/main/resources/assets/Fonts/a-dripping-marker/adrip1.ttf";
    //background is transparent bc we have our own image, then put path to file
    private final String BUTTON_UNPRESSED_STYLE = "-fx-background-color: transparent; -fx-background-image: url(/assets/Buttons/startbttn/button_unpressed.png);";
    private final String BUTTON_PRESSED_STYLE = "-fx-background-color: transparent; -fx-background-image: url(/assets/Buttons/startbttn/buttonpressed.png);";

    /**
     * Sets the button up.
     * @param text the String to be put in the button.
     */
    public ChoiceButton(String text)
    {
        //put whatever is in the argument above onto the button
        setText(text);
        //set font
        setButtonFont();
        //width of button (play with these to get things looking right, might scale funny idk)
        setPrefWidth(190);
        //height of button
        setPrefHeight(50);
        //default is not pressed image
        setStyle(BUTTON_UNPRESSED_STYLE);
        //Set up what happens if you interact with the button
        initializeButtonListeners();
    }

    /**
     * Set the font
     */
    private void setButtonFont()
    {
        //try to load our spooky scary font, if not load some default one. Play with font size (2nd arg to loadFont()) for different buttons & fonts
        try {
            setFont(Font.loadFont(new FileInputStream(FONT_PATH), 22));
            setTextFill(Color.BLACK);
        } catch (FileNotFoundException e) {
            setFont(Font.font("Verdana", 22));
        }
    }

    /**
     * This is what it looks like when the button is pressed.
     */
    private void setButtonPressedStyle()
    {
        //add image
        setStyle(BUTTON_PRESSED_STYLE);
        //set height location (4 lower to make it look like button went down)
        setPrefHeight(46);
        //4 pixels smaller than the unpressed one.
        setLayoutY(getLayoutY() + 4);
    }

    /**
     * Sets the style of a released button (or free)
     */
    private void setButtonNotPressedStyle()
    {
        setStyle(BUTTON_UNPRESSED_STYLE);
        setPrefHeight(50);
        setLayoutY(getLayoutY() - 4);
    }

    public void initializeButtonListeners()
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
