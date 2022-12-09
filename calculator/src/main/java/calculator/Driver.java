package calculator;

import controller.CalcController;

/**
 * The programme starts of by executing the main.
 *
 * @author HIJI
 */
public class Driver {

  /**
   * Java programs start by executing main.
   *
   * @param args The command line arguments
   */
  public static void main(String[] args) {
    if (System.console() != null) {
      Launcher.startAscii(new CalcController());
    } else {
      Launcher.startJavaFx(new CalcController(), args);
    }
  }
}
