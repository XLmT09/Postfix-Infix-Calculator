package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.EmptyStackException;
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
  
  @Test
  void testOpStackPopException() {
    assertThrows(EmptyStackException.class, () -> opStack.pop(), 
        "Cannot pop from an empty stack.");
  }
  
  @Test
  void testOpStackPushAndPopTwice() {
    opStack.push(Symbol.PLUS);
    opStack.push(Symbol.DIVIDE);
    assertEquals(opStack.isEmpty(), false,
        "Adding Entry to stack wont make it empty.");
    assertEquals(opStack.pop(), Symbol.DIVIDE,
        "Pushed Symbol.DIVIDE last, so when popped i should get Symbol.DIVIDE");
    assertEquals(opStack.isEmpty(), false,
        "Still one Entry in stack so not empty.");
    assertEquals(opStack.pop(), Symbol.PLUS,
        "Last Entry is Symbol.PLUS, so when popped i should get Symbol.PLUS");
    assertEquals(opStack.isEmpty(), true, 
        "After stack has been popped it should be empty.");
  }

  @Test
  void testOpStackPeek() {
    opStack.push(Symbol.DIVIDE);
    assertEquals("/", opStack.peek(), "Pushed divide symbol so should be on top when peeking.");
  }

}
