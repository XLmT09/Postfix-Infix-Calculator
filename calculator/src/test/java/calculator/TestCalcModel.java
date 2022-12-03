package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestCalcModel {
  private CalcModel calc;
  private RevPolishCalc rcalc;
  
  @BeforeEach
  void setUp() {
    calc = new CalcModel();
  }
  
  //Change state to infix then perform evaluation
  @Test
  void testStandardEvaluate() {
    calc.setState(true);
    assertEquals(6.0f, calc.evaluate("3 + 3"));
  }
  
  //Change state to postfix then perform evaluation
  @Test
  void testPostfixEvaluate() {
    calc.setState(false);
    assertEquals(6.0f, calc.evaluate("3 3 +"));
  }

}
