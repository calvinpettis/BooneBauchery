package edu.appstate.cs.BooneBauchery.scenes.story;
import static edu.appstate.cs.BooneBauchery.scenes.story.Prompts.partyaddychoice;

import edu.appstate.cs.BooneBauchery.tools.Transition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class PartyAddy extends GameScene {
    
    private static final String BKG = "/assets/Backgrounds/girlscall.png";

    private static final String girlsPrompt = Prompts.impresedgirls;

    private static final String[] choiceAnswers = Prompts.partyaddychoice;

    public PartyAddy(Stage stage)
    {
        super(stage);
        this.prompt = girlsPrompt;
        this.choice = choiceAnswers;
        setupScene();
    }

    @Override
    public void setupScene() {
        setUI();
        setBackground(BKG);
            createTextBox(girlsPrompt, 700, 220);
            createChoiceButtons(partyaddychoice[0], partyaddychoice[1]);
            choice1.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    Transition transition = new Transition(gameStage, Prompts.going2frat, new ChillFrat(gameStage));
                gameStage.setScene(transition.getTransitionScene());
                }
            });
            choice2.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    Transition transition = new Transition(gameStage, Prompts.declinesorority, new SleepyHome(gameStage));
                gameStage.setScene(transition.getTransitionScene());
                }
            });
        }
//aux text display method
public void displayText(String newText) {
    textBox.setText(newText);
}
}
