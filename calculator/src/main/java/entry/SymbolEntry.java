package entry;

import enums.EntryInterface;
import enums.Symbol;
import enums.Type;
import exceptions.BadTypeException;
import java.util.Objects;

/**
 * An Entry which contains only type symbols.
 *
 * @author HIJI
 */
public class SymbolEntry implements EntryInterface {
  private Symbol sym;
  private Type type;

  /**
   * Constructs a new {@code Entry} of type {@code NUMBER}.
   *
   * @param val The symbol the {@code Entry} class will hold
   */
  public SymbolEntry(Symbol val) {
    sym = val;
    type = Type.SYMBOL;
  }

  /**
   * Returns the {@code Type} of an {@code Entry}.
   */
  public Type getType() {
    return type;
  }

  /**
   * Returns the {@code Symbol} value an {@code Entry} represents.
   */
  public Symbol getSymbol() {
    return sym;
  }

  /**
   * Returns the float value an {@code Entry} represents.
   *
   * @throws BadTypeException If {@code Entry} not of {@code Type NUMBER}
   */
  public float getValue() {
    throw new BadTypeException("Entry must be Type: NUMBER");
  }
  
  @Override
  public int hashCode() {
    return Objects.hash(sym, type);
  }

  /**
   * Returns true if two entries have the same {@code Type} and number.
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    EntryInterface otherEntry = (EntryInterface) obj;
    return type.equals(otherEntry.getType()) && sym == otherEntry.getSymbol();
  }
  
  @Override
  public String toString() {
    return "" + sym;
  }
}
