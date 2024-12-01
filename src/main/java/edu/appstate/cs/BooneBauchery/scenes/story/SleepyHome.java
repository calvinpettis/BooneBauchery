package edu.appstate.cs.BooneBauchery.scenes.story;


import edu.appstate.cs.BooneBauchery.tools.Transition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static edu.appstate.cs.BooneBauchery.scenes.story.Prompts.*;

import edu.appstate.cs.BooneBauchery.main.Main;

//backroad home -> decline call leads to ... 
    //--> go home sober tired (neutral ending) you sleep and dont party
    // (no game over screen) >> sleepy in bed art 
    //      >> main menu
public class SleepyHome extends GameScene {
      
    
    private final static String BKG = "/assets/Backgrounds/sleepin.png";

    // CHANGE THIS BELOW
    private static final String sleepyPrompt = Prompts.sleepyprompt;
    private static final String[] sleep = Prompts.travelOnward;

    public SleepyHome(Stage stage)
    {
        super(stage);
        this.prompt = sleepyPrompt;
        this.choice = sleep;
        setupScene();
    }

    @Override
    public void setupScene() {
        setUI();
        setBackground(BKG);
        createTextBox(sleepyPrompt, 700, 150);
        createContinueButton(sleep[0]);
        continueBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                // since not a bad ending we just restart main menu
                gameStage.close();
                Main.startloop(gameStage);
        }});
        
    }

    public void displayText(String newText) {
        textBox.setText(newText);
    }
}