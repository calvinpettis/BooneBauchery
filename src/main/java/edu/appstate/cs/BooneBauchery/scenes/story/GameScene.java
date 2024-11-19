package edu.appstate.cs.BooneBauchery.scenes.story;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import edu.appstate.cs.BooneBauchery.display.gui.ChoiceButton;
import edu.appstate.cs.BooneBauchery.display.gui.PauseButton;
import edu.appstate.cs.BooneBauchery.scenes.mainmenu.PauseSubSceneManager;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * This is a template class we can use as a scene generator for making quicker scenes.
 * TODO: finish UI
 */
public abstract class GameScene extends Scene {

    private final static String FONT_PATH = "src/main/resources/assets/Fonts/a-dripping-marker/adrip1.ttf";

    protected Stage gameStage;
    protected AnchorPane root;
    protected static final int HEIGHT = 720;
    protected static final int WIDTH = 1280;
    protected boolean answer1;
    protected boolean answer2;
    protected PauseSubSceneManager pauseSubScene;
    protected PauseSubSceneManager sceneToHide;
    protected String prompt;
    protected String[] choice;
    protected Label textBox;
    protected Scene scene;
    ChoiceButton choice1;
    ChoiceButton choice2;
    ChoiceButton continueBtn;

    public GameScene(Stage stage)
    {
        super(new AnchorPane(), WIDTH, HEIGHT);
        this.gameStage = stage;
        this.root = (AnchorPane) this.getRoot();
        setupScene();
    }

    
    public abstract void setupScene();

    protected void setBackground(String path)
    {
        Image bg = new Image(path);
        BackgroundImage backgroundImage = new BackgroundImage(bg,
                BackgroundRepeat.REPEAT,
                BackgroundRepeat.REPEAT,
                BackgroundPosition.DEFAULT,
                null);
        this.setFill(Color.BLACK);
        root.setBackground(new Background(backgroundImage));
    }

    /**
     * Messy, but you only have to call setUI() for it to load everything
     */
    protected void setUI()
    {
       PauseButton pauseBttn = new PauseButton();
       pauseBttn.setLayoutX(5);
       pauseBttn.setLayoutY(5);

       root.getChildren().add(pauseBttn);
       pauseSubScene = new PauseSubSceneManager(gameStage);
       root.getChildren().add(pauseSubScene);
       pauseBttn.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent actionEvent) {
              showSubScene(pauseSubScene);
           }
       });



    }

    /**
     * Fixes the issue where multiple screens can stack on top of eachother
     * @param subScene the scene to be checked if it needs to be hidden or not
     */
    private void showSubScene(PauseSubSceneManager subScene)
    {
        // sceneToHide is set to null outside of this method
        if (sceneToHide != null && sceneToHide != subScene)
        {
            sceneToHide.moveScene();
        }
        subScene.moveScene();
        if (!subScene.getHidden()) {
            sceneToHide = subScene;
        }
        else
        {
            sceneToHide = null;
        }
    }
    protected void createTextBox(String text, double boxWidth, double boxHeight) {
        textBox = new Label();
        textBox.setTextFill(Color.WHITE);
        textBox.setWrapText(true);
        textBox.setFont(Font.font(FONT_PATH, 20));
        
        textBox.setAlignment(Pos.TOP_LEFT);
        textBox.setWrapText(true);

        // Style the black text box
        Pane textBoxContainer = new Pane();
        textBoxContainer.setStyle("-fx-background-color: rgba(0, 0, 0, 0.7);");

        textBoxContainer.setPrefSize(boxWidth, boxHeight);
        textBoxContainer.getChildren().add(textBox);

        // Positioning the text box at the top of the screen
        AnchorPane.setTopAnchor(textBoxContainer, 20.0);
        AnchorPane.setLeftAnchor(textBoxContainer, (WIDTH - boxWidth) / 2); // Center it horizontally
        root.getChildren().add(textBoxContainer);

        // Set the initial text
        textBox.setText(text);
        }

        protected void createChoiceButtons(String choiceOne, String choiceTwo)
        {
            choice1 = new ChoiceButton(choiceOne);
            choice2 = new ChoiceButton(choiceTwo);
            choice1.setLayoutX(635);
            choice1.setLayoutY(300);
            choice2.setLayoutX(435);
            choice2.setLayoutY(300);

            try {
            choice1.setFont(Font.loadFont(new FileInputStream(FONT_PATH), 22));
            
        } catch (FileNotFoundException e) {
            choice1.setFont(Font.font("Verdana", 22));
        }
        try {
            choice2.setFont(Font.loadFont(new FileInputStream(FONT_PATH), 22));
            
        } catch (FileNotFoundException e) {
            choice2.setFont(Font.font("Verdana", 22));
        }
            root.getChildren().add(choice1);
            root.getChildren().add(choice2);
        }

        protected void createContinueButton(String continueButton)
        {
            continueBtn = new ChoiceButton(continueButton);
            
            continueBtn.setLayoutX(500);
            continueBtn.setLayoutY(300);
            
            try {
            continueBtn.setFont(Font.loadFont(new FileInputStream(FONT_PATH), 22));
            
        } catch (FileNotFoundException e) {
            continueBtn.setFont(Font.font("Verdana", 22));
        }
        
            root.getChildren().add(continueBtn);
        }

        protected int RNG()
        {
            return (int) (Math.random() * 100);
        }

    }
