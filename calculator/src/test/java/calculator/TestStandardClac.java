package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import exceptions.InvalidExpressionException;
import java.math.BigDecimal;
import model.StandardCalc;
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
    assertEquals(BigDecimal.valueOf(3), calc.evaluate("3"));
    assertEquals(BigDecimal.valueOf(4), calc.evaluate("4"));
  }
  
  @Test
  void testBasicAddition() {
    assertEquals(BigDecimal.valueOf(6), calc.evaluate("3 + 3"));
    assertEquals(BigDecimal.valueOf(7), calc.evaluate("4 + 3"));
    assertEquals(BigDecimal.valueOf(0), calc.evaluate("-3 + 3"));
  }
  
  @Test
  void testBasicSubtraction() {
    assertEquals(BigDecimal.valueOf(1), calc.evaluate("4 - 3"));
    assertEquals(BigDecimal.valueOf(8), calc.evaluate("10 - 2"));
  }

  @Test
  void testBasicMultiplication() {
    assertEquals(BigDecimal.valueOf(12), calc.evaluate("4 * 3"));
    assertEquals(BigDecimal.valueOf(-32), calc.evaluate("-8 * 4"));
  }

  @Test
  void testBasicDivision() {
    assertEquals(BigDecimal.valueOf(0.75), calc.evaluate("3 / 4"));
    assertEquals(BigDecimal.valueOf(-4), calc.evaluate("-8 / 2"));
  }
  
  //Test if multiple of the same operators work in a expression
  @Test
  void testTwoSameOperation() {
    assertEquals(BigDecimal.valueOf(13), calc.evaluate("3 + 4 + 6"));
    assertEquals(BigDecimal.valueOf(-11), calc.evaluate("3 - 8 - 6"));
    assertEquals(BigDecimal.valueOf(1.25), calc.evaluate("10 / 2 / 4"));
    assertEquals(BigDecimal.valueOf(270), calc.evaluate("5 * 9 * 6"));
  }
  
  //Testing if expressions follow BIDMAS
  @Test
  void testTwoDifferentOperations() {
    assertEquals(BigDecimal.valueOf(-14), calc.evaluate("4 - 6 * 3"));
    assertEquals(BigDecimal.valueOf(22), calc.evaluate("4 + 6 * 3"));
    assertEquals(BigDecimal.valueOf(1.5), calc.evaluate("5 - 7 / 2"));
    assertEquals(BigDecimal.valueOf(35), calc.evaluate("8 + 9 * 3"));
  }
  
  @Test
  void testBrackets() {
    assertEquals(BigDecimal.valueOf(-6), calc.evaluate("( 4 - 6 ) * 3"));
  }
  
  @Test
  void testBadExpression() {
    assertThrows(InvalidExpressionException.class, () -> calc.evaluate("3 + + 3"), 
        "This is an invalid expression as there are two plus operators next to each other");
  }
  
  @Test
  void testRevPolishExpression() {
    assertThrows(InvalidExpressionException.class, () -> calc.evaluate("3 3 +"), 
        "RevPolish should not be valid in infix expressions.");
  }
}
