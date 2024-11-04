package edu.appstate.cs.BooneBauchery.scenes.story;
import javafx.stage.Stage;


/**
 * Will rename this Start after I get everything working
 */
public class SceneExample extends GameScene {


    private static final String BKG = "/assets/Backgrounds/demohallway.png";

    private static final String exPrompt = Prompts.belkintro;
    private static final String[] choice1 = {"GO OUTSIDE", "EXPLORE"};
    private boolean ans1;
    private boolean ans2;

    public SceneExample(Stage stage) {
        super(stage);
        //Will have to add these two lines until I find a better way
        this.prompt = exPrompt;
        this.choice = choice1;
        setupScene();
    }


    @Override
    public void setupScene() {
        setUI();
        setBackground(BKG);
        createTextBox(exPrompt);
        createChoiceButtons(choice1[0], choice1[1]);
    }

    public void displayText(String newText) {
        textBox.setText(newText);
    }


}
