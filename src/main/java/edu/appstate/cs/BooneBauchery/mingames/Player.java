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
    public Player(int xPos, int yPos)
    {
        super(new Image(defaultChar));
        this.speed = 5.0;
        this.setFitWidth(50);
        this.setFitHeight(100);
        x = xPos;
        y = yPos;
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
        this.setY(this.getY() + velocity);
        if (this.getY() >= y + 75)
        {
            this.setY(y);
            this.velocity = 0;
        }
        else
        {
           this.velocity += 1;
        }
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
