package edu.appstate.cs.BooneBauchery.display;

import edu.appstate.cs.BooneBauchery.display.gui.MenuButton;
import edu.appstate.cs.BooneBauchery.mingames.GameLoop;
import edu.appstate.cs.BooneBauchery.scenes.mainmenu.MenuSubSceneManager;
import edu.appstate.cs.BooneBauchery.scenes.story.Intro;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
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
  private MenuSubSceneManager settingSubScene;

  //Fixes the issue where multiple screens can stack on top of eachother
  private MenuSubSceneManager sceneToHide;


  //we will use a list to store all of our buttons
  List<MenuButton> menuButtons;
  private Timeline backgroundAnim;
  private ImageView bkgImg;
  private boolean animRunning = true;
  private double speed1 = 0.25, speed2 = 0.5, speed3 = 0.75, speed4 = 1;
  ImageView bkgg1, bkgg2, bkgg3, bkgg4;

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
    createBackground();
    mainDisplay.getChildren().addAll(bkgg1, bkgg2, bkgg3, bkgg4);
    createSubScenes();
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
    settingSubScene = new MenuSubSceneManager();
    mainDisplay.getChildren().add(settingSubScene);
  }

  /**
   * Fixes the issue where multiple screens can stack on top of eachother
   * @param subScene the scene to be checked if it needs to be hidden or not
   */
  private void showSubScene(MenuSubSceneManager subScene)
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
    createSettingsButton();
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

  private void createSettingsButton()
  {
    MenuButton settingsButton = new MenuButton("SETTINGS");
    addMenuButton(settingsButton);
    settingsButton.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent actionEvent) {
       showSubScene(settingSubScene);
      }
    });
  }

  private void createExtrasButton()
  {
    MenuButton extraButton = new MenuButton("MINIGAMES");
    addMenuButton(extraButton);
    extraButton.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent actionEvent) {
        showSubScene(helpSubScene);
      }
    });
    VBox extrasPanel = new VBox();
    extrasPanel.setLayoutX(70);
    extrasPanel.setLayoutY(30);
    extrasPanel.setSpacing(10);
    extrasPanel.setPrefSize(300, 300);
    MenuButton platformerButton = new MenuButton("PLATFORMER");
    platformerButton.setLayoutY(20);
    platformerButton.setLayoutX(20);
    platformerButton.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent actionEvent) {
        GameLoop gameLoop = new GameLoop(mainStage);
        mainStage.setScene(gameLoop.createScene());
      }
    });
    extrasPanel.getChildren().add(platformerButton);
    helpSubScene.getPane().getChildren().add(extrasPanel);

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
    creditsLayout.setLayoutX(40);
    creditsLayout.setLayoutY(20);
    creditsLayout.setSpacing(10);

    // Add some credits text
    Label creditsTitle = new Label("Game Credits");
    creditsTitle.setStyle("-fx-font-weight: bold;");
    creditsTitle.setFont(new Font(FONT_PATH, 22));
    
    Label developerLabel = new Label("Developed by:\n " +
            "-> Calvin Pettis\n " +
            "-> Hunter Brickers\n ");

    //(UPDATE WITH RELEVANT INFO)
    Label designerLabel = new Label("Art by: \n" +
            "-> Calvin Pettis \n" +
            "-> Hunter Brickers \n" +
            "\n-> Photo generative AI (chatGPT)");
    //For some reason Tested is cut off from the credits panel
    //So I have extra spaces in order to be 
    Label testerLabel = new Label("   Tested by: OURSELVES.. oldschool style");
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
    Image bkg1 = new Image("/assets/Backgrounds/MainMenu/1.png", true);
    Image bkg2 = new Image("/assets/Backgrounds/MainMenu/2.png", true);
    Image bkg3 = new Image("/assets/Backgrounds/MainMenu/3.png", true);
    Image bkg4 = new Image("/assets/Backgrounds/MainMenu/4.png", true);
    bkgg1 = new ImageView(bkg1);
    bkgg2 = new ImageView(bkg2);
    bkgg3 = new ImageView(bkg3);
    bkgg4 = new ImageView(bkg4);
    bkgg1.setFitWidth(5120);
    bkgg2.setFitWidth(5120);
    bkgg3.setFitWidth(5120);
    bkgg4.setFitWidth(5120);
    backgroundAnim = new Timeline(
            new KeyFrame(Duration.millis(30), e -> updateBkg())
    );
    backgroundAnim.setCycleCount(Timeline.INDEFINITE);
    backgroundAnim.play();
  }

  private void updateBkg()
  {
    moveBkg(bkgg1, speed1);
    moveBkg(bkgg2, speed2);
    moveBkg(bkgg3, speed3);
    moveBkg(bkgg4, speed4);
  }

  private void moveBkg(ImageView bkg, double speed)
  {
    double x = bkg.getLayoutX();
    x -= speed;

    if (x <= -bkg.getFitWidth() + 1280)
    {
      x = 0;
    }
    bkg.setLayoutX(x);
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
