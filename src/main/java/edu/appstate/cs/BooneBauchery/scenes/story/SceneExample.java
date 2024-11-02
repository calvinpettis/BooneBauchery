package edu.appstate.cs.BooneBauchery.scenes.story;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;


/**
 * Will rename this Start after I get everything working
 */
public class SceneExample extends GameScene {

    private Label textBox;

    private static final String BKG = "/assets/Backgrounds/demohallway.png";

    private static final String exPrompt = "You head out into the hallway.\n" +
            "Do you head outside or explore Belk Hall's\nComputer Science Department?";
    private static final String[] choice1 = {"Go outside", "Explore"};
    private boolean ans1;
    private boolean ans2;

    public SceneExample(Stage stage) {
        super(stage);
        //Will have to add these two lines until I find a better way
        this.prompt = exPrompt;
        this.choice = choice1;
        setupScene();
    }

 private void createTextBox() {
        textBox = new Label();
        textBox.setTextFill(Color.WHITE);
        textBox.setFont(new Font("Verdana", 20));
        textBox.setAlignment(Pos.TOP_LEFT);
        textBox.setWrapText(true);

        // Style the black text box
        Pane textBoxContainer = new Pane();
        textBoxContainer.setStyle("-fx-background-color: rgba(0, 0, 0, 0.7);");
        double boxWidth = 700;
        double boxHeight = 150; 

        textBoxContainer.setPrefSize(boxWidth, boxHeight);
        textBoxContainer.getChildren().add(textBox);
        
        // Positioning the text box at the top of the screen
        AnchorPane.setTopAnchor(textBoxContainer, 20.0);
        AnchorPane.setLeftAnchor(textBoxContainer, (WIDTH - boxWidth) / 2); // Center it horizontally
        root.getChildren().add(textBoxContainer);
        
        // Set the initial text
        textBox.setText(exPrompt);
    }

    @Override
    public void setupScene() {
        setUI();
        setBackground(BKG);

        createTextBox();
      
    }

    public void displayText(String newText) {
        textBox.setText(newText);
    }
}
