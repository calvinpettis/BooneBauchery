package edu.appstate.cs.BooneBauchery.scenes.story;
import edu.appstate.cs.BooneBauchery.tools.Transition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

import static edu.appstate.cs.BooneBauchery.scenes.story.Prompts.belk2sanford;

import static edu.appstate.cs.BooneBauchery.scenes.story.Prompts.*;


public class SororityDefend extends GameScene {

    private static final String BKG = "/assets/Backgrounds/commoncast.png";

    private static final String approachPrompt = sanford2response2;

    private static final String[] choiceAnswers = Prompts.travelOnward;

    public SororityDefend(Stage stage)
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
                // transiton you are told of a possible party...
                Transition transition = new Transition(gameStage, girlslikethat, new PartyAddy(gameStage));
                gameStage.setScene(transition.getTransitionScene());
            }
        });
    }


    //aux text display method
    public void displayText(String newText) {
        textBox.setText(newText);
    }
}
