package calculator;

/**
 * The @code NumStack class represents a @see calculator.Stack of numeric values. 
 *
 * @author HIJI
 */
public class NumStack {
  private Stack stack;
  
  /**
   * Constructs a new @code NumStack object and
   * initialises an empty @code Stack. 
   */
  public NumStack() {
    stack = new Stack();
  }
  
  /**
   * Adds new @see Entry to @see Stack.
   *
   * @param value The newest @code Entry to be added
   */
  public void push(float value) {
    Entry newEntry = new Entry((int) value);
    stack.push(newEntry);
  }
  
  /**
   * Retrieves the latest Entry in the stack and returns its corresponding
   * float value.
   *
   * @return poppedValue The newest entries float value
   */
  public float pop() {
    float poppedValue = stack.pop().getValue();
    return poppedValue;
  }
  
  /**
   * Returns true is @code NumStack has no @code Entry objects and false otherwise.
   */
  public boolean isEmpty() {
    return stack.size() == 0;
  }
}
