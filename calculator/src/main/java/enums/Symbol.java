package enums;

/**
 * A list of the non-number tokens possible in an expression.
 *
 * @author HIJI
 *
 */

public enum Symbol {
  LEFT_BRACKET("("),
  RIGHT_BRACKET(")"),
  TIMES("*"),
  DIVIDE("/"),
  PLUS("+"),
  MINUS("-"),
  INVALID("invalid");
  
  private final String code;
  
  /**
   * Constructs abbreviation for constants.
   */
  Symbol(String code) {
    this.code = code;
  }
  
  @Override
  public String toString() {
    return code;
  }
}
