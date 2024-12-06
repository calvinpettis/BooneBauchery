package edu.appstate.cs.BooneBauchery.main;

import edu.appstate.cs.BooneBauchery.display.Display;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Applications are the entry point for javaFX. Need to have a start method for stuff to display. I guess we make a loop class that handles scene staging
 * For the moment this loads a main menu window for testing.
 *
 *
 */
public class Main extends Application {

  

  public void start(Stage primaryStage)
  {
    //create window
    Display display = new Display();
    primaryStage = display.getMainStage();
    primaryStage.setTitle("BooneBauchery");
    primaryStage.setScene(display.getMainScene());
    primaryStage.setResizable(false);
    primaryStage.show();
  }

  public static void startloop(Stage primaryStage)
  {
    //create new window for game loop
    Display display = new Display();
    primaryStage = display.getMainStage();
    primaryStage.setTitle("BooneBauchery");
    primaryStage.setScene(display.getMainScene());
    primaryStage.show();
  }


  public static void main(String[] args) {
    launch(args);
  }
}
