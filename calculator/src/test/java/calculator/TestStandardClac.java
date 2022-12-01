package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestStandardClac {
  private StandardCalc calc;
  
  @BeforeEach
  void setUp() {
    calc = new StandardCalc();
  }
  
  @Test
  void testSingleNumberExpression() {
    assertEquals(3.0f, calc.evaluate("3"));
    assertEquals(4.0f, calc.evaluate("4"));
  }
  
  @Test
  void testBasicAddition() {
    assertEquals(6.0f, calc.evaluate("3 + 3"));
    assertEquals(7.0f, calc.evaluate("4 + 3"));
    assertEquals(0.0f, calc.evaluate("-3 + 3"));
  }
  
  @Test
  void testBasicSubtraction() {
    assertEquals(1.0f, calc.evaluate("4 - 3"));
    assertEquals(8.0f, calc.evaluate("10 - 2"));
  }

  @Test
  void testBasicMultiplication() {
    assertEquals(12.0f, calc.evaluate("4 * 3"));
    assertEquals(-32.0f, calc.evaluate("-8 * 4"));
  }

  @Test
  void testBasicDivision() {
    assertEquals(0.75f, calc.evaluate("3 / 4"));
    assertEquals(-4.0f, calc.evaluate("-8 / 2"));
  }
}
