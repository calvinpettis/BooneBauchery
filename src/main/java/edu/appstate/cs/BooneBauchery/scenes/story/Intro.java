package edu.appstate.cs.BooneBauchery.scenes.story;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
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

    //adding timeline object here so we can manipulate
    //throughout different if else trees
    private Timeline timeline; //declared at class level instead of in method scope
    private int lineindex = 0;
    private int charindex = 0;
    private boolean isScrolling = true;
    private StringBuilder sb = new StringBuilder();

    private static final String[] introScript = {"In the town of Boone, North Carolina...",
            "It is 3:00PM the Friday before Spring break,",
            "And you just left your\nSoftware Engineering class\nto finish up the week.",
            "It's time to party...",
            "You just have to make it out of town...\n\nALIVE!"};

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

    public void startStringScroll() {
        if (isScrolling) {
            showNextLine();
        }
    }

     /**
     * Should print the string in a scrolling fashion.
     * Use timeline to make frames
     * 
     * hunter: this method SHOULD display text in a scrolling fashion 
     *      as well as, Pause in between displayed text. 
     *      original method for text scrolling was very fast with no pause
     * 
     *      listed under name "startStringScroll2" DELETE OLD METHOD?
     * 
     * TODO: move this to a seperate class to be used repeatedly, also add pause in between sentences
     */
    private void showNextLine() {
        //Reset the StringBuilder and char index for the new line 
        sb.setLength(0);
        charindex = 0;

        timeline = new Timeline(new KeyFrame(Duration.seconds(0.08), event ->{
            // Append each character to the StringBuilder
            sb.append(introScript[lineindex].charAt(charindex));
            introLabel.setText(sb.toString());  //update label with current text
            charindex++;

            if (charindex >= introScript[lineindex].length()) {
                timeline.stop();
                lineindex++;

                //Pause when line is fully displayed
                PauseTransition pause = new PauseTransition(Duration.seconds(1.5));
                pause.setOnFinished(e -> {
                    introLabel.setText("");     //clear label
                    if (lineindex < introScript.length) {
                        showNextLine();
                    } else {
                        isScrolling = false;
                        transitionScene();   //build in scence transion here??
                    }
                });
                pause.play();
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }


   
    public void startStringScroll2() {
        if (isScrolling) {
            //the contents inside the timeline will happen every 0.07 seconds. Adjust for faster or slower

            /*Timeline*/ timeline = new Timeline(new KeyFrame(Duration.seconds(0.7), e -> {
                //if we are not through the entire array of the script
                if (lineindex < introScript.length) {
                    //if we are not all the way through the string
                    if (charindex < introScript[lineindex].length()) {
                        sb.append(introScript[lineindex].charAt(charindex));
                        //set text to what has already been displayed and add the new char
                        introLabel.setText(sb.toString());
                        charindex++;
                    } else {
                        timeline.stop(); // Stop the timeline briefly

                        //pause for 1.5 seconds after line of text displayed
                        PauseTransition pause = new PauseTransition(Duration.seconds(1.5));
                        pause.setOnFinished(event -> {
                        //else we are on a new line, reset char index, increment line coun
                        lineindex++;
                        charindex = 0;
                        sb.delete(0, sb.length());
                        sb.append("\n");
                        introLabel.setText(sb.toString());

                        // resume the timeline after pause ENDS
                        timeline.play();
                        });
                    }

                } else {
                    //this is a wonky way to start up our game. But it is what I am doing
                    //Game newgame = new Game();
                   isScrolling = false;
                   if (timeline != null)
                   {
                       timeline.stop();
                   }
                   transitionScene();
                }
            }));
            timeline.setCycleCount(Animation.INDEFINITE);
            timeline.play();
        }
    }

    public void transitionScene()
    {

        SceneExample example = new SceneExample(introStage);
        introStage.setScene(example);
        // startGameLoop start = new startGameLoop();
        //start.start();
    }

}
