package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    numStack.push((float) 5.0);
    assertEquals(numStack.isEmpty(), false,
        "Adding Entry to stack wont make it empty.");
  }
  
  @Test
  void testNumStackPop() {
    numStack.push((float) 3.0);
    assertEquals(numStack.pop(), 3.0,
        "Pushed a float of value 3.0, so when popped i should get 3.0");
    assertEquals(numStack.isEmpty(), true, 
        "After stack has been popped it should be empty.");
  }
  
  @Test
  void testNumStackPopException() {
    assertThrows(EmptyStackException.class, () -> numStack.pop(), 
        "Cannot pop from an empty stack.");
  }
  

}
