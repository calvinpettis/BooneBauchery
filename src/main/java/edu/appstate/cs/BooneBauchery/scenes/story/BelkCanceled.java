package edu.appstate.cs.BooneBauchery.scenes.story;
import static edu.appstate.cs.BooneBauchery.scenes.story.Prompts.gameOver;

import edu.appstate.cs.BooneBauchery.tools.Transition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import edu.appstate.cs.BooneBauchery.main.Main;


public class BelkCanceled extends GameScene{
    
    // change this path to sunset sadness walk off pixelated image
    private static final String BKG = "/assets/Backgrounds/gameoverBKG.png";

    private static final String cancelPrompt = Prompts.belkGameOver;
    private static final String[] examine = Prompts.examine;

    public BelkCanceled(Stage stage)
    {
        super(stage);
        this.prompt = cancelPrompt;
        this.choice = examine;
    }

    @Override
    public void setupScene() {
        setUI();
        setBackground(BKG);
        createTextBox(cancelPrompt, 700, 150);
        createContinueButton(gameOver[0]);
        continueBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                gameStage.close();
                Main.startloop(gameStage);
        }});
        
    }

    public void displayText(String newText) {
        textBox.setText(newText);
    }
}
