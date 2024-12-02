package edu.appstate.cs.BooneBauchery.scenes.story;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

import static edu.appstate.cs.BooneBauchery.scenes.story.Prompts.*;

import edu.appstate.cs.BooneBauchery.main.Main;

public class ChillFrat extends GameScene {
    private static final String BKG = "/assets/Backgrounds/chillfrat.png";

    private static final String runPrompt = Prompts.chillfratparty;

    private static final String[] onward = Prompts.travelOnward;

    public ChillFrat(Stage stage)
    {
        super(stage);
        this.prompt = runPrompt;
        this.choice = onward;
        setupScene();
    }

    @Override
    public void setupScene() {
        setUI();
        setBackground(BKG);
        createTextBox(runPrompt, 700, 180);
        createContinueButton(onward[0]);
        continueBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //you get to party with greek life girls .. swagggg!
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
