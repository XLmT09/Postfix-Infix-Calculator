package calculator;

/**
 * The @code NumStack class represents a @see calculator.Stack of numeric values. 
 *
 * @author HIJI
 */
public class NumStack {
  Stack stack;
  
  public NumStack() {
    stack = new Stack();
  }
  
  public int push(float value) {
    return 1;
  }
  
  public int top() {
    return 1;
  }
  
  public boolean isEmpty() {
    return stack.size() == 0;
  }
}
