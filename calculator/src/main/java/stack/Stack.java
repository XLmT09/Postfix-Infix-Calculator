package stack;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import entry.EntryInterface;

/**
 * This class represents a Stack of Entry values.
 *
 * @author HIJI
 */
public class Stack {
  private Integer size = 0;
  private List<EntryInterface> entries;

  /**
   * Constructs a empty {@code Stack}.
   */
  public Stack() {
    entries = new ArrayList<>();
  }

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
  public void push(EntryInterface newEntry) {
    entries.add(newEntry);
    size++;
  }

  /**
   * Return and removes the newest {@code Entry} from the {@code Stack}.
   *
   * @return newEntry The newest {@code Entry} from the {@code Stack}
   * @throws EmptyStackException If {@code Stack} size is zero
   */
  public EntryInterface pop() {
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
  public EntryInterface top() {
    if (size == 0) {
      throw new EmptyStackException();
    }
    return entries.get(entries.size() - 1);
  }
  
  /**
   * Clears the {@code Stack}.
   */
  public void clear() {
    entries.clear();
    size = 0;
  }
}
