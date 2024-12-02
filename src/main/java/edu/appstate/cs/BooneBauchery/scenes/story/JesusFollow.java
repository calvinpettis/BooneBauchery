package edu.appstate.cs.BooneBauchery.scenes.story;
import edu.appstate.cs.BooneBauchery.tools.Transition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

import static edu.appstate.cs.BooneBauchery.scenes.story.Prompts.*;

public class JesusFollow extends GameScene {
    
    private static final String BKG = "/assets/Backgrounds/crazymanchase.png";

    private static final String runPrompt = Prompts.jesusfollow;

    private static final String[] choiceAnswers = Prompts.followChoices;

    public JesusFollow(Stage stage)
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
            createTextBox(runPrompt, 700, 250);
            createChoiceButtons(choiceAnswers[0], choiceAnswers[1]);
            choice1.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    Transition transition = new Transition(gameStage, Prompts.wonderingon, new WonderWild(gameStage));
                gameStage.setScene(transition.getTransitionScene());
                }
            });
            choice2.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    Transition transition = new Transition(gameStage, Prompts.hipbar, new HipBar(gameStage));
                gameStage.setScene(transition.getTransitionScene());
                }
            });
        }
//aux text display method
public void displayText(String newText) {
    textBox.setText(newText);
}
}
