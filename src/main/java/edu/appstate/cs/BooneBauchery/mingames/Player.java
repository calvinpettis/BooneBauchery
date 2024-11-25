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
    //stupid physics
    private double speed;
    private double velocity;
    private final static int gravity = 4;
    double x;
    double y;

    //constants
    private static final int floorHeight = 300;
    private static final int rightLimit = 800;
    private static final int leftLimit = 0;

    //images for character
    private static final String defaultChar = "/assets/Characters/Adventurer2/AdventurerPreview.png";
    public Player(int xPos, int yPos)
    {
        super(new Image(defaultChar));
        this.speed = 5.0;
        this.setFitWidth(100);
        this.setFitHeight(100);
        this.x = xPos;
        this.y = yPos;
        this.setLayoutX(xPos);
        this.setLayoutY(yPos);
        this.velocity = 0;
    }


    public void jump()
    {
        if (this.getTranslateY() >= floorHeight) {
            this.velocity = -25;
        }
    }
    /**
     * Handles jump coordinate changes and timelines.
     */
    public void update()
    {
        //loop for jumping to make it appear like a continuous action
        if (this.getTranslateY() < floorHeight)
        {
                this.velocity += gravity;
        }
        else
        {
           this.velocity = 0;
           this.setTranslateY(floorHeight);
        }
        this.setTranslateY(this.getTranslateY() + velocity);
    }

    public void moveLeft()
    {
        if(this.getX() >= leftLimit) {
            this.setX(this.getX() - speed);
        }
    }

    public void moveRight()
    {
        if (this.getX() <= rightLimit) {
            this.setX(this.getX() + speed);
        }
    }

}
