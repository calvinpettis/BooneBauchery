package edu.appstate.cs.BooneBauchery.display.gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.text.Font;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Adds a label to a banner. Sets font, location, and banner image
 */
public class InfoLabel extends Label {

    public final static String FONT_PATH = "src/main/resources/assets/Fonts/blood-crow/bloodcrow.ttf";

    public final static String BACKGORUND_IMAGE = "assets/Buttons/UIBanners/Banner.png";

    public InfoLabel(String text)
    {
        setPrefWidth(600);
        setPrefHeight(200);
        setPadding(new Insets(40,40,40,40));
        setText(text);
        setWrapText(true);
        setLabelFont();
        setAlignment(Pos.CENTER);

        BackgroundImage background = new BackgroundImage(new Image(BACKGORUND_IMAGE, 330, 49, false, true),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                null);
        setBackground(new Background(background));
    }

    private void setLabelFont()
    {
        try {
            setFont(Font.loadFont(new FileInputStream(new File(FONT_PATH)), 22));
        } catch (FileNotFoundException e) {
            setFont(Font.font("Verdana", 23));
        }
    }

}
