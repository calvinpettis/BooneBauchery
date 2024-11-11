package edu.appstate.cs.BooneBauchery.tools;
import edu.appstate.cs.BooneBauchery.scenes.story.GameScene;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.input.KeyEvent;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


/**
 * Transition class for inbetween scenes.
 *
 */
public class Transition {
    private Scene transitionScene;
    private final Stage transitionStage;
    private Label transitionLabel;
    private static final int HEIGHT = 720;
    private static final int WIDTH = 1280;

    private final static String FONT_PATH = "src/main/resources/assets/Fonts/a-dripping-marker/adrip1.ttf";

    //adding timeline object here so we can manipulate
    //throughout different if else trees
    private Timeline timeline; //declared at class level instead of in method scope
    private int lineindex = 0;
    private int charindex = 0;
    private boolean isScrolling = true;
    private StringBuilder sb = new StringBuilder();

    private final String[] transitionScript;
    private GameScene sceneAfter;

    public Transition(Stage stage, String[] prompt, GameScene nextScene)
    {
        this.sceneAfter = nextScene;
        this.transitionScript = prompt;
        this.transitionStage = stage;
        createTransitionScene();
    }

    public void createTransitionScene()
    {
        //create new pane to lay out all the new fields in, make it black for transition.
        //same as anchorpane, just different implementation.
        StackPane layout = new StackPane();
        layout.setStyle("-fx-background-color: black");

        transitionLabel = new Label();
        transitionLabel.setTextFill(Color.WHITE);
        try
        {
            transitionLabel.setFont(Font.loadFont(new FileInputStream(FONT_PATH), 47));
        }catch (FileNotFoundException fnfe)
        {
            transitionLabel.setFont(Font.font("Verdana", 50));
        }
        transitionLabel.setWrapText(true);
        transitionLabel.setAlignment(Pos.CENTER);
        layout.getChildren().add(transitionLabel);
        transitionScene = new Scene(layout, WIDTH, HEIGHT);
        transitionScene.setOnKeyPressed(this::handleKeyPress);
        startStringScroll();
    }

    public void startStringScroll() {
        if (isScrolling) {
            showNextLine();
        }
    }

    public Scene getTransitionScene()
    {
        return transitionScene;
    }


    /**
     * Should print the string in a scrolling fashion.
     * Use timeline to make frames
     *
     * hunter: this method SHOULD display text in a scrolling fashion
     *      as well as, Pause in between displayed text.
     *      original method for text scrolling was very fast with no pause
     *
     *
     *
     * TODO: move this to a seperate class to be used repeatedly, also add pause in between sentences
     */
    private void showNextLine() {
        //Reset the StringBuilder and char index for the new line
        sb.setLength(0);
        charindex = 0;

        timeline = new Timeline(new KeyFrame(Duration.seconds(0.08), event ->{
            // Append each character to the StringBuilder
            sb.append(transitionScript[lineindex].charAt(charindex));
            transitionLabel.setText(sb.toString());  //update label with current text
            charindex++;

            if (charindex >= transitionScript[lineindex].length()) {
                timeline.stop();
                lineindex++;

                //Pause when line is fully displayed
                PauseTransition pause = new PauseTransition(Duration.seconds(1.5));
                pause.setOnFinished(e -> {
                    transitionLabel.setText("");     //clear label
                    if (lineindex < transitionScript.length) {
                        showNextLine();
                    } else {
                        isScrolling = false;
                        transition2next(sceneAfter);
                    }
                });
                pause.play();
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }


    public void transition2next(GameScene gameScene)
    {
        transitionStage.setScene(gameScene);
    }


    public void handleKeyPress(KeyEvent keyEvent)
    {
        if (keyEvent.getCode().equals(KeyCode.SPACE) && isScrolling)
        {
            isScrolling = false;
            if (timeline != null)
            {
                timeline.stop();
            }
            sb.delete(0, sb.length());
            transition2next(sceneAfter);
        }
    }

}

