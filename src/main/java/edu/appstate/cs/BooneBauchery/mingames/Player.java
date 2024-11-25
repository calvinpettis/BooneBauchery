package edu.appstate.cs.BooneBauchery.mingames;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 * This class handles the player model's image and animations.
 * The actual image is set in gameLoop, but x and y handled here. Deal with it!!!!
 *
 */
public class Player extends ImageView {
    private double speed;
    private double velocity;
    double x;
    double y;
    private static final String defaultChar = "/assets/Characters/Adventurer2/AdventurerPreview.png";
    private boolean jump;
    public Player(int xPos, int yPos)
    {
        super(new Image(defaultChar));
        this.speed = 5.0;
        this.setFitWidth(100);
        this.setFitHeight(100);
        this.x = xPos;
        this.y = yPos;
        this.setLayoutX(x);
        this.setLayoutY(y);
    }


    public void jump()
    {
        this.velocity = -15;
    }
    /**
     * Handles jump coordinate changes and timelines.
     */
    public void update()
    {
        //loop for jumping to make it appear like a continuous action
        for (int i = 0; i < 8; i++) {
            this.setY(this.getY() + velocity);
        }
        if (this.getY() >= y + 75)
        {
            this.setY(y);
            this.velocity -= 4;
        }
        else
        {
           this.velocity += 4;
        }
    }

    public void fall()
    {

    }


    public void moveLeft()
    {
       this.setX(this.getX() + speed);
    }

    public void moveRight()
    {
        this.setY(this.getY() + speed);
    }

}
