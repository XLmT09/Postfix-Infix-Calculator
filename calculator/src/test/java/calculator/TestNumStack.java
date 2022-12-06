package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import stack.NumStack;

class TestNumStack {
  private NumStack numStack;
  
  @BeforeEach
  void setUp() {
    numStack = new NumStack();
  }
  
  @Test
  void testNumStackIsEmpty() {
    assertEquals(numStack.isEmpty(), true, 
        "Nothing is added to stack when created so returns true.");
  }
  
  @Test
  void testNumStackPush() {
    numStack.push(BigDecimal.valueOf(5));
    assertEquals(numStack.isEmpty(), false,
        "Adding Entry to stack wont make it empty.");
  }
  
  @Test
  void testNumStackPop() {
    numStack.push(BigDecimal.valueOf(3.0));
    assertEquals(numStack.pop(), BigDecimal.valueOf(3.0),
        "Pushed a BigDecimal of value 3.0, so when popped i should get 3.0");
    assertEquals(numStack.isEmpty(), true, 
        "After stack has been popped it should be empty.");
  }
  
  @Test
  void testNumStackPopException() {
    assertThrows(EmptyStackException.class, () -> numStack.pop(), 
        "Cannot pop from an empty stack.");
  }
  
  @Test
  void testNumStackPushAndPopTwice() {
    numStack.push(BigDecimal.valueOf(3.0));
    numStack.push(BigDecimal.valueOf(4.0));
    assertEquals(numStack.isEmpty(), false,
        "Adding Entry to stack wont make it empty.");
    assertEquals(numStack.pop(), BigDecimal.valueOf(4.0),
        "Pushed a BigDecimal of value 4.0 last, so when popped i should get 4.0");
    assertEquals(numStack.isEmpty(), false,
        "Still one Entry in stack so not empty.");
    assertEquals(numStack.pop(), BigDecimal.valueOf(3.0),
        "Last Entry is 3.0, so when popped i should get 3.0");
    assertEquals(numStack.isEmpty(), true, 
        "After stack has been popped it should be empty.");
  }
  
  @Test
  void testClearStack() {
    numStack.clear();
    assertEquals(true, numStack.isEmpty(),
        "Stack size should be zero after clearing.");
  }
}
