package calculator;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

/**
 * This class represents a Stack of Entry values. 
 *
 * @author HIJI
 */
public class Stack {
  private Integer size = 0;
  private List<Entry> entries = new ArrayList<>();
  
  /**
   * Returns the {@code Stack} size.
   */
  public int size() {
    return size;
  }
  
  /**
   * Adds a new Entry to the {@code Stack}.
   *
   * @param newEntry The newest {@code Entry} to be added
   */
  public void push(Entry newEntry) {
    entries.add(newEntry);
    size++;
  }
  
  /**
   * Return and removes the newest {@code Entry} from the {@code Stack}.
   *
   * @return newEntry The newest {@code Entry} from the {@code Stack}
   * @throws EmptyStackException If {@code Stack} size is zero
   */
  public Entry pop() {
    if (size == 0) {
      throw new EmptyStackException();
    }
    size--;
    return entries.remove(entries.size() - 1);
  }  
  
  /**
   * Returns the newest {@code Entry} from the {@code Stack} but wont remove it.
   *
   * @return newEntry The newest {@code Entry} from the {@code Stack}
   * @throws EmptyStackException If {@code Stack} size is zero
   */
  public Entry top() {
    if (size == 0) {
      throw new EmptyStackException();
    }
    return entries.get(entries.size() - 1);
  }
  
  
  
  
}
