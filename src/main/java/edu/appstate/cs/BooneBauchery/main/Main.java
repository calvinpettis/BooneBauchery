package edu.appstate.cs.BooneBauchery.main;

import edu.appstate.cs.BooneBauchery.display.Display;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Hello world!
 *
 */
public class Main extends Application {

  public void start(Stage primaryStage)
  {
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
