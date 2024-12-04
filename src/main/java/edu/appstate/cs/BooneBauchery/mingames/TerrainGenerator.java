package edu.appstate.cs.BooneBauchery.mingames;

import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import org.w3c.dom.css.Rect;

public class TerrainGenerator {
    private static final int HEIGHT = 720;
    private static final int WIDTH = 1280;
    private static final int tileSize = 20;
    private Stage primaryStage;
    private Rectangle[][][] terrainGrid;

    public TerrainGenerator(Stage stage) {
        this.primaryStage = stage;
        this.terrainGrid = new Rectangle[20][20][20];
    }
    //perlin noise
    private void createNoise()
    {
       for (int i = 0; i < WIDTH/tileSize; i++)
       {
           for (int j = 0; j < HEIGHT/tileSize; j++)
           {
               Rectangle rec = new Rectangle(tileSize, tileSize);
               rec.setTranslateX(WIDTH/tileSize);
               rec.setTranslateY(HEIGHT/tileSize);
           }
       }
    }
}
