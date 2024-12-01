package edu.appstate.cs.BooneBauchery.scenes.story;

import edu.appstate.cs.BooneBauchery.tools.Transition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Walking2Bar extends GameScene{

    private static final String BKG = "/assets/Backgrounds/youseebar.png";

    private static final String seebarPrompt = Prompts.seebar;
    private static final String[] answerchoices = Prompts.seeBarChoices;
    
    public Walking2Bar(Stage stage) {
        super(stage);

        this.prompt = seebarPrompt;
        this.choice = answerchoices;
        setupScene();
    }

    @Override
    public void setupScene() {

        setUI();
        setBackground(BKG);

        createTextBox(seebarPrompt, 800, 250);
        createChoiceButtons(answerchoices[0], answerchoices[1]);
        choice1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //transition to bad ending we go home sober
                Transition transition = new Transition(gameStage, Prompts.walkfrombar2sleep, new SleepyHome(gameStage));
                gameStage.setScene(transition.getTransitionScene());
                
            }
        });
        choice2.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent actionEvent) {
                //Transition to good ending we get really drunk at a bar
                Transition transition = new Transition(gameStage, Prompts.chillinginbar, new ChillBar(gameStage));
                gameStage.setScene(transition.getTransitionScene());
            }
        });
    }

}
