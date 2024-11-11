package edu.appstate.cs.BooneBauchery.scenes.story;
import static edu.appstate.cs.BooneBauchery.scenes.story.Prompts.gameOver;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import edu.appstate.cs.BooneBauchery.main.Main;


public class GameOver extends GameScene{
    
    // Gameover art 
    private static final String BKG = "/assets/Backgrounds/gameoverNBKG.png";

    private static final String cancelPrompt = "";
    private static final String[] examine = {""};

    public GameOver(Stage stage)
    {
        super(stage);
        this.prompt = cancelPrompt;
        this.choice = examine;
    }

    @Override
    public void setupScene() {
        setUI();
        setBackground(BKG);
        //no text on screen
        //createTextBox(cancelPrompt, 700, 150);
        createContinueButton(gameOver[0]);
        continueBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //new : go to game over screen for game over art and then get back to main menu
                // below approach OLD: to ending the game loop and getting back to main menu.
                gameStage.close();
                Main.startloop(gameStage);
        }});
        
    }

    public void displayText(String newText) {
        textBox.setText(newText);
    }
}
