package calculator;

/**
 * This exception is thrown when an expression has a invalid symbol. 
 *
 * @author HIJI
 */
@SuppressWarnings("serial")
public class InvalidExpressionException extends RuntimeException {
  /**
   * Constructor is used to add custom messages for exception.
   *
   * @param message this will contain custom message for the exception.
   */
  public InvalidExpressionException(String message) {
    super(message);
  }
}
