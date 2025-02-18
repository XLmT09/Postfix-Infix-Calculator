package calculator;

import controller.CalcController;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.AsciiView;


/**
 * This class is used to start the JavaFX framework.
 *
 * @author Dave
 */
public class Launcher extends Application {
  //Width and height of the application
  private final int width = 450;
  private final int height = 250;
  /**
   * Used to pass information into main since JavaFX requires a specified signature for main the
   * method.
   */
  private static CalcController myController;

  /**
   * The entry point to begin the JavaFX framework.
   *
   * @param c the controller that needs to be notified once the View is created
   */
  public static void startAscii(CalcController c) {
    AsciiView v = new AsciiView();
    myController = c;
    myController.addView(v);
    v.menu();
  }
  
  /**
   * The entry point to begin the JavaFX framework.
   *
   * @param c the controller that needs to be notified once the View is created
   * @param args the arguments to actual main method in the Driver
   */
  public static void startJavaFx(CalcController c, String[] args) {
    myController = c;
    Launcher.main(args);
  }

  /**
   * A callback for JavaFX when the toolkit is initialised. Used to instantiate the scene, create
   * the View and get the CSS.
   *
   * @param primaryStage the stage to attach the newly create scene.
   */
  @Override
  public void start(Stage primaryStage) {
    FXMLLoader loader;

    loader = new FXMLLoader(getClass().getClassLoader().getResource("GUIView.fxml"));

    Scene scene = null;
    try {
      scene = new Scene(loader.load(), width, height);
    } catch (IOException e) {
      // Do Nothing - there is nothing to be done.
      e.printStackTrace();
    }
    myController.addView(loader.getController());
    primaryStage.setScene(scene);
    primaryStage.setResizable(false);
    primaryStage.setTitle("Postfix/Infix Calculator");
    primaryStage.show();
  }

  /**
   * The main method needed by JavaFX in the Application class.
   *
   * @param args the args passed into the true main method in Driver
   */
  public static void main(String[] args) {
    Application.launch(args);
  }
}
