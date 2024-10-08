package edu.appstate.cs.BooneBauchery.display;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * The Display class. This is the window that pops up when you start the game as well as a manager class for that window.
 */
public class Display {
  private static final int HEIGHT = 600;
  private static final int WIDTH = 800;
  private AnchorPane mainDisplay;
  private Scene mainScene;
  private Stage mainStage;


  /**
   * Display constructor. This loads the
   */
  public Display()
  {
    mainDisplay = new AnchorPane();
    mainScene = new Scene(mainDisplay, WIDTH, HEIGHT);
    mainStage = new Stage();
    createButtons();
  }

  public Stage getMainStage()
  {
    return mainStage;
  }

  public Scene getMainScene()
  {
    return mainScene;
  }


  private void createButtons()
  {
    Button button = new Button();
    mainDisplay.getChildren().add(button);

    button.setOnMouseClicked(new EventHandler<MouseEvent>() {
      @Override
      public void handle(MouseEvent mouseEvent) {
        System.out.println("Hello, World! I clicked a button!");
      }
    });

  }









}
