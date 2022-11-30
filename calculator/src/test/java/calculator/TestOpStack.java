package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestOpStack {
  private OpStack stack;
  
  @BeforeEach
  void setUp() {
    stack = new OpStack();
  }

  @Test
  void testOpStackIsEmpty() {
    assertEquals(stack.isEmpty(), true, 
        "Nothing is added to stack when created so returns true.");
  }

}
