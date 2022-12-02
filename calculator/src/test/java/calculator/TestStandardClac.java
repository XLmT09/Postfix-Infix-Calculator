package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestStandardClac {
  private StandardCalc calc;
  
  //Initiated for each test case
  @BeforeEach
  void setUp() {
    calc = new StandardCalc();
  }
  
  //Expressions with just numbers should just output a number
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
  
  //Test if multiple of the same operators work in a expression
  @Test
  void testTwoSameOperation() {
    assertEquals(13f, calc.evaluate("3 + 4 + 6"));
    assertEquals(-11f, calc.evaluate("3 - 8 - 6"));
    assertEquals(1.25f, calc.evaluate("10 / 2 / 4"));
    assertEquals(270f, calc.evaluate("5 * 9 * 6"));
  }
  
  //Testing if expressions follow BIDMAS
  @Test
  void testTwoDifferentOperations() {
    assertEquals(-14f, calc.evaluate("4 - 6 * 3"));
    assertEquals(22f, calc.evaluate("4 + 6 * 3"));
    assertEquals(1.5f, calc.evaluate("5 - 7 / 2"));
    assertEquals(35f, calc.evaluate("8 + 9 * 3"));
  }
}
