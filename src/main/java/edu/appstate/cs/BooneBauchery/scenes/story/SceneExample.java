package edu.appstate.cs.BooneBauchery.scenes.story;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;


/**
 * Will rename this Start after I get everything working
 */
public class SceneExample extends GameScene {

    // TRUE BEGINNING scene first thing user sees when intro finishes

    private static final String BKG = "/assets/Backgrounds/demohallway.png";

    private static final String exPrompt = Prompts.belkintro;
    private static final String[] choiceAnswers = Prompts.introchoices;

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
        createTextBox(exPrompt, 700, 150);
        createChoiceButtons(choiceAnswers[0], choiceAnswers[1]);
        choice1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                BelkHall belk = new BelkHall(gameStage);
                gameStage.setScene(belk);
            }
        });
        choice2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                SanfordMall sandford = new SanfordMall(gameStage);
                gameStage.setScene(sandford);
            }
        });
    }

    public void displayText(String newText) {
        textBox.setText(newText);
    }
}
