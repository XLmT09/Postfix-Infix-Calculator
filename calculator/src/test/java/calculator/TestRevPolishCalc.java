package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestRevPolishCalc {
  private RevPolishCalc calc;
  //random numbers which will be used for test expressions.
  private Random rand;
  
  @BeforeEach
  void setUp() {
    calc = new RevPolishCalc();
    rand = new Random();
  }
  
  @Test
  void testBasicAddition() {
    assertEquals(calc.evaluate("1 1 +"), 2.0f);
  }
  
  @Test
  void testBasicSecondAddition() {
    assertEquals(calc.evaluate("1 2 +"), 3.0f);
  }
  
  @Test
  void testTenThousandRandomNumbersAddtion() {
    float sum = 0;
    //Will hold the randomly generated number in every loop
    int intRandom = 0;
    String testExpression = "";
    //The highest number intRandom can hold
    int randLimit = 1000;
    
    //Adds random number to sum and updates string expression every loop
    for (int i = 0; i < 10000; i++) {
      intRandom = rand.nextInt(randLimit);
      sum += intRandom;
      testExpression += intRandom + " + ";
    }
    
    testExpression += intRandom;
    sum += intRandom;
 
    assertEquals(calc.evaluate(testExpression), sum,
        "Evaluate should return the same value as sum,"
        + " because sum had kept track of the additions");
  }

}
