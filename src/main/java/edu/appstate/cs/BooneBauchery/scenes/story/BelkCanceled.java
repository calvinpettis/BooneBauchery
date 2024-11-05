package edu.appstate.cs.BooneBauchery.scenes.story;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;


public class BelkCanceled extends GameScene{
    
    private static final String BKG = "/assets/Backgrounds/demohallway.png";

    private static final String cancelPrompt = Prompts.belkCanceled;
    private static final String[] examine = Prompts.examine;

    public BelkCanceled(Stage stage)
    {
        super(stage);
        this.prompt = cancelPrompt;
        this.choice = examine;
    }

    @Override
    public void setupScene() {
        setUI();
        setBackground(BKG);
        createTextBox(cancelPrompt, 700, 150);
        createContinueButton(examine[0]);
        continueBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //canceled ending text scroll here
            }
        });
        
    }

    public void displayText(String newText) {
        textBox.setText(newText);
    }
}
