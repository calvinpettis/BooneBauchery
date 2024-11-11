package edu.appstate.cs.BooneBauchery.scenes.story;
import edu.appstate.cs.BooneBauchery.tools.Transition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import static edu.appstate.cs.BooneBauchery.scenes.story.Prompts.*;
import edu.appstate.cs.BooneBauchery.tools.Transition;

public class FeralAttack extends GameScene {

    private static final String BKG = "/assets/Backgrounds/feralcs.png";

    private static final String atkPrompt = Prompts.feralAtk;
    private static final String[] atkChoice = Prompts.feralAtkChoice;

    public FeralAttack(Stage stage)
    {
        super(stage);

        this.prompt = atkPrompt;
        this.choice = atkChoice;
    }
    
    @Override 
    public void setupScene()
    {
        setUI();
        setBackground(BKG);
        createTextBox(atkPrompt, 700, 300);
        createChoiceButtons(atkChoice[0], atkChoice[1]);

        choice1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //sneak out of back of building
            }
        });
        choice2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //leave out of front of building
                Transition transition = new Transition(gameStage, Prompts.leaveFront, new LeaveFront(gameStage));
                gameStage.setScene(transition.getTransitionScene());
            }
        });

    }


}
