package entry;

import java.math.BigDecimal;
import enums.Symbol;

/**
 * A factory class which creates different Entry types.
 *
 * @author HIJI
 */
public class FactoryEntry {

  /**
   * Constructs a new FactoryEntry.
   */
  public FactoryEntry() {}
  
  /**
   * Constructs a new {@code Entry} of type {@code NUMBER}.
   *
   * @param val The number the {@code Entry} class will hold
   */
  public NumEntry createEntry(BigDecimal val) {
    return new NumEntry(val);
  }
  
  /**
   * Constructs a new {@code Entry} of type {@code SYMBOL}.
   *
   * @param sym The number the {@code Entry} class will hold
   */
  public SymbolEntry createEntry(Symbol sym) {
    return new SymbolEntry(sym);
  }
}
