package calculator;

/**
 * A list of the types of value an Entry can represent.
 *
 * @author HIJI
 *
 */
public enum Type {
  NUMBER("num"),
  SYMBOL("sym"),
  STRING("str"),
  INVALID("invalid");

  private final String code;
  
  /**
   * Constructs abbreviation for constants.
   */
  Type(String code) {
    this.code = code;
  }
  
  @Override
  public String toString() {
    return code;
  }
}
