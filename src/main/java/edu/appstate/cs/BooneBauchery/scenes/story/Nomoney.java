package edu.appstate.cs.BooneBauchery.scenes.story;
import edu.appstate.cs.BooneBauchery.tools.Transition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

import static edu.appstate.cs.BooneBauchery.scenes.story.Prompts.*;

public class Nomoney extends GameScene {
    // you invested in appcoin (get scammed)
    private static final String BKG = "/assets/Backgrounds/nomoney.png";

    private static final String losemoneyPrompt = Prompts.nomoney;

    private static final String[] choiceAnswers = Prompts.gameOver;

    public Nomoney(Stage stage)
    {
        super(stage);
        this.prompt = losemoneyPrompt;
        this.choice = choiceAnswers;
        setupScene();
    }

    @Override
    public void setupScene() {
        setUI();
        setBackground(BKG);
        createTextBox(losemoneyPrompt, 700, 150);
        createContinueButton(choiceAnswers[0]);
        continueBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //unique game over art displayed in current scene
                //this button takes you to game over art to restart loop
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
