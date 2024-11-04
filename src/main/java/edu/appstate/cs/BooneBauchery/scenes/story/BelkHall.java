package edu.appstate.cs.BooneBauchery.scenes.story;

import javafx.stage.Stage;

public class BelkHall extends GameScene{
    private final static String prompt1 = Prompts.belk1;
    private final static String prompt2 = Prompts.belk2;
    private final static String BKG = "/assets/Backgrounds/campus.jpg";

    public BelkHall(Stage stage)
    {
        super(stage);

    }
    @Override
    public void setupScene() {
        setUI();
        setBackground(BKG);

    }
}
