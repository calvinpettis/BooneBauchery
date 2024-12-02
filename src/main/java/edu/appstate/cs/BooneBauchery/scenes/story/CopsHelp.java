package edu.appstate.cs.BooneBauchery.scenes.story;

import static edu.appstate.cs.BooneBauchery.scenes.story.Prompts.copsrswag;

import edu.appstate.cs.BooneBauchery.main.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class CopsHelp extends GameScene {
    private static final String BKG = "/assets/Backgrounds/copswag.png";

    private static final String approachPrompt = copsrswag;

    private static final String[] choiceAnswers = Prompts.travelOnward;

    public CopsHelp(Stage stage)
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
        createTextBox(approachPrompt, 700, 250);
        createContinueButton(choiceAnswers[0]);
        continueBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                // you drink one million beers with cops! cop drink beer swag ending 
                gameStage.close();
                Main.startloop(gameStage);
            }
        });
    }


    //aux text display method
    public void displayText(String newText) {
        textBox.setText(newText);
    }
}
