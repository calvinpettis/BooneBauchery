package edu.appstate.cs.BooneBauchery.display.gui;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;


public class PauseButton extends Button {
    Button pauseButton = new Button();
    private boolean isHidden;
    private final String BUTTON_UNPRESSED_STYLE = "-fx-background-color: transparent; -fx-background-image: url(/assets/Buttons/UIBttn/pauseUnpressed.png);";
    private final String BUTTON_PRESSED_STYLE = "-fx-background-color: transparent; -fx-background-image: url(/assets/Buttons/UIBttn/pauseUnpressed.png);";
    public PauseButton()
    {
        setPrefWidth(90);
        setPrefHeight(70);
        setStyle(BUTTON_UNPRESSED_STYLE);
        initializeButtonListeners();

    }

    private void setButtonPressedStyle()
    {
        setStyle(BUTTON_PRESSED_STYLE);
        setPrefHeight(66);
        setLayoutY(getLayoutY() + 4);
    }

    private void setButtonUnpressedStyle()
    {
        setStyle(BUTTON_UNPRESSED_STYLE);
        setPrefHeight(70);
        setLayoutY(getLayoutY() - 4);
    }

    private void initializeButtonListeners()
    {
        setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getButton().equals(MouseButton.PRIMARY))
                {
                    setButtonPressedStyle();

                }
            }
        });

        setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getButton().equals(MouseButton.PRIMARY))
                {
                    setButtonUnpressedStyle();
                }
            }
        });

        setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setEffect(new DropShadow());
            }
        });

        setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setEffect(null);
            }
        });
    }


}
