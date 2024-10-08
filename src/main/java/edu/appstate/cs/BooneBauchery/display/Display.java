package edu.appstate.cs.BooneBauchery.display;
import edu.appstate.cs.BooneBauchery.display.gui.MenuButton;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The Display class. This is the window that pops up when you start the game as well as a manager class for that window.
 */
public class Display {
  //width & height of window
  private static final int HEIGHT = 600;
  private static final int WIDTH = 800;
  private AnchorPane mainDisplay;
  private Scene mainScene;
  private Stage mainStage;

  private final static int MENU_BUTTONS_START_X = 300;
  private final static int MENU_BUTTONS_START_Y = 150;

  //we will use a list to store all of our buttons
  List<MenuButton> menuButtons;

  /**
   * Display constructor. This loads the AnchorPane, which manages where everything is placed.
   * Scenes are loaded onto Stages,
   */
  public Display()
  {
    menuButtons = new ArrayList<>();
    mainDisplay = new AnchorPane();
    mainScene = new Scene(mainDisplay, WIDTH, HEIGHT);
    mainStage = new Stage();
    createBackground();
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

  /**
   * Helper method that adds buttons to the screen.
   * @param button the button to be added
   */
  private void addMenuButton(MenuButton button)
  {
    button.setLayoutX(MENU_BUTTONS_START_X);
    //
    button.setLayoutY(MENU_BUTTONS_START_Y + menuButtons.size() * 100);
    menuButtons.add(button);
    mainDisplay.getChildren().add(button);
  }

  /**
   * Initializes all the buttons.
   */
  private void createButtons()
  {
    createStartButton();
    createScoresButton();
    createHelpButton();
    createCreditsButton();
    createExitButton();
  }

  //Following methods create different buttons for start menu. Will probably move all of this around later.
  private void createStartButton()
  {
    MenuButton startButton = new MenuButton("PLAY");
    addMenuButton(startButton);
  }

  private void createScoresButton()
  {
    MenuButton scoresButton = new MenuButton("SCORES");
    addMenuButton(scoresButton);
  }

  private void createHelpButton()
  {
    MenuButton helpButton = new MenuButton("HELP");
    addMenuButton(helpButton);
  }

  private void createCreditsButton()
  {
    MenuButton creditsButton = new MenuButton("CREDITS");
    addMenuButton(creditsButton);
  }

  private void createExitButton()
  {
    MenuButton exitButton = new MenuButton("EXIT");
    addMenuButton(exitButton);
  }

  /**
   * Adds a background to the display.
   */
  private void createBackground()
  {
    Image background = new Image("/assets/GrassyMtns/Grassy_Mountains_preview.png", 256, 256, false, true);
    BackgroundImage backgroundImage = new BackgroundImage(background, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
    mainDisplay.setBackground(new Background(backgroundImage));
  }










}
