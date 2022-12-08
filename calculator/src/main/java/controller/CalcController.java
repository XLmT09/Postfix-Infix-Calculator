package controller;

import enums.OpType;
import exceptions.InvalidExpressionException;
import model.CalcModel;
import view.ViewInterface;


/**
 * The observer which will observe the {@code View}, it will update its values are being notified
 * from the view.
 *
 * @author HIJI, Dave
 */
public class CalcController {
  // Only RevPolishPolish model made so just hard code this model for now
  private CalcModel model;
  // The view the controller will listen to
  private ViewInterface view;

  public CalcController() {
    model = new CalcModel();
  }
  
  // Performs evaluation for a given expression, where evaluation depends on the model type
  private void calculate() {
    try {
      view.setAnswer("" + model.evaluate(view.getExpression()));
    } catch (InvalidExpressionException e) {
      // custom error messages have been written, so we just call the getMessage method
      view.setAnswer(e.getMessage());
    }
  }

  /**
   * The method which the view uses to add itself to the controller.
   *
   * @param v The {@code view} to be associated with the controller
   */
  public void addView(ViewInterface v) {
    view = v;
    // set initial type to postfix
    model.setState(OpType.POSTFIX);
    v.addCalcObserver(this::calculate);
    v.addTypeObserver(this::changeType);
  }
  
  /**
   * Change state of calculator and then display the state change to user.
   *
   * @param type The type to be changed to
   */
  public void changeType(OpType type) {
    model.setState(type);
    view.setAnswer("Changed to " + type);
  }
}
