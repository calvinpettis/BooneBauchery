package edu.appstate.cs.BooneBauchery.display;
import edu.appstate.cs.BooneBauchery.display.gui.StartButton;
import javafx.scene.Scene;
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
   * Display constructor. This loads the AnchorPane, which manages where everything is placed.
   * MainScene is the startup screen.
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
    StartButton start = new StartButton("Start");
    //these display's components are added to the list of Children, so call getChildren and then add to add them to display.
    mainDisplay.getChildren().add(start);
  }









}
