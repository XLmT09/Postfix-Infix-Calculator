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
  }


}
