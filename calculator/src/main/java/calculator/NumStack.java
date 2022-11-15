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
  
  public void push(float value) {
    Entry newEntry = new Entry((int) value);
    stack.push(newEntry);
  }
  
  public int top() {
    return 1;
  }
  
  public boolean isEmpty() {
    return stack.size() == 0;
  }
}
