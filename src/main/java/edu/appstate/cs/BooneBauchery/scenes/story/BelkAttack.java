package edu.appstate.cs.BooneBauchery.scenes.story;
import edu.appstate.cs.BooneBauchery.tools.Transition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class BelkAttack extends GameScene {
    
    // attack proffessor scene
    //      --> examine body (leads to ending)

    private static final String BKG = "/assets/Backgrounds/professor.png";

    private static final String blkAttck = Prompts.belk1response2;
    private static final String[] examine = Prompts.examine;

    public BelkAttack(Stage stage) {
        super(stage);

        this.prompt = blkAttck;
        this.choice = examine;
        setupScene();
    }

    @Override
    public void setupScene() {
        setUI();
        setBackground(BKG);
        createTextBox(blkAttck, 700, 150);
        createContinueButton(examine[0]);
        continueBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                // transition by using the text scroll to canceled
                Transition transition = new Transition(gameStage, Prompts.belkCanceled, new BelkCanceled(gameStage));
                gameStage.setScene(transition.getTransitionScene());
                // OLD way to transition
                //BelkCanceled canceled = new BelkCanceled(gameStage);
                //gameStage.setScene(canceled);
            }
        });
    }

}
