package edu.appstate.cs.BooneBauchery.scenes.story;

import static edu.appstate.cs.BooneBauchery.scenes.story.Prompts.pencilfear;

import edu.appstate.cs.BooneBauchery.main.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class DodgePencil extends GameScene {
    private static final String BKG = "/assets/Backgrounds/pencilfear.png";

    private static final String approachPrompt = pencilfear;

    private static final String[] choiceAnswers = Prompts.travelOnward;

    public DodgePencil(Stage stage)
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
                // you drink one million beers with cops! cop drink beer swag ending 
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
