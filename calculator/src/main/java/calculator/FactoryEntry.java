package calculator;

import enums.Symbol;

/**
 * A factory class which creates different Entry types.
 *
 * @author HIJI
 */
public class FactoryEntry {

  public FactoryEntry() {}
  
  public NumEntry createEntry(float val) {
    return new NumEntry(val);
  }
  
  public SymbolEntry createEntry(Symbol sym) {
    return new SymbolEntry(sym);
  }
}
