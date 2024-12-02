package edu.appstate.cs.BooneBauchery.scenes.story;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;


public class WonderWild extends GameScene {
    
    private static final String BKG = "/assets/Backgrounds/scarywoods.png";

    private static final String runPrompt = Prompts.verylost;

    private static final String[] choiceAnswers = Prompts.travelOnward;

    public WonderWild(Stage stage)
    {
        super(stage);
        this.prompt = runPrompt;
        this.choice = choiceAnswers;
        setupScene();
    }

    @Override
    public void setupScene() {
        setUI();
        setBackground(BKG);
        createTextBox(runPrompt, 700, 150);
        createContinueButton(choiceAnswers[0]);
        continueBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //literally you got lost what the flip.. lol game over
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
