package edu.appstate.cs.BooneBauchery.mingames;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * This class handles the player model's image and animations.
 * The actual image is set in gameLoop, but x and y handled here. Deal with it!!!!
 *
 */
public class Player extends ImageView {
    //stupid physics
    private double speed;
    private double velocity;
    private final static double gravity = 3.5;
    double x;
    double y;
    private long tick;

    //constants
    private static final int floorHeight = 250;
    private static final int waterHeight = 400;
    private static final int rightLimit = 150;
    private static final int leftLimit = 0;

    //images for character

    //booleans 4 anims
    private boolean isJumping;
    private boolean isFalling;
    public boolean isIdle;
    public boolean isRunningR;
    private boolean isRunningL;

    private static final String defaultChar = "/assets/Characters/Adventurer2/Sprites/adventurer-idle-00.png";
    String[] jumpAnims = {
        "/assets/Characters/Adventurer2/Sprites/adventurer-jump-00.png",
        "/assets/Characters/Adventurer2/Sprites/adventurer-jump-01.png",
        "/assets/Characters/Adventurer2/Sprites/adventurer-jump-02.png",
        "/assets/Characters/Adventurer2/Sprites/adventurer-jump-03.png"};

    String[] idleAnims = {
        "/assets/Characters/Adventurer2/Sprites/adventurer-idle-00.png",
        "/assets/Characters/Adventurer2/Sprites/adventurer-idle-01.png"
};

   String[] fallAnim= {
       "/assets/Characters/Adventurer2/adventurer-fall-00.png",
       "/assets/Characters/Adventurer2/adventurer-fall-01.png"};

   String[] runAnim = {
        "/assets/Characters/Adventurer2/Sprites/adventurer-run-00.png",
        "/assets/Characters/Adventurer2/Sprites/adventurer-run-01.png",
        "/assets/Characters/Adventurer2/Sprites/adventurer-run-02.png",
        "/assets/Characters/Adventurer2/Sprites/adventurer-run-03.png",
        "/assets/Characters/Adventurer2/Sprites/adventurer-run-04.png",
        "/assets/Characters/Adventurer2/Sprites/adventurer-run-05.png"};

   String[] attackAnim = {
           "/assets/Characters/Adventurer2/Sprites/adventurer-attack1-00.png",
           "/assets/Characters/Adventurer2/Sprites/adventurer-attack1-01.png",
           "/assets/Characters/Adventurer2/Sprites/adventurer-attack1-02.png",
           "/assets/Characters/Adventurer2/Sprites/adventurer-attack1-03.png",
           "/assets/Characters/Adventurer2/Sprites/adventurer-attack1-04.png"
   };
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
           this.velocity = -35;
           isIdle = false;
           isRunningR = false;
       }
   }
    /**
     * Handles jump coordinate changes and timelines.
     */
    public void update()
    {
        //loop for jumping to make it appear like a continuous action
        if (this.getTranslateY() <= floorHeight)
        {
            if(this.getTranslateY() != floorHeight) {
                this.velocity += gravity;
                isRunningR = false;
                isIdle = false;
                isJumping = true;
            }
        }
        else
        {
            isJumping = false;
            isIdle = true;
            this.velocity = 0;
            this.setTranslateY(floorHeight);

        }
        this.setTranslateY(this.getTranslateY() + velocity);
        if (isJumping) {
            animateJump();
        }
        else
        {
            if (isRunningR)
            {
                animateRightRun();
            }
            else {
                animateIdle();
            }
        }
    }

    public void moveLeft()
    {
        if(this.getX() >= leftLimit) {
            this.setX(this.getX() - speed);
        }
        isIdle = false;
    }

    public void moveRight()
    {
        if (this.getX() <= rightLimit) {
            this.setX(this.getX() + speed);

        }
        if (!isJumping) {
            isRunningR = true;
        }
        isIdle = false;
        animateRightRun();

    }

    public void animateJump()
    {
        if (isJumping)
        {
            tick++;
            if (tick > 24)
            {
                tick = 0;
            }
            switch((int) tick)
            {
                case 6:
                    this.setImage(new Image(jumpAnims[0]));
                    break;
                case 12:
                    this.setImage(new Image(jumpAnims[1]));
                    break;
                case 18:
                    this.setImage(new Image(jumpAnims[2]));
                    break;
                case 24:
                    this.setImage(new Image(jumpAnims[3]));
                    break;
            }
        }
    }

    public void animateIdle()
    {
        if (isIdle)
        {
            tick++;
            if (tick > 30)
            {
                tick = 0;
            }
            switch((int) tick)
            {
                case 15:
                    this.setImage(new Image(idleAnims[0]));
                    break;
                case 30:
                    this.setImage(new Image(idleAnims[1]));
                    break;
            }
        }
    }

    public void animateLanding()
    {

    }

    public void animateRightRun()
    {
        if (isRunningR)
        {
            tick++;
            if (tick > 24)
            {
                tick = 0;
            }
            switch((int) tick)
            {
                case 4:
                    this.setImage(new Image(runAnim[0]));
                    break;
                case 8:
                    this.setImage(new Image(runAnim[1]));
                    break;
                case 12:
                    this.setImage(new Image(runAnim[2]));
                    break;
                case 16:
                    this.setImage(new Image(runAnim[3]));
                    break;
                case 20:
                    this.setImage(new Image(runAnim[4]));
                    break;
                case 24:
                    this.setImage(new Image(runAnim[5]));
                    break;
            }
        }
    }

    public void animateAttack()
    {
        if (isJumping)
        {
            tick++;
            if (tick > 32)
            {
                tick = 0;
            }
            switch((int) tick)
            {
                case 8:
                    this.setImage(new Image(attackAnim[0]));
                    break;
                case 16:
                    this.setImage(new Image(attackAnim[1]));
                    break;
                case 24:
                    this.setImage(new Image(attackAnim[2]));
                    break;
                case 32:
                    this.setImage(new Image(attackAnim[3]));
                    break;
            }
        }
    }
}