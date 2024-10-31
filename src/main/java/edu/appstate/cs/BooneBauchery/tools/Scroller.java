package edu.appstate.cs.BooneBauchery.tools;

import edu.appstate.cs.BooneBauchery.scenes.story.Start;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.util.Duration;

/**
 * Tool to scroll text for prompts.
 */
public class Scroller extends Label {
    private int lineindex = 0;
    private int charindex = 0;
    private StringBuilder sb = new StringBuilder();
    private Label introLabel;

    public Scroller(String[] script, String FONT_PATH)
    {
        startStringScroll(script);

    }
    public void startStringScroll(String[] introScript)
    {
        //the contents inside the timeline will happen every 0.07 seconds. Adjust for faster or slower
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.07), e -> {
            //if we are not through the entire array of the script
            if (lineindex < introScript.length)
            {
                //if we are not all the way through the string
                if (charindex < introScript[lineindex].length())
                {
                    sb.append(introScript[lineindex].charAt(charindex));
                    //set text to what has already been displayed and add the new char
                    introLabel.setText(sb.toString());
                    charindex++;
                }
                else {
                    //else we are on a new line, reset char index, increment line coun
                    lineindex++;
                    charindex = 0;
                    sb.delete(0, sb.length());
                    sb.append("\n");
                    introLabel.setText(sb.toString());
                }

            }
            else {
                return;
            }
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }
}
