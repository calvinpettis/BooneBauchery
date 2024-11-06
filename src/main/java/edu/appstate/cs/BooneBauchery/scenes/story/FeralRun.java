package edu.appstate.cs.BooneBauchery.scenes.story;
import edu.appstate.cs.BooneBauchery.tools.Transition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

import static edu.appstate.cs.BooneBauchery.scenes.story.Prompts.*;


public class FeralRun extends GameScene {
    private static final String BKG = "/assets/Backgrounds/demohallway.png";

    private static final String feralRun = Prompts.belk2response1;
    private static final String[] runChoice = Prompts.introchoices;
    public FeralRun(Stage stage) {
        super(stage);
        
        this.prompt = feralRun;
        this.choice = runChoice;
        setupScene();
    }

    @Override
    public void setupScene() {
        setUI();
        setBackground(BKG);
        createTextBox(feralRun, 720, 150);
        createContinueButton(runChoice[1]);
        continueBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                // add belk window here
                Transition transition = new Transition(gameStage, belk2sanford, new SanfordMall(gameStage));
                gameStage.setScene(transition.getTransitionScene());
            }
        });

        
}


    //aux text display method
    public void displayText(String newText) {
        textBox.setText(newText);
    }
}
