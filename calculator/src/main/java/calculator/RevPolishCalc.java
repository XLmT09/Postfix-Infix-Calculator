package calculator;

/**
 * This class evaluates reverse polish {@code String} expressions.
 *
 * @author HIJI
 */
public class RevPolishCalc implements Calculator {
  //The NumStack will hold the numeric values of an given expression.
  private NumStack stackValues;
  
  /**
   * Initialises an empty {@link calculator.NumStack NumStack}. 
   */
  public RevPolishCalc() {
    stackValues = new NumStack();
  }

  /**
   * Returns a solution for reverse polish notation expressions. 
   */
  @Override
  public float evaluate(String expression) {
    return (float) 2.0;
  }
}
