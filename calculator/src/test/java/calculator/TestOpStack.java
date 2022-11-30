package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestOpStack {
  private OpStack opStack;

  @BeforeEach
  void setUp() {
    opStack = new OpStack();
  }

  @Test
  void testOpStackIsEmpty() {
    assertEquals(opStack.isEmpty(), true,
        "Nothing is added to stack when created so returns true.");
  }

  @Test
  void testOpStackPush() {
    opStack.push(Symbol.PLUS);
    assertEquals(opStack.isEmpty(), false, "Adding Entry to stack wont make it empty.");
  }

  @Test
  void testOpStackPop() {
    opStack.push(Symbol.MINUS);
    assertEquals(opStack.pop(), Symbol.MINUS,
        "Pushed a minus symbol, so when popped i should get minus symbol");
    assertEquals(opStack.isEmpty(), true, "After stack has been popped it should be empty.");
  }



}
