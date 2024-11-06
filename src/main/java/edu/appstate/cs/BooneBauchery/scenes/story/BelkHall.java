package edu.appstate.cs.BooneBauchery.scenes.story;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

import static edu.appstate.cs.BooneBauchery.scenes.story.Prompts.*;
import edu.appstate.cs.BooneBauchery.scenes.story.FeralRun;

public class BelkHall extends GameScene{
    private final static String prompt1 = Prompts.belk1;
    private final static String prompt2 = Prompts.belk2;

    private final static String BKG = "/assets/Backgrounds/demohallway.png";

    public BelkHall(Stage stage)
    {
        super(stage);

    }
    @Override
    public void setupScene() {
        setUI();
        setBackground(BKG);
        //TODO: somehow move this so we don't have to do it over and over again
        if (RNG() % 2 == 0) {
            createTextBox(prompt1, 800, 250);
            createChoiceButtons(belk1choice[0], belk1choice[1]);
            choice1.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    //approach
                    BelkApproach approachFigure = new BelkApproach(gameStage);
                    gameStage.setScene(approachFigure);
                }
            });
            choice2.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    //attack
                    BelkAttack attackFigure = new BelkAttack(gameStage);
                    gameStage.setScene(attackFigure);
                }
            });
        } else
        {
            createTextBox(prompt2, 800, 250);
            createChoiceButtons(belk2choice[0], belk2choice[1]);
            choice1.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    FeralRun run = new FeralRun(gameStage);
                    gameStage.setScene(run);
                }
            });
            choice2.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    FeralAttack atk = new FeralAttack(gameStage);
                    gameStage.setScene(atk);
                }
            });
        }
    }
}
