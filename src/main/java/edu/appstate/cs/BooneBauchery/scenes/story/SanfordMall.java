package edu.appstate.cs.BooneBauchery.scenes.story;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

import static edu.appstate.cs.BooneBauchery.scenes.story.Prompts.*;

public class SanfordMall extends GameScene{

    //sanford mall area leads to (random) ... 
    //      --> jesus man
    //          >> dodge 
    //          >> reason
    //      --> sorority girls
    //          >> flee 
    //          >> defend

    private final static String BKG = "/assets/Backgrounds/campus.png";

    public SanfordMall(Stage stage)
    {
        super(stage);

    }
    @Override
    public void setupScene() {
        setUI();
        setBackground(BKG);
        //TODO: somehow move this so we don't have to do it over and over again
        if (RNG() % 2 == 0) {
            createTextBox(sanford1, 700, 150);
            createChoiceButtons(sanford1choice[0], sanford1choice[1]);
            choice1.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    JesusDodge jesusDodge = new JesusDodge(gameStage);
                    gameStage.setScene(jesusDodge);
                }
            });
            choice2.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    JesusReason jesusReason = new JesusReason(gameStage);
                    gameStage.setScene(jesusReason);
                }
            });
        } else
        {
            createTextBox(sanford2, 800, 250);
            createChoiceButtons(sanford2choice[0], sanford2choice[1]);
            choice1.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    SororityFlee sororityFlee = new SororityFlee(gameStage);
                    gameStage.setScene(sororityFlee);
                }
            });
            choice2.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    SororityDefend defend = new SororityDefend(gameStage);
                    gameStage.setScene(defend);
                }
            });
        }
    }
}
