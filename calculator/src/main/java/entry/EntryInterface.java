package entry;

import enums.Symbol;
import enums.Type;
import java.math.BigDecimal;

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
   * Returns the decimal value an {@code Entry} represents.
   */
  public BigDecimal getValue();

}
