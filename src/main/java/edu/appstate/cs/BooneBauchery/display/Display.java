package edu.appstate.cs.BooneBauchery.display;
import edu.appstate.cs.BooneBauchery.display.gui.MenuButton;
import edu.appstate.cs.BooneBauchery.scenes.MenuSubSceneManager;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;

/**
 * The Display class. This is the window that pops up when you start the game as well as a manager class for that window.
 * Lots will get moved around once I figure out what's going on
 */
public class Display {
  //width & height of window (did 720p bc no monitor I know of is less than 1080, should be no scaling issues)
  private static final int HEIGHT = 720;
  private static final int WIDTH = 1280;
  private AnchorPane mainDisplay;
  private Scene mainScene;
  private Stage mainStage;

  private final static int MENU_BUTTONS_START_X = 540;
  private final static int MENU_BUTTONS_START_Y = 240;

  private MenuSubSceneManager creditSubScene;

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
    createCreditSubScene();
    createBackground();
    createButtons();
    createLogo();


  }

  public void createCreditSubScene()
  {
    creditSubScene = new MenuSubSceneManager();
    mainDisplay.getChildren().add(creditSubScene);
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

    creditsButton.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent actionEvent) {
        creditSubScene.moveScene();
      }
    });
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
    //
    Image background = new Image("/assets/Backgrounds/backgroundmtn.png", true);
    BackgroundImage backgroundImage = new BackgroundImage(background, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
    mainDisplay.setBackground(new Background(backgroundImage));
  }

  /**
   * Adds a logo to the display.
   */
  private void createLogo()
  {
    ImageView logo = new ImageView("/assets/Logo/logo3big.png");
    logo.setLayoutX(170);
    logo.setLayoutY(0);

    logo.setOnMouseEntered(new EventHandler<MouseEvent>() {
      @Override
      public void handle(MouseEvent mouseEvent) {
        logo.setEffect(new DropShadow());
      }
    });

    logo.setOnMouseExited(new EventHandler<MouseEvent>() {
      @Override
      public void handle(MouseEvent mouseEvent) {
        logo.setEffect(null);
      }
    });
    mainDisplay.getChildren().add(logo);
  }
}
