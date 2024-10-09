package edu.appstate.cs.BooneBauchery.scenes;

import javafx.scene.Parent;
import javafx.scene.SubScene;
import javafx.scene.layout.AnchorPane;

public class subSceneManager extends SubScene {

    private final static String FONT_PATH = "/assets/Fonts/blood-crow/bloodcrow.ttf";
    private final static String BACKGROUND_IMAGE = "";


    public subSceneManager() {
        super(new AnchorPane(), 1280, 720);
    }
}
