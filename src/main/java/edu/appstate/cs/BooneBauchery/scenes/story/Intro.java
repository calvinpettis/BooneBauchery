package edu.appstate.cs.BooneBauchery.scenes.story;
import edu.appstate.cs.BooneBauchery.main.Game;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;


/**
 * Displays after you click the start button.
 * Features scrolling text on a black background
 * TODO: add better implementation for starting a new game
 * TODO: make a constants file holding width, height, fonts, things we use lots
 *
 */
public class Intro {
    private Scene introScene;
    private final Stage introStage;
    private Label introLabel;
    private static final int HEIGHT = 720;
    private static final int WIDTH = 1280;

    private final static String FONT_PATH = "/assets/Fonts/blood-crow/bloodcrow.ttf";

    private static final String[] introScript = {"In the town of Boone, North Carolina..",
            "It is 3:00PM the Friday before Spring break, ",
            "and you just left your Software Engineering class to finish up the week.",
            "It's time to party...",
            "you just have to make it out of town alive first!"};

    public Intro(Stage stage)
    {
       this.introStage = stage;
       createIntroScene();
    }

    public Scene getIntroScene()
    {
        return introScene;
    }

    public void createIntroScene()
    {
        //create new pane to lay out all the new fields in, make it black for intro.
        //same as anchorpane, just different implementation.
        StackPane layout = new StackPane();
        layout.setStyle("-fx-background-color: black");

        introLabel = new Label();
        introLabel.setTextFill(Color.WHITE);
        introLabel.setFont(new Font(FONT_PATH, 40));
        introLabel.setWrapText(true);
        introLabel.setAlignment(Pos.CENTER);

       layout.getChildren().add(introLabel);
       introScene = new Scene(layout, WIDTH, HEIGHT);

       startStringScroll();
    }

    private int lineindex = 0;
    private int charindex = 0;
    private StringBuilder sb = new StringBuilder();
    private boolean isScrolling = true;
    /**
     * Should print the string in a scrolling fashion.
     * Use timeline to make frames
     * TODO: move this to a seperate class to be used repeatedly
     */
    public void startStringScroll() {
        if (isScrolling) {
            //the contents inside the timeline will happen every 0.07 seconds. Adjust for faster or slower
            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.07), e -> {
                //if we are not through the entire array of the script
                if (lineindex < introScript.length) {
                    //if we are not all the way through the string
                    if (charindex < introScript[lineindex].length()) {
                        sb.append(introScript[lineindex].charAt(charindex));
                        //set text to what has already been displayed and add the new char
                        introLabel.setText(sb.toString());
                        charindex++;
                    } else {
                        //else we are on a new line, reset char index, increment line coun
                        lineindex++;
                        charindex = 0;
                        sb.delete(0, sb.length());
                        sb.append("\n");
                        introLabel.setText(sb.toString());
                    }

                } else {
                    //this is a wonky way to start up our game. But it is what I am doing
                    //Game newgame = new Game();
                   isScrolling = false;
                   transitionScene();
                }
            }));
            timeline.setCycleCount(Animation.INDEFINITE);
            timeline.play();
        }
    }

    public void transitionScene()
    {
        introStage.setScene(null);
        Start start = new Start(introStage);
        introStage.setScene(start.getStartScene());
    }

}
