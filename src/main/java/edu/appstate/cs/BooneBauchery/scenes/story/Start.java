package edu.appstate.cs.BooneBauchery.scenes.story;

import edu.appstate.cs.BooneBauchery.display.gui.GameUI;
import edu.appstate.cs.BooneBauchery.tools.Scroller;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

/**
 * The scene that plays after the intro. This will provide a choice, if chosen
 */
public class Start {

    private Scene startScene;
    private Stage startStage;
    private Label startPrompt;
    private static final int HEIGHT = 720;
    private static final int WIDTH = 1280;

    private final static String BACKGROUND_IMAGE = "assets/Backgrounds/demohallway.png";
    private String[] prompt = {"You walk outside of the classroom " +
            "and head out into the hall.",
            "Do you want to explore or head outside?"};

    private boolean ans1 = false;
    private boolean ans2 = false;
    private static final String choice1 = "Explore";
    private static final String choice2 = "Go outside";

    public Start(Stage stage) {
        this.startStage = stage;
        createStartScene();
    }

    public Scene getStartScene()
    {
        return startScene;
    }

    public void createStartScene()
    {
        StackPane layout= new StackPane();
       // Scroller textscroll = new Scroller();
        GameUI gameUI = new GameUI();
    BackgroundImage bg = new BackgroundImage(new Image(BACKGROUND_IMAGE, 1280, 720, true, true),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                null);
        layout.setBackground(new Background(bg));

        startPrompt = new Label();
        startPrompt.setTextFill(Color.WHITE);

        startScene = new Scene(layout, WIDTH, HEIGHT);
        layout.getChildren().add(gameUI.getOverlay());
    }



}
