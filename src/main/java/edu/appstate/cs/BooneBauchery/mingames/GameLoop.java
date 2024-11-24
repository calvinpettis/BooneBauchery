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

    private ImageView layer1, layer2, layer3, layer4, layer5, layer6;

    public GameLoop(Stage stage) {
        this.primaryStage = stage;
    }


    public Scene createScene() {
        Pane root = new Pane();
        layer1 = createBackgroundLayer("/assets/Backgrounds/Parallax/8.png");
        layer2 = createBackgroundLayer("/assets/Backgrounds/Parallax/7.png");
        layer3 = createBackgroundLayer("/assets/Backgrounds/Parallax/6.png");
        layer4 = createBackgroundLayer("/assets/Backgrounds/Parallax/5.png");
        layer5 = createBackgroundLayer("/assets/Backgrounds/Parallax/4.png");
        layer6 = createBackgroundLayer("/assets/Backgrounds/Parallax/3.png");
        player = new Player(300, 300);
        scene = new Scene(root, WIDTH, HEIGHT);
        createListeners(scene);

        AnimationTimer gameLoop = new AnimationTimer() {
            @Override
            public void handle(long l) {
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
            }
        };
        gameLoop.start();
        root.getChildren().addAll(layer1, layer2, layer3, layer4, layer5, layer6, player);
        return scene;
    }

    private ImageView createBackgroundLayer(String imagePath) {
        Image image = new Image(imagePath);
        ImageView layer = new ImageView(image);
        layer.setFitHeight(720);
        layer.setFitWidth(1280);
        layer.setPreserveRatio(true);
        layer.setTranslateX(0);
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
            layer1.setTranslateX(layer1.getTranslateX() + 0.05);
            layer2.setTranslateX(layer2.getTranslateX() + 0.1);
            layer3.setTranslateX(layer3.getTranslateX() + 0.15);
            layer4.setTranslateX(layer4.getTranslateX() + 0.2);
            layer5.setTranslateX(layer5.getTranslateX() + 0.25);
            layer6.setTranslateX(layer6.getTranslateX() + 0.3);
        }
        if (moveRight) {
            layer1.setTranslateX(layer1.getTranslateX() - 0.05);
            layer2.setTranslateX(layer2.getTranslateX() - 0.1);
            layer3.setTranslateX(layer3.getTranslateX() - 0.15);
            layer4.setTranslateX(layer4.getTranslateX() - 0.2);
            layer5.setTranslateX(layer5.getTranslateX() - 0.25);
            layer6.setTranslateX(layer6.getTranslateX() - 0.30);
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