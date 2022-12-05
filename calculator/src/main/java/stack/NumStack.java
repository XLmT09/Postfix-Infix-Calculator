package stack;

import calculator.FactoryEntry;

/**
 * This class represents a 
 * {@link stack.Stack Stack} of numeric values. 
 *
 * @author HIJI
 */
public class NumStack {
  private Stack stack;
  private FactoryEntry fact;
  
  /**
   * Constructs a new {@code NumStack} object and
   * initialises an empty {@link stack.Stack Stack}. 
   */
  public NumStack() {
    stack = new Stack();
    fact = new FactoryEntry();
  }
  
  /**
   * Converts the passed float number to an  
   * {@link calculator.Entry Entry} object and added to the {@code NumStack}.
   *
   * @param num The value to be converted to an {@link calculator.Entry Entry} object.
   */
  public void push(float num) {
    stack.push(fact.createEntry(num));
  }
  
  /**
   * Retrieves and removes the latest {@link calculator.Entry Entry} in the 
   * {@code NumStack} and returns its corresponding float value.
   *
   * @return poppedValue The newest {@link calculator.Entry Entry} object's float value
   */
  public float pop() {
    float poppedValue = stack.pop().getValue();
    return poppedValue;
  }
  
  /**
   * Returns true if {@code NumStack} has no {@link calculator.Entry Entry} 
   * objects otherwise it returns false.
   */
  public boolean isEmpty() {
    return stack.size() == 0;
  }
  
  /**
   * Clear the {@link stack.Stack Stack}.
   */
  public void clear() {
    stack.clear();
  }
}
