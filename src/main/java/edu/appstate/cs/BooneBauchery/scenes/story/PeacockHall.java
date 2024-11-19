package edu.appstate.cs.BooneBauchery.scenes.story;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

import static edu.appstate.cs.BooneBauchery.scenes.story.Prompts.*;

public class PeacockHall extends GameScene{

    // now in business building (random)
    //      --> peacock pencil stabber
    //          >> run to a cop
    //          >> sidestepp attacker
    //      --> invest in app crypto coin??
    //          >> do invest
    //          >> decline offer

    private final static String BKG = "/assets/Backgrounds/peacock.png";

    public PeacockHall(Stage stage)
    {
        super(stage);

    }
    @Override
    public void setupScene() {
        setUI();
        setBackground(BKG);
        //TODO: somehow move this so we don't have to do it over and over again
        if (RNG() % 2 == 0) {
            createTextBox(peacock1, 750, 200);
            createChoiceButtons(peacock1choice[0], peacock1choice[1]);
            choice1.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {

                }
            });
            choice2.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {

                }
            });
        } else
        {
            createTextBox(peacock2, 800, 250);
            createChoiceButtons(peacock2choice[0], peacock2choice[1]);
            choice1.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    PeacockInvest invest = new PeacockInvest(gameStage);
                    gameStage.setScene(invest);
                }
            });
            choice2.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    PeacockDecline decline = new PeacockDecline(gameStage);
                    gameStage.setScene(decline);
                }
            });
        }
    }
}
