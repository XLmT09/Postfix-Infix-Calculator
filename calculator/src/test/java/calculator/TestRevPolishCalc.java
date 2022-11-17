package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestRevPolishCalc {
  private RevPolishCalc calc;
  
  @BeforeEach
  void setUp() {
    calc = new RevPolishCalc();
  }
  
  @Test
  void testBasicAddition() {
    assertEquals(calc.evaluate("1 1 +"), 2.0);
  }
  
  @Test
  void testBasicSecondAddition() {
    assertEquals(calc.evaluate("1 2 +"), 3.0);
  }

}
