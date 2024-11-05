package edu.appstate.cs.BooneBauchery.scenes.story;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

import static edu.appstate.cs.BooneBauchery.scenes.story.Prompts.*;

public class SanfordMall extends GameScene{


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
            createTextBox(sanford1, 800, 250);
            createChoiceButtons(sanford1choice[0], sanford1choice[1]);
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
            createTextBox(sanford2, 800, 250);
            createChoiceButtons(sanford2choice[0], sanford2choice[1]);
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
        }
    }
}
