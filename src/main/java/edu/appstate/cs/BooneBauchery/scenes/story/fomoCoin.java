package edu.appstate.cs.BooneBauchery.scenes.story;
import edu.appstate.cs.BooneBauchery.tools.Transition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

import static edu.appstate.cs.BooneBauchery.scenes.story.Prompts.*;


public class fomoCoin extends GameScene {

    private static final String BKG = "/assets/Backgrounds/appcoin.png";

    private static final String stillBroke = fomoCoin;

    private static final String[] choiceAnswers = Prompts.travelOnward;

    public fomoCoin(Stage stage)
    {
        super(stage);
        this.prompt = stillBroke;
        this.choice = choiceAnswers;
        setupScene();
    }

    @Override
    public void setupScene() {
        setUI();
        setBackground(BKG);
        createTextBox(stillBroke, 700, 300);
        createContinueButton(choiceAnswers[0]);
        continueBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                // Setup game over for after no money art
                GameOver gameover = new GameOver(gameStage);
                gameStage.setScene(gameover);

            }
        });
    }


    //aux text display method
    public void displayText(String newText) {
        textBox.setText(newText);
    }
}
