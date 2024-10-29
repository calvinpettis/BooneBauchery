package edu.appstate.cs.BooneBauchery.display;
import edu.appstate.cs.BooneBauchery.display.gui.InfoLabel;
import edu.appstate.cs.BooneBauchery.display.gui.MenuButton;
import edu.appstate.cs.BooneBauchery.scenes.mainmenu.CHARACTERS;
import edu.appstate.cs.BooneBauchery.scenes.mainmenu.MenuSubSceneManager;
import edu.appstate.cs.BooneBauchery.scenes.story.Intro;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;

/**
 * The Display class. This is the window that pops up when you start the game as well as a manager class for that window.
 * TODO: Move code around to be more modular once I figure out what's going on
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
  private MenuSubSceneManager helpSubScene;
  private MenuSubSceneManager scoreSubScene;

  //Fixes the issue where multiple screens can stack on top of eachother
  private MenuSubSceneManager sceneToHide;


  //we will use a list to store all of our buttons
  List<MenuButton> menuButtons;

  public final static String FONT_PATH = "src/main/resources/assets/Fonts/blood-crow/bloodcrow.ttf";
  /**
   * Display constructor.
   * Scenes are loaded onto Stages.
   * AnchorPane is just a way to position elements by X and Y. You can also do StackPane to create layers that stack on top of eachother.
   */
  public Display()
  {
    menuButtons = new ArrayList<>();
    mainDisplay = new AnchorPane();
    mainScene = new Scene(mainDisplay, WIDTH, HEIGHT);
    mainStage = new Stage();
    createSubScenes();
    createBackground();
    createButtons();
    createLogo();
  }

  /**
   * Make all the subscenes for when you press the different main menu buttons.
   */
  public void createSubScenes()
  {
    creditSubScene = new MenuSubSceneManager();
    mainDisplay.getChildren().add(creditSubScene);
    helpSubScene = new MenuSubSceneManager();
    mainDisplay.getChildren().add(helpSubScene);
    scoreSubScene = new MenuSubSceneManager();
    mainDisplay.getChildren().add(scoreSubScene);
  }

  /**
   * Fixes the issue where multiple screens can stack on top of eachother
   * @param subScene the scene to be checked if it needs to be hidden or not
   */
  private void showSubScene(MenuSubSceneManager subScene)
  {
    // sceneToHide is set to null outside of this method
    if (sceneToHide != null)
    {
      sceneToHide.moveScene();
    }
    subScene.moveScene();
    sceneToHide = subScene;
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
    createExtrasButton();
    createCreditsButton();
    createExitButton();
  }

  //Following methods create different buttons for start menu. Will probably move all of this around later.
  private void createStartButton()
  {
    MenuButton startButton = new MenuButton("PLAY");
    addMenuButton(startButton);
    startButton.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent actionEvent) {
       Intro intro = new Intro(mainStage);
       mainStage.setScene(intro.getIntroScene());
      }
    });
  }

  private void createScoresButton()
  {
    MenuButton scoresButton = new MenuButton("SCORES");
    addMenuButton(scoresButton);
    scoresButton.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent actionEvent) {
       showSubScene(scoreSubScene);
      }
    });
  }

  private void createExtrasButton()
  {
    MenuButton extraButton = new MenuButton("EXTRAS");
    addMenuButton(extraButton);
    extraButton.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent actionEvent) {
        showSubScene(helpSubScene);
      }
    });
  }

  private void createCreditsButton()
  {
    MenuButton creditsButton = new MenuButton("CREDITS");
    addMenuButton(creditsButton);

    creditsButton.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent actionEvent) {
        showSubScene(creditSubScene);
        
      }
    });
  }

 private void createCreditsSubScene() {
    // Assuming creditSubScene is a MenuSubSceneManager instance
    // Create a VBox to hold the credits content
    VBox creditsLayout = new VBox();
    creditsLayout.setLayoutX(20);
    creditsLayout.setLayoutY(10);
    creditsLayout.setSpacing(10);

    // Add some credits text
    Label creditsTitle = new Label("Game Credits");
    creditsTitle.setStyle("-fx-font-weight: bold;");
    creditsTitle.setFont(new Font(FONT_PATH, 23));
    
    Label developerLabel = new Label("Developed by:\n " +
            "-> Calvin Pettis\n " +
            "-> Hunter Brickers\n " +
            "-> (ENTER NAME)\n\n");

    //(UPDATE WITH RELEVANT INFO)
    Label designerLabel = new Label("Art by: \n" +
            "Cal \n" +
            "AI \n" +
            "and asset devs\n");
    //For some reason Tested is cut off from the credits panel
    //So I have extra spaces in order to be 
    Label testerLabel = new Label("     Tested by: We don't test");
    //Label creditsBody = new Label("Lorem ipsum dolor sit amet, consectetur adipiscing elit.\n Praesent mattis vestibulum odio,\n vitae placerat lectus euismod ac.\n Nulla sed pulvinar lorem, eu dictum ligula.\n Integer ac ante erat.\n Nunc eros dolor, malesuada tempus lectus sed,\n ullamcorper eleifend urna.\n ");
    
    // Ensure the VBox fills the SubScene and children don't get cut off
    creditsLayout.setPrefSize(300, 300);  // Set preferred size (adjust as needed)
    
    // Add the labels to the layout
    creditsLayout.getChildren().addAll(creditsTitle, developerLabel, designerLabel, testerLabel);

    // Add the credits layout to the subscene (assuming creditSubScene is a Pane)
    creditSubScene.getPane().getChildren().add(creditsLayout);
}

  private void createExitButton()
  {
    MenuButton exitButton = new MenuButton("EXIT");
    addMenuButton(exitButton);

     // Set up the subscene with credits text
     createCreditsSubScene();

    exitButton.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent actionEvent) {
        mainStage.close();
      }
    });
  }

  /**
   * Adds a background to the display.
   */
  private void createBackground()
  {
    //
    Image background = new Image("/assets/Backgrounds/bkgwappstate.png", true);
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
    logo.setLayoutY(-5);

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

  public AnchorPane getPane()
  {
    return (AnchorPane) mainDisplay;
  }

}
