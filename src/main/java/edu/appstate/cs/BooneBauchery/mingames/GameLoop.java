package edu.appstate.cs.BooneBauchery.mingames;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Random;

/**
 * This handles our 2d platformer loop, refreshing graphics and listening to keys
 * until game over or valhalla
 */
public class GameLoop {

    //constants
    private static final int HEIGHT = 720;
    private static final int WIDTH = 1280;
    private static final double FPS = 60;
    private static final double nsPerFrameDelay = 1000000000 / FPS;
    private static final int NUM_DROPS = 150;
    private static final double DROP_WIDTH = 10;
    private static final double DROP_HEIGHT = 20;

    private Stage primaryStage;
    //booleans
    private boolean moveLeft;
    private boolean moveRight;
    private boolean moveUp;

    private Player player;
    private Scene scene;
    private Random random;
    private ArrayList<Rectangle> raindrops;

    private ImageView layer1, layer2, layer3, layer4, layer5, layer6;

    public GameLoop(Stage stage) {
        this.primaryStage = stage;
    }


    public Scene createScene() {
        Pane root = new Pane();
        random = new Random();
        layer1 = createBackgroundLayer("/assets/Backgrounds/Parallax/11.png", 0);
        layer2 = createBackgroundLayer("/assets/Backgrounds/Parallax/22.png", 0);
        layer3 = createBackgroundLayer("/assets/Backgrounds/Parallax/33.png", 0);
        layer4 = createBackgroundLayer("/assets/Backgrounds/Parallax/44.png", 0);
        layer5 = createBackgroundLayer("/assets/Backgrounds/Parallax/55.png", 0);
        layer6 = createBackgroundLayer("/assets/Backgrounds/Parallax/66.png", 0);
        player = new Player(300, 300);
        scene = new Scene(root, WIDTH, HEIGHT);
        root.getChildren().addAll(layer1, layer2, layer3, layer4, layer5, layer6, player);
        createListeners(scene);
        createRain(root);
        AnimationTimer gameLoop = new AnimationTimer() {
            private long lastUpdate = 0;

            @Override
            public void handle(long now) {
                //handle start of game
                if (lastUpdate == 0) {
                    lastUpdate = now;
                    return;
                }
                //this is our time delta
                long tick = now - lastUpdate;
                //check if tick is equal to our desired mS delay
                if (tick >= nsPerFrameDelay) {
                    if (moveLeft) {
                        player.moveLeft();
                    }
                    if (moveRight) {
                        player.moveRight();
                    }
                    if (moveUp) {
                        player.jump();
                        moveUp = false;
                    }
                    updateParallax();
                    updateRain();
                    player.update();
                    lastUpdate = now;
                }
            }
        };
        gameLoop.start();

        return scene;
    }

    private ImageView createBackgroundLayer(String imagePath, int x) {
        Image image = new Image(imagePath);
        ImageView layer = new ImageView(image);
        layer.setFitHeight(720);
        layer.setFitWidth(5120);
        layer.setPreserveRatio(true);
        layer.setTranslateX(x);
        return layer;
    }

    private void createListeners(Scene scene1) {
        scene1.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case LEFT:
                case A:
                    moveLeft = true;
                    break;
                case RIGHT:
                case D:
                    moveRight = true;
                    break;
                case SPACE:
                case UP:
                case W:
                    moveUp = true;
                    break;
                default:
                    break;
            }
        });
        scene1.setOnKeyReleased(event -> {
            switch (event.getCode()) {
                case LEFT:
                case A:
                    moveLeft = false;
                    player.isRunning = false;
                    player.isIdle = true;
                    break;
                case RIGHT:
                case D:
                    moveRight = false;
                    player.isRunning = false;
                    player.isIdle = true;
                    break;
                default:
                    break;
            }
        });
    }

    private void createRain(Pane root) {
        if (raindrops == null) {
            raindrops = new ArrayList<>();
        }
        for (int i = 0; i < NUM_DROPS; i++) {
            Rectangle rainDrop = new Rectangle(DROP_WIDTH, DROP_HEIGHT);
            rainDrop.setFill(Color.BLUE.deriveColor(0, 1, 1, 0.3));
            rainDrop.setX(player.x + random.nextInt(WIDTH));
            rainDrop.setY(player.y + random.nextInt(HEIGHT));
            raindrops.add(rainDrop);
            rainDrop.setTranslateZ(1);
            root.getChildren().add(rainDrop);
        }
    }

    private void updateParallax() {
        if (moveLeft) {
            layer1.setTranslateX(layer1.getTranslateX() + 2);
            layer2.setTranslateX(layer2.getTranslateX() + 4);
            layer3.setTranslateX(layer3.getTranslateX() + 6);
            layer4.setTranslateX(layer4.getTranslateX() + 8);
            layer5.setTranslateX(layer5.getTranslateX() + 10);
            layer6.setTranslateX(layer6.getTranslateX() + 12);
            loopBackgroundLayer(layer1);
            loopBackgroundLayer(layer2);
            loopBackgroundLayer(layer3);
            loopBackgroundLayer(layer4);
            loopBackgroundLayer(layer5);
            loopBackgroundLayer(layer6);
        }
        if (moveRight) {
            layer1.setTranslateX(layer1.getTranslateX() - 2);
            layer2.setTranslateX(layer2.getTranslateX() - 4);
            layer3.setTranslateX(layer3.getTranslateX() - 6);
            layer4.setTranslateX(layer4.getTranslateX() - 8);
            layer5.setTranslateX(layer5.getTranslateX() - 10);
            layer6.setTranslateX(layer6.getTranslateX() - 12);
            loopBackgroundLayer(layer1);
            loopBackgroundLayer(layer2);
            loopBackgroundLayer(layer3);
            loopBackgroundLayer(layer4);
            loopBackgroundLayer(layer5);
            loopBackgroundLayer(layer6);
        }

    }

    private void loopBackgroundLayer(ImageView layerOne)
    {
        double moveX = layerOne.getTranslateX();
        int i = 0;
        if (moveX <= -layerOne.getFitWidth() + 1280)
        {
            i+= 3840;
            layerOne.setLayoutX(i);
        }
    }

    private void updateRain()
    {
        double moveRain = 0;
        if (moveLeft)
        {
            moveRain = 8;
        }
        else if (moveRight)
        {
            moveRain = -8;
        }
        for (Rectangle drop: raindrops)
        {
            drop.setY(drop.getY() + random.nextInt(3) + 5);
            drop.setX(drop.getX() + moveRain);
            drop.setRotate(-moveRain * 4);

            if(drop.getY() > HEIGHT)
            {
                drop.setY(0);
                drop.setX(random.nextInt(WIDTH));
            }
        }
    }
}