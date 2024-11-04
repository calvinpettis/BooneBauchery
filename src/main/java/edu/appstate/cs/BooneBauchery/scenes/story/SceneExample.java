package edu.appstate.cs.BooneBauchery.scenes.story;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;


/**
 * Will rename this Start after I get everything working
 */
public class SceneExample extends GameScene {


    private static final String BKG = "/assets/Backgrounds/demohallway.png";

    private static final String exPrompt = Prompts.belkintro;
    private static final String[] choiceAnswers = {"GO OUTSIDE", "EXPLORE"};
    private boolean ans1;
    private boolean ans2;

    public SceneExample(Stage stage) {
        super(stage);
        //Will have to add these two lines until I find a better way
        this.prompt = exPrompt;
        this.choice = choiceAnswers;
        setupScene();
    }

    @Override
    public void setupScene() {
        setUI();
        setBackground(BKG);
        createTextBox(exPrompt);
        createChoiceButtons(choiceAnswers[0], choiceAnswers[1]);
        choice1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

            }
        });
        choice2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                BelkHall belk = new BelkHall(gameStage);
                gameStage.setScene(belk);
            }
        });
    }

    public void displayText(String newText) {
        textBox.setText(newText);
    }
}
