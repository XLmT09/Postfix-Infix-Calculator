package enums;

/**
 * This interface contains getters which all Entry must implement.
 *
 * @author HIJI
 */
public interface EntryInterface {
  /**
   * Returns the {@link enums.Type Type} of an {@code Entry}.
   */
  public Type getType();

  /**
   * Returns the {@link enums.Symbols Symbol} value an {@code Entry} represents.
   */
  public Symbol getSymbol();

  /**
   * Returns the float value an {@code Entry} represents.
   */
  public float getValue();

}
