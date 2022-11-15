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
  void testNumStackPush() {
    assertEquals(numStack.top(), 1);
  }
  
  @Test
  void testNumStackTop() {
    assertEquals(numStack.top(), 1);
  }
  
  @Test
  void testNumStackIsEmpty() {
    assertEquals(numStack.isEmpty(), true);
  }
  

}
