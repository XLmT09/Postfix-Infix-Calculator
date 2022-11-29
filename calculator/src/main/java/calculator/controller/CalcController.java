package calculator.controller;

import calculator.InvalidExpressionException;
import calculator.RevPolishCalc;
import calculator.ViewInterface;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;


/**
 * The observer which will observe the {@code View}, it will update its values are being notified
 * from the view.
 *
 * @author HIJI, Dave
 */
public class CalcController {
  //I use decimal format to get rid of scientific notation
  DecimalFormat df = new DecimalFormat("0", DecimalFormatSymbols.getInstance(Locale.ENGLISH));
  // Only RevPolishPolish model made so just hard code this model for now
  private RevPolishCalc model = new RevPolishCalc();
  // The view the controller will listen to
  private ViewInterface view;

  public CalcController() {}

  // Performs evaluation for a given expression, where evaluation depends on the model type
  private void calculate() {
    try {
      df.setMaximumFractionDigits(340);
      view.setAnswer("" + df.format(model.evaluate(view.getExpression())));
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
    v.addCalcObserver(this::calculate);
  }
}
