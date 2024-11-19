package edu.appstate.cs.BooneBauchery.scenes.story;
import static edu.appstate.cs.BooneBauchery.scenes.story.Prompts.gameOver;

import edu.appstate.cs.BooneBauchery.main.Main;
//import edu.appstate.cs.BooneBauchery.tools.Transition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
//import edu.appstate.cs.BooneBauchery.main.Main;

public class OneMilBeers extends GameScene {
    //ONE MILL BEERS ENDING         drink with friend
    // change this path to sunset sadness walk off pixelated image
    private static final String BKG = "/assets/Backgrounds/onemillbeers.png";

    private static final String cancelPrompt = Prompts.onemil;
    private static final String[] onward = Prompts.travelOnward;

    public OneMilBeers(Stage stage)
    {
        super(stage);
        this.prompt = cancelPrompt;
        this.choice = onward;
    }

    @Override
    public void setupScene() {
        setUI();
        setBackground(BKG);


        createTextBox(cancelPrompt, 700, 150);
        createContinueButton(onward[0]);
        continueBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //new : go to game over screen for game over art and then get back to main menu
                //GameOver gameover = new GameOver(gameStage);
                //gameStage.setScene(gameover);

                // below approach OLD: to ending the game loop and getting back to main menu.
                gameStage.close();
                Main.startloop(gameStage);
        }});
        
    }

    public void displayText(String newText) {
        textBox.setText(newText);
    }
}
