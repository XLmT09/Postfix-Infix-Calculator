package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import enums.OpType;
import model.CalcModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestCalcModel {
  private CalcModel calc;
  
  @BeforeEach
  void setUp() {
    calc = new CalcModel();
  }
  
  //Change state to infix then perform evaluation
  @Test
  void testStandardEvaluate() {
    calc.setState(OpType.INFIX);
    assertEquals(6.0f, calc.evaluate("3 + 3"));
  }
  
  //Change state to postfix then perform evaluation
  @Test
  void testPostfixEvaluate() {
    calc.setState(OpType.POSTFIX);
    assertEquals(6.0f, calc.evaluate("3 3 +"));
  }

}
