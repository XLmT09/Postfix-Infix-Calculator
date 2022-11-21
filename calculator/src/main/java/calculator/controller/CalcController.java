package calculator.controller;

import calculator.RevPolishCalc;
import calculator.ViewInterface;

/**
 * The observer which will observe the {@code View}, it will
 * update its values are being notified from the view.
 *
 * @author HIJI, Dave
 */
public class CalcController {
  //Only RevPolishPolish model made so just hard code this model for now
  private RevPolishCalc model = new RevPolishCalc();
  //The view the controller will listen to
  private ViewInterface view;
  
  public CalcController() {}
  
  //Performs evaluation for a given expression, where evaluation depends on the model type
  private void calculate() {
    view.setAnswer("" + model.evaluate(view.getExpression()));
  }
  
  /**
   * The method which the view uses to add itself to the controller.
   *
   * @param v The {@code view} to be associated with the controller
   */
  public void addView(ViewInterface v) {
    view = v;
    v.addCalcObserver(this::calculate);
  }
}
