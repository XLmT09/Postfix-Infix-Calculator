package calculator;

/**
 * The {@code OpStack} class will be a {@link calculator.Stack Stack} of {@link calculator.Symbol
 * Symbols} for the Shunting Algorithm. We provide a facade to hide details of the
 * {@link calculator.Stack Stack}.
 *
 * @author HIJI
 */
public class OpStack {
  private Stack stack;

  /**
   * Constructs a new {@code OpStack} object and initialises an empty {@link calculator.Stack
   * Stack}.
   */
  public OpStack() {
    stack = new Stack();
  }

  /**
   * Returns true if {@code OpStack} has no {@link calculator.Entry Entry} objects otherwise it
   * returns false.
   */
  public boolean isEmpty() {
    return stack.size() < 1;
  }

  /**
   * Converts the passed {@link calculator.Symbol Symbol} to an {@link calculator.Entry Entry}
   * object and added to the {@code NumStack}.
   *
   * @param sym The value to be converted to an {@link calculator.Entry Entry} object.
   */
  public void push(Symbol sym) {
    stack.push(new Entry(sym));
  }

  /**
   * Retrieves and removes the latest {@link calculator.Entry Entry} in {@code OpStack} and returns
   * its corresponding {@link calculator.Symbol Symbol} value.
   *
   * @return The newest {@link calculator.Entry Entry} object's {@link calculator.Symbol Symbol}
   *         value
   */
  public Symbol pop() {
    return stack.pop().getSymbol();
  }

  /**
   * Looks at the {@link calculator.Entry Entry} {@link calculator.Symbol Symbol} on top of the
   * {@link calculator.Stack Stack}.
   *
   * @return The {@link calculator.Symbol Symbol} {@code String} code.
   */
  public String peek() {
    return stack.top().getSymbol().toString();
  }

}
