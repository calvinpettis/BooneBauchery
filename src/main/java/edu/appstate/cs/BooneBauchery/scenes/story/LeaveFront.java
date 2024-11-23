package edu.appstate.cs.BooneBauchery.scenes.story;
import edu.appstate.cs.BooneBauchery.mingames.GameLoop;
import edu.appstate.cs.BooneBauchery.tools.Transition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static edu.appstate.cs.BooneBauchery.scenes.story.Prompts.hurricanePrompt;

public class LeaveFront extends GameScene{
    //in this class AFTER prompt is played 
    // you can answer a call --> hang with friends
    // or go home bc sleepy --> bad ending you dont drink beer 
    //(add asset of being sober and sad then 
    //transition to game over art)

    //change this background to waling down the road looking at a phone asset?
    private static final String BKG = "/assets/Backgrounds/walkingdownroad.png";

    private static final String answerOrWalk = Prompts.phoneORWalk;
    private static final String[] choices = Prompts.walkingChoices;

    public LeaveFront(Stage stage) {
        super(stage);

        this.prompt = answerOrWalk;
        this.choice = choices;
        setupScene();
    }

    @Override
    public void setupScene() {

        setUI();
        setBackground(BKG);

        createTextBox(answerOrWalk, 800, 250);
        createChoiceButtons(choices[0], choices[1]);
        choice1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //Transition to good ending we hang with friends
                Transition transition = new Transition(gameStage, Prompts.pickup, new OneMilBeers(gameStage));
                gameStage.setScene(transition.getTransitionScene());
            }
        });
        choice2.setOnAction(new EventHandler<ActionEvent>() {
            //This starts the hurricane minigame!
            @Override
            public void handle(ActionEvent actionEvent) {
                //transition to bad ending we go home sober

            }
        });
    }


    
}
