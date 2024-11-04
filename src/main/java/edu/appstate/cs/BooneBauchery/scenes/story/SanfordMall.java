package edu.appstate.cs.BooneBauchery.scenes.story;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

import static edu.appstate.cs.BooneBauchery.scenes.story.Prompts.*;

public class SanfordMall extends GameScene{
    private final static String prompt1 = sanford1;
    //private final static String prompt1response1 = sanford1response1;
    private final static String prompt1response2 = belk1response2;
    private final static String prompt2 = Prompts.belk2;

    private final static String BKG = "/assets/Backgrounds/demohallway.png";
    private final static String prompt2response1 = belk2response1;
    private final static String prompt2response2 = belk2response2;

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
            createTextBox(prompt1);
            createChoiceButtons(belk1choice[0], belk1choice[1]);
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
            createTextBox(prompt2);
            createChoiceButtons(belk2choice[0], belk2choice[1]);
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
