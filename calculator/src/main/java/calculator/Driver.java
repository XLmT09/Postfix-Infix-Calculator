package calculator;

import calculator.controller.CalcController;

/**
 * The programme starts of by executing the main. 
 *
 * @author HIJI
 */
public class Driver  {

  public static void main(String[] args) {
    Launcher.startJavaFx(new CalcController(), args);
  }
}
