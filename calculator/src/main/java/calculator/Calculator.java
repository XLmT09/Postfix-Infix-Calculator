package calculator;

/**
 * The {@code Calculator} interface gives user control over what type of 
 * calculation to do with {@code String} expressions. 
 *
 * @author HIJI
 */
public interface Calculator {
  
  /**
   * Returns a solution for an given expression.
   *
   * @param expression The expression to be calculated 
   * @return a float which represents the solution to the {@code String} expression
   */
  public float evaluate(String expression);
}
