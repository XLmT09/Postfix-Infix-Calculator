package model;

import exceptions.InvalidExpressionException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.EmptyStackException;
import stack.NumStack;

/**
 * This class evaluates reverse polish {@code String} expressions.
 *
 * @author HIJI
 */
public class RevPolishCalc implements Calculator {
  // The NumStack will hold the numeric values of an given expression.
  private NumStack stackValues;

  /**
   * Initialises an empty {@link stack.NumStack NumStack}.
   */
  public RevPolishCalc() {
    stackValues = new NumStack();
  }

  // This method calculates and returns the operations on two numbers
  private BigDecimal doOperation(String operation, BigDecimal val1, BigDecimal val2) {
    switch (operation) {
      case "+":
        return val2.add(val1);
      case "-":
        return val2.subtract(val1);
      case "*":
        return val2.multiply(val1);
      case "/":
        return val2.divide(val1, MathContext.DECIMAL32);
      // If operators above are not recognised then its invalid
      default:
        throw new InvalidExpressionException("Expression contains an invalid operator");
    }
  }

  /**
   * Returns a solution for reverse polish notation expressions.
   *
   * @param expression The {@code String} to be evaluated
   * @return The solution for the expression
   * @throws InvalidExpressionException If there are not enough numbers in
   *         {@link stack.NumStack NumStack} during calculation, or if expression contains an
   *         invalid operator. This means operator must be: +, -, * or /.
   */
  @Override
  public BigDecimal evaluate(String expression) {
    // Split and store components of expression in an array
    String[] expressionParts = expression.trim().split(" ");
    // This regular expression checks if a string is an integer or decimal
    String regex = "[-]*[0-9]+[\\.]?[0-9]*";
    // result of the evaluation stored here
    BigDecimal result;

    // Clear stack whenever method gets called, so previous values are not in use
    stackValues.clear();

    // loop through elements of an expression
    for (String part : expressionParts) {
      // check if string element is a number
      if (part.matches(regex)) {
        stackValues.push(new BigDecimal(part));
      } else {
        try {
          // If operator is detected then should always pop the first two numbers
          BigDecimal num1 = stackValues.pop();
          BigDecimal num2 = stackValues.pop();
          stackValues.push(doOperation(part, num1, num2));
          // EmptyStackException is called if there isn't enough numbers in stack to
          // perform the operation
        } catch (EmptyStackException e) {
          throw new InvalidExpressionException("Invalid postfix expression");
        }
      }
    }

    result = stackValues.pop();
    // If stack is not empty then the expression was not valid
    if (!stackValues.isEmpty()) {
      throw new InvalidExpressionException("Invalid postfix expression");
    }
    // last value in the stack contains the result

    return result;
  }
}
