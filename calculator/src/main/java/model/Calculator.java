package model;

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
   * @return a result in {@Stirng} which represents the solution to the expression
   */
  public String evaluate(String expression);
}
