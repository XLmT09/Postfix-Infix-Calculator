package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import entry.EntryInterface;
import entry.NumEntry;
import entry.SymbolEntry;
import enums.Symbol;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import stack.Stack;

class TestStack {
  private Stack stack;
  private EntryInterface numEntry;
  private EntryInterface symbolEntry;
  private int currentSize;
  private ArrayList<NumEntry> testArray;

  @BeforeEach
  void setUp() {
    stack = new Stack();
    numEntry = new NumEntry(BigDecimal.valueOf(5.0));
    symbolEntry = new SymbolEntry(Symbol.MINUS);
    currentSize = 0;
    testArray = new ArrayList<>();
  }

  @Test
  void testEmptyStackSize() {
    assertEquals(stack.size(), 0, "Test if empty stack equals zero");
  }

  @Test
  void testStackPush() {
    stack.push(numEntry);
    assertEquals(stack.size(), 1, "Test if size increases after pushing value in stack.");
  }
  
  @Test
  void testFiveStackPush() {
    for (int i = 0; i <= 4; i++) {
      stack.push(numEntry);
    }
    assertEquals(5, stack.size(), "Test if size increases after pushing value in stack.");
  }
  
  @Test
  void testLotsPush() {
    for (float entryVal = -100.4f; entryVal < 500; entryVal++) {
      stack.push(new NumEntry(BigDecimal.valueOf(entryVal)));
      assertEquals(stack.size(), (int) ++currentSize, "After pushing size should increase by one.");
    }
  }

  @Test
  void testStackPushAndPop() {
    stack.push(numEntry);
    assertEquals(stack.pop(), numEntry, "Test if numEntry will be returned after popping.");
    assertEquals(stack.size(), 0, "Test if stack is empty after popping.");
  }

  @Test
  void testEmptyStackPop() {
    assertThrows(EmptyStackException.class, () -> stack.pop(), "Cannot pop from an empty stack.");
  }

  @Test
  void testPushTwiceThenPopUntilException() {
    stack.push(numEntry);
    stack.push(symbolEntry);
    assertEquals(stack.size(), 2, "Test if size is two after pushing two entries.");
    assertEquals(stack.pop(), symbolEntry, "As symbolEntry was last push it should be popped.");
    assertEquals(stack.size(), 1, "After popping size should go down by one.");
    assertEquals(stack.pop(), numEntry, "numEntry is last in stack so it should be popped.");
    assertEquals(stack.size(), 0, "After popping last Entry size should be zero.");
    assertThrows(EmptyStackException.class, () -> stack.pop(), "Cannot pop from an empty stack.");
  }

  @Test
  void testStackTop() {
    stack.push(numEntry);
    assertEquals(stack.top(), numEntry, "After push a entry we should see it on the top.");
    assertEquals(stack.size(), 1, "top method should not remove any entries from Stack.");
  }

  @Test
  void testEmptyStackTop() {
    assertThrows(EmptyStackException.class, () -> stack.top(),
        "Cannot use top method with an empty stack.");
  }

  @Test
  void testTwoPushThenTop() {
    stack.push(numEntry);
    stack.push(symbolEntry);
    assertEquals(stack.top(), symbolEntry, "Test if top gets last Entry added and not older one.");
    assertEquals(stack.size(), 2, "top method should not remove any entries from Stack.");
  }

  @Test
  void testTwoPushThenPopThenTop() {
    stack.push(numEntry);
    stack.push(symbolEntry);
    assertEquals(stack.pop(), symbolEntry, "Test Stack pops newest Entry.");
    assertEquals(stack.top(), numEntry, "Test if top gets newest Entry after pop.");
    assertEquals(stack.size(), 1, "top method should not remove any entries from Stack.");
  }

  @Test
  void testPushLotsThenLoopPopAndTop() {
    for (float entryVal = -50f; entryVal < 500; entryVal++) {
      stack.push(new NumEntry(BigDecimal.valueOf(entryVal)));
      //array will help identify later if stack top and pop returns the correct values.
      testArray.add(new NumEntry(BigDecimal.valueOf(entryVal)));
      assertEquals(stack.size(), ++currentSize, "After pushing size should increase by one.");
    }

    while (stack.size() > 0) {
      assertEquals(stack.top(), testArray.get(stack.size() - 1),
          "Test if top gets newest Entry before pop.");
      assertEquals(stack.pop(), testArray.get(stack.size()), "Test Stack pops newest Entry.");
      
      if (stack.size() != 0) {
        assertEquals(stack.top(), testArray.get(stack.size() - 1),
            "Test if top gets newest Entry after pop.");
      } else {
        assertThrows(EmptyStackException.class, () -> stack.top(),
            "Cannot use top method with an empty stack.");
      }
    }
  }
  
  @Test
  void testClearStack() {
    stack.clear();
    assertEquals(0, stack.size(),
        "Stack size should be zero after clearing.");
  }
}
