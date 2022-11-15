package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
  void testNumStackTop() {
    assertEquals(numStack.top(), 1);
  }
  

}
