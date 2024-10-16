package edu.appstate.cs.BooneBauchery.scenes.story;

import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Displays after you click the start button.
 * TODO: add black background with scrolling text for intro sequence
 */
public class Intro {
    private Scene introScene;
    private Stage introStage;
    private static final int HEIGHT = 600;
    private static final int WIDTH = 800;

    private static final String introText = "In the town of Boone, North Carolina..";
    private static final String introText2 = "It is 3:00PM the Friday before Spring break, and you just left your Software Engineering class to finish up the week.";
    private static final String introText3 = "It's time to party... you just have to make it out of town alive first!";

    public Intro()
    {
       // Scene intro = new Scene(mainDisplay, WIDTH, HEIGHT);
    }

    public Scene getIntroScene()
    {
        return introScene;
    }

    public Stage getIntroStage(){
        return introStage;
    }

    /**
     * Should print the string in a scrolling fashion.
     * @param sentence the String to be printed
     */
    public void stringScroll(String sentence)
    {
        int msdelay = 100;
        for (int i = 0; i < sentence.length(); i++)
        {
            char c = sentence.charAt(i);
            System.out.print(c);
            try
            {
                Thread.sleep(msdelay);
            }
            catch(InterruptedException e)
            {
                System.out.println("Error!");
            }
        }
    }

}
