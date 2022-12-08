package stack;

import entry.FactoryEntry;
import enums.Symbol;

/**
 * The {@code OpStack} class will be a {@link stack.Stack Stack} of {@link enums.Symbol
 * Symbols} for the Shunting Algorithm. We provide a facade to hide details of the
 * {@link stack.Stack Stack}.
 *
 * @author HIJI
 */
public class OpStack {
  private Stack stack;
  private static FactoryEntry fact;

  /**
   * Constructs a new {@code OpStack} object and initialises an empty {@link stack.Stack
   * Stack}.
   */
  public OpStack() {
    stack = new Stack();
    fact = new FactoryEntry();
  }

  /**
   * Returns true if {@code OpStack} has no {@link calculator.Entry Entry} objects otherwise it
   * returns false.
   */
  public boolean isEmpty() {
    return stack.size() < 1;
  }

  /**
   * Converts the passed {@link enums.Symbol Symbol} to an {@link calculator.Entry Entry}
   * object and added to the {@code NumStack}.
   *
   * @param sym The value to be converted to an {@link calculator.Entry Entry} object.
   */
  public void push(Symbol sym) {
    stack.push(fact.createEntry(sym));
  }

  /**
   * Retrieves and removes the latest {@link calculator.Entry Entry} in {@code OpStack} and returns
   * its corresponding {@link enums.Symbol Symbol} value.
   *
   * @return The newest {@link calculator.Entry Entry} object's {@link enums.Symbol Symbol}
   *         value
   */
  public Symbol pop() {
    return stack.pop().getSymbol();
  }

  /**
   * Looks at the {@link calculator.Entry Entry} {@link enums.Symbol Symbol} on top of the
   * {@link stack.Stack Stack}.
   *
   * @return The {@link enums.Symbol Symbol} {@code String} code.
   */
  public String peek() {
    return stack.top().getSymbol().toString();
  }

}
