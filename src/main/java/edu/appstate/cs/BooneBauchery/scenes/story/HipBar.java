package edu.appstate.cs.BooneBauchery.scenes.story;
import static edu.appstate.cs.BooneBauchery.scenes.story.Prompts.hipsterbar;

import edu.appstate.cs.BooneBauchery.main.Main;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class HipBar extends GameScene {
    
    private static final String BKG = "/assets/Backgrounds/hipsterbar.png";

    private static final String approachPrompt = hipsterbar;

    private static final String[] choiceAnswers = Prompts.travelOnward;

    public HipBar(Stage stage)
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
                //good ending you get to drink a lot of tasty unique hipster drinks.
                gameStage.close();
                Main.startloop(gameStage);
            }
        });
    }


}
