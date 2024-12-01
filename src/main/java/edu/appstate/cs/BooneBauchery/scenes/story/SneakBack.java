package edu.appstate.cs.BooneBauchery.scenes.story;
import static edu.appstate.cs.BooneBauchery.scenes.story.Prompts.sneak2walking;

import edu.appstate.cs.BooneBauchery.tools.Transition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class SneakBack extends GameScene {
    
    // (after feral atk) sneaking out back of building ->
    //      >> travel onward ----> play script to walkingSeeABar

    private static final String BKG = "/assets/Backgrounds/sneakingback.png";

    private static final String sneakPrompt = Prompts.sneaking;
    private static final String[] choices = Prompts.travelOnward;

    public SneakBack(Stage stage) {
        super(stage);

        this.prompt = sneakPrompt;
        this.choice = choices;
        setupScene();
    }

    @Override
    public void setupScene() {
        setUI();
        setBackground(BKG);
        createTextBox(sneakPrompt, 700, 150);
        createContinueButton(choices[0]);
        continueBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Transition transition = new Transition(gameStage, sneak2walking, new Walking2Bar(gameStage));
                gameStage.setScene(transition.getTransitionScene());
            }
        });
    }

    //aux text display method
    public void displayText(String newText) {
        textBox.setText(newText);
    }

}
