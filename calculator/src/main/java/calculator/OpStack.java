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
   * Constructs a new {@code OpStack} object and
   * initialises an empty {@link calculator.Stack Stack}. 
   */
  public OpStack() {
    stack = new Stack();
  }
  
  /**
   * Returns true if {@code OpStack} has no {@link calculator.Entry Entry} 
   * objects otherwise it returns false.
   */
  public boolean isEmpty() {
    return true;
  }
}
