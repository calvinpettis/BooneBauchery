package edu.appstate.cs.BooneBauchery.scenes.story;
import edu.appstate.cs.BooneBauchery.tools.Transition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

import static edu.appstate.cs.BooneBauchery.scenes.story.Prompts.*;

public class BelkApproach extends GameScene {
    
    // you walk up to scary professor scene
    //      --> travel onwars (to sanfordmall) 

    private static final String BKG2 = "/assets/Backgrounds/professor.png";

    private static final String approachPrompt = Prompts.belk1response1;

    private static final String[] choiceAnswers = Prompts.travelOnward;

    public BelkApproach(Stage stage)
    {
        super(stage);
        this.prompt = approachPrompt;
        this.choice = choiceAnswers;
        setupScene();
    }

    @Override
    public void setupScene() {
        setUI();
        setBackground(BKG2);
        createTextBox(approachPrompt, 700, 150);
        createContinueButton(choiceAnswers[0]);
        continueBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Transition transition = new Transition(gameStage, chilProf, new SanfordMall(gameStage));
                gameStage.setScene(transition.getTransitionScene());
            }
        });
    }


    //aux text display method
    public void displayText(String newText) {
        textBox.setText(newText);
    }
}
