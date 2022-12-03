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
  
  @Test
  void testStandardEvaluate() {
    calc.setState(true);
    assertEquals(6.0f, calc.evaluate("3 + 3"));
  }

}
