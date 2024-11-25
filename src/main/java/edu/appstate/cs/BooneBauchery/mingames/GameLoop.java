package edu.appstate.cs.BooneBauchery.mingames;

import edu.appstate.cs.BooneBauchery.scenes.story.PeacockDecline;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * This handles our 2d platformer loop, refreshing graphics and listening to keys
 * until game over or valhalla
 */
public class GameLoop {

    private static final int HEIGHT = 720;
    private static final int WIDTH = 1280;
    private Stage primaryStage;
    private boolean moveLeft;
    private boolean moveRight;
    private boolean moveUp;
    private Player player;
    private Scene scene;
    private static final double FPS = 60;
    private static final double nanoSecPerUpdate = 1000000000 / FPS;


    private ImageView layer1, layer2, layer3, layer4, layer5, layer6,
        layer11, layer22, layer33, layer44, layer55, layer66;

    public GameLoop(Stage stage) {
        this.primaryStage = stage;
    }


    public Scene createScene() {
        Pane root = new Pane();
        layer1 = createBackgroundLayer("/assets/Backgrounds/Parallax/8.png", 0);
        layer2 = createBackgroundLayer("/assets/Backgrounds/Parallax/7.png", 0);
        layer3 = createBackgroundLayer("/assets/Backgrounds/Parallax/6.png", 0);
        layer4 = createBackgroundLayer("/assets/Backgrounds/Parallax/5.png", 0);
        layer5 = createBackgroundLayer("/assets/Backgrounds/Parallax/4.png", 0);
        layer6 = createBackgroundLayer("/assets/Backgrounds/Parallax/3.png", 0);
        //this is a stupid hack in order to loop animations
        layer11 = createBackgroundLayer("/assets/Backgrounds/Parallax/8.png", 1280);
        layer22 = createBackgroundLayer("/assets/Backgrounds/Parallax/7.png", 1280);
        layer33 = createBackgroundLayer("/assets/Backgrounds/Parallax/6.png", 1280);
        layer44 = createBackgroundLayer("/assets/Backgrounds/Parallax/5.png", 1280);
        layer55 = createBackgroundLayer("/assets/Backgrounds/Parallax/4.png", 1280);
        layer66 = createBackgroundLayer("/assets/Backgrounds/Parallax/3.png", 1280);
        player = new Player(300, 300);
        scene = new Scene(root, WIDTH, HEIGHT);
        createListeners(scene);

        AnimationTimer gameLoop = new AnimationTimer() {
            private long lastUpdate = 0;
            @Override
            public void handle(long now) {
                if (lastUpdate == 0) {
                    lastUpdate = now;
                    return;
                }
                long deltaTime = now - lastUpdate;
                if (deltaTime >= nanoSecPerUpdate) {
                    if (moveLeft) {
                        player.moveLeft();
                    }
                    if (moveRight) {
                        player.moveRight();
                    }
                    if (moveUp) {
                        player.jump();
                    }
                    updateParallax();
                    lastUpdate = now;
                }
            }
        };
        gameLoop.start();
        root.getChildren().addAll(layer1, layer2, layer3, layer4, layer5, layer6,
                                  layer11, layer22, layer33, layer44, layer55, layer66, player);
        return scene;
    }

    private ImageView createBackgroundLayer(String imagePath, int x) {
        Image image = new Image(imagePath);
        ImageView layer = new ImageView(image);
        layer.setFitHeight(720);
        layer.setFitWidth(1280);
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
                    break;
                case RIGHT:
                case D:
                    moveRight = false;
                    break;
                case SPACE:
                    moveUp = false;
                    break;
                default:
                    break;
            }
        });
    }

    private void updateParallax() {
        if (moveLeft) {
            layer1.setTranslateX(layer1.getTranslateX() + 2);
            layer2.setTranslateX(layer2.getTranslateX() + 4);
            layer3.setTranslateX(layer3.getTranslateX() + 6);
            layer4.setTranslateX(layer4.getTranslateX() + 8);
            layer5.setTranslateX(layer5.getTranslateX() + 10);
            layer6.setTranslateX(layer6.getTranslateX() + 12);
        }
        if (moveRight) {
            layer1.setTranslateX(layer1.getTranslateX() - 2);
            layer2.setTranslateX(layer2.getTranslateX() - 4);
            layer3.setTranslateX(layer3.getTranslateX() - 6);
            layer4.setTranslateX(layer4.getTranslateX() - 8);
            layer5.setTranslateX(layer5.getTranslateX() - 10);
            layer6.setTranslateX(layer6.getTranslateX() - 12);
        }
//        if (moveUp) {
//            layer1.setTranslateY(layer1.getTranslateY() + 2);
//            layer2.setTranslateY(layer2.getTranslateY() + 4);
//            layer3.setTranslateY(layer3.getTranslateY() + 8);
//            layer4.setTranslateY(layer4.getTranslateY() + 10);
//            layer5.setTranslateY(layer5.getTranslateY() + 12);
//            layer6.setTranslateY(layer6.getTranslateY() + 14);
//        }
    }
}