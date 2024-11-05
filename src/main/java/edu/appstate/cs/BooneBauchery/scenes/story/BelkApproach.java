package edu.appstate.cs.BooneBauchery.scenes.story;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;


public class BelkApproach extends GameScene {
    
    private static final String BKG = "/assets/Backgrounds/demohallway.png";

    private static final String approachPrompt = Prompts.belk1response1;

    private static final String[] choiceAnswers = {"TRAVEL ONWARDS"};

    public BelkApproach(Stage stage)
    {
        super(stage);
        this.prompt = approachPrompt;
        this.choice = choiceAnswers;
        setupScene();
    }

    @Override
    public void setupScene() {
        setUI();
        setBackground(BKG);
        createTextBox(approachPrompt, 700, 150);
        createContinueButton(choiceAnswers[0]);
        continueBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                // travel onwards transition HERE
            }
        });
    }


    //aux text display method
    public void displayText(String newText) {
        textBox.setText(newText);
    }
}
