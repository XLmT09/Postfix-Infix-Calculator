package calculator;

/**
 * This exception is thrown when entry type is invalid.
 *
 * @author HIJI
 *
 */
@SuppressWarnings("serial")
public class BadTypeException extends RuntimeException {
  /**
   * Constructor is used to add custom messages for exception.
   *
   * @param message this will contain custom message for the exception.
   */
  public BadTypeException(String message) {
    super(message);
  }
}
