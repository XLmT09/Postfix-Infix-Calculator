package calculator;

import enums.Symbol;
import enums.Type;
import exceptions.BadTypeException;
import java.util.Objects;

/**
 * This Entry class represents the values which can be stored in a stack, the Entry class can only
 * be of one {@code Type}.
 *
 * @author HIJI
 *
 */
public class Entry {
  private float number;
  private Symbol other;
  private String str;
  private Type type;

  /**
   * Constructs a new {@code Entry} of type {@code NUMBER}.
   *
   * @param value The number the {@code Entry} class will hold
   */
  public Entry(float value) {
    number = value;
    type = Type.NUMBER;
    other = Symbol.INVALID;
  }

  /**
   * Constructs a new {@code Entry} of type {@code SYMBOL}.
   *
   * @param which The symbol the {@code Entry} class will hold
   */
  public Entry(Symbol which) {
    other = which;
    type = Type.SYMBOL;
  }

  /**
   * Constructs a new {@code Entry} of type {@code STRING}.
   *
   * @param newStr The string the {@code Entry} class will hold
   */
  public Entry(String newStr) {
    str = newStr;
    type = Type.STRING;
    other = Symbol.INVALID;
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
   * @return other The {@code Symbol} an {@code Entry} holds
   * @throws BadTypeException If {@code Entry} not of {@code Type SYMBOL}
   */
  public Symbol getSymbol() {
    if (getType() != Type.SYMBOL) {
      throw new BadTypeException("Entry must be Type: SYMBOL");
    }
    return other;
  }

  /**
   * Returns the float value an {@code Entry} represents.
   *
   * @return number The float value an {@code Entry} holds
   * @throws BadTypeException If {@code Entry} not of {@code Type NUMBER}
   */
  public float getValue() {
    if (getType() != Type.NUMBER) {
      throw new BadTypeException("Entry must be Type: NUMBER");
    }
    return number;
  }

  @Override
  public int hashCode() {
    return Objects.hash(number, other, str, type);
  }

  /**
   * Returns true if two entries have the same {@code Type} and value.
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
    Entry otherEntry = (Entry) obj;
    return type.equals(otherEntry.type) && other.equals(otherEntry.other)
        && number == otherEntry.number && (str == null || str.equals(otherEntry.str));
  }

  @Override
  public String toString() {
    if (type == Type.NUMBER) {
      return "" + number;
    }
    if (type == Type.STRING) {
      return str;
    }
    if (type == Type.SYMBOL) {
      return other.toString();
    }
    return "inavlid";
  }


}
