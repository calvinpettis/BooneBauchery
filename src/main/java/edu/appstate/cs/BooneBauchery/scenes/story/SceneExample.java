package edu.appstate.cs.BooneBauchery.scenes.story;

import edu.appstate.cs.BooneBauchery.tools.Scroller;
import javafx.stage.Stage;

/**
 * Will rename this Start after I get everything working
 */
public class SceneExample extends GameScene {

    private static final String BKG = "/assets/Backgrounds/bkgwappstate.png";

    private static final String[] exPrompt = {"You head out into the hallway.",
            "Do you head outside or explore Belk Hall?"};
    private boolean ans1;
    private boolean ans2;

    public SceneExample(Stage stage) {
        super(stage);
        setupScene();
    }

    @Override
    public void setupScene() {
        setUI();
        setBackground(BKG);

    }
}
