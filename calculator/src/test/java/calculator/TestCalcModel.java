package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import enums.OpType;
import java.math.BigDecimal;
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
    assertEquals(BigDecimal.valueOf(6), calc.evaluate("3 + 3"));
  }
  
  //Change state to postfix then perform evaluation
  @Test
  void testPostfixEvaluate() {
    calc.setState(OpType.POSTFIX);
    assertEquals(BigDecimal.valueOf(6), calc.evaluate("3 3 +"));
  }

}
