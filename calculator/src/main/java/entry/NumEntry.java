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
public class NumEntry implements EntryInterface {
  private float number;
  private Type type;

  /**
   * Constructs a new {@code Entry} of type {@code NUMBER}.
   *
   * @param val The symbol the {@code Entry} class will hold
   */
  public NumEntry(float val) {
    number = val;
    type = Type.NUMBER;
  }

  /**
   * Returns the {@code Type} of an {@code Entry}.
   */
  public Type getType() {
    return type;
  }

  /**
   * Returns the {@code Symbol} value an {@code Entry} represents.
   *
   * @throws BadTypeException If {@code Entry} not of {@code Type SYMBOL}
   */
  public Symbol getSymbol() {
    throw new BadTypeException("Entry must be Type: SYMBOL");
  }

  /**
   * Returns the float value an {@code Entry} represents.
   *
   * @return number The float value an {@code Entry} holds
   */
  public float getValue() {
    return number;
  }

  @Override
  public int hashCode() {
    return Objects.hash(number, type);
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
    return type.equals(otherEntry.getType()) && number == otherEntry.getValue();
  }
  
  @Override
  public String toString() {
    return "" + number;
  }
}