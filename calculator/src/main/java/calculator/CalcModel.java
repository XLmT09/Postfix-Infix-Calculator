package calculator;

/**
 * A state class which switches between postfix and infix.
 *
 * @author HIJI
 */
public class CalcModel {
  private Calculator currentState;
  private Calculator scalc;
  private Calculator rcalc;
  
  public CalcModel() {
    scalc = new StandardCalc();
    rcalc = new RevPolishCalc();
  }
  
  /**
   * Change calculator to either infix or postfix.
   *
   * @param isInfix Check if it should be in infix or not
   */
  public void setState(boolean isInfix) {
    if (isInfix) {
      currentState = scalc;
    } else {
      currentState = rcalc;
    }
  }
  
  /**
   * Evaluates user expression either in infix or postfix.
   */
  public float evaluate(String expression) {
    return currentState.evaluate(expression);
  }
}
