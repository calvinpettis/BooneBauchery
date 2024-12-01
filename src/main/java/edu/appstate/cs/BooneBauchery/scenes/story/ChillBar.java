package edu.appstate.cs.BooneBauchery.scenes.story;
import edu.appstate.cs.BooneBauchery.main.Main;
import edu.appstate.cs.BooneBauchery.tools.Transition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ChillBar extends GameScene {
    
    private final static String BKG = "/assets/Backgrounds/chillbar.png";

    
    private static final String atbar = Prompts.atbar;
    private static final String[] onward = Prompts.travelOnward;

    public ChillBar(Stage stage)
    {
        super(stage);
        this.prompt = atbar;
        this.choice = onward;
        setupScene();
    }

    @Override
    public void setupScene() {
        setUI();
        setBackground(BKG);
        createTextBox(atbar, 700, 150);
        createContinueButton(onward[0]);
        continueBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                // since not a bad ending we just restart main menu
                gameStage.close();
                Main.startloop(gameStage);
        }});
        
    }

    public void displayText(String newText) {
        textBox.setText(newText);
    }
}
