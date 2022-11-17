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
    //Split and store components of expression in an array
    String[] expressionParts = expression.split(" ");
    //This regular expression checks if a string is an integer or decimal
    String regex = "[0-9]+[\\.]?[0-9]*";
    //stores result of the expression
    float result = 0;
    
    for (String part : expressionParts) {
      if (part.matches(regex)) {
        stackValues.push(Float.parseFloat(part));
        System.out.println(Float.parseFloat(part));
      }
    }
        
    while (!stackValues.isEmpty()) {
      result += stackValues.pop();
    }

    return (float) (Math.round(result * 100.0) / 100.0);
  }
}
