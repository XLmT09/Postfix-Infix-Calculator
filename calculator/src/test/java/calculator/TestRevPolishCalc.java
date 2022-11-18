package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestRevPolishCalc {
  private RevPolishCalc calc;
  //random numbers which will be used for test expressions.
  private Random rand;
  //This string will be used to build large expressions for my test cases.
  private String testExpression;
  private float sum;
  
  @BeforeEach
  void setUp() {
    calc = new RevPolishCalc();
    rand = new Random();
    testExpression = "";
    sum = 0;
  }
  
  @Test
  void testBasicAddition() {
    assertEquals(calc.evaluate("1 1 +"), 2.0f);
    assertEquals(calc.evaluate("1 2 +"), 3.0f);
  }
  
  @Test
  void testTenThousandRandomNumbersAddtion() {
    //Will hold the randomly generated number in every loop
    int intRandom = 0;
    //The highest number intRandom can hold
    int randLimit = 1000;
    
    //set up beginning expression
    intRandom = rand.nextInt(randLimit);
    sum += intRandom;
    testExpression += intRandom;
    intRandom = rand.nextInt(randLimit);
    sum += intRandom;
    testExpression += " " + intRandom + " + ";
    
    //Adds random number to sum and updates string expression every loop
    for (int i = 0; i < 10000; i++) {
      intRandom = rand.nextInt(randLimit);
      sum += intRandom;
      testExpression += intRandom + " + ";
    }
 
    assertEquals(calc.evaluate(testExpression), sum,
        "Evaluate should return the same value as sum,"
        + " because sum had kept track of the additions.");
  }
  
  @Test
  void testBasicSubtraction() {
    assertEquals(calc.evaluate("1 2 -"), -1.0f, 
        "It should pop the first value and be subtracted by the second popped value.");
  }
  
  @Test
  void testTenThousandRandomNumbersSubtraction() {
    //Will hold the randomly generated number in every loop
    int intRandom = 0;
    //The highest number intRandom can hold
    int randLimit = 1000;
    
    //set up beginning expression
    intRandom = rand.nextInt(randLimit);
    //Only first number will be added to sum
    sum += intRandom;
    testExpression += intRandom;
    intRandom = rand.nextInt(randLimit);
    sum -= intRandom;
    testExpression += " " + intRandom + " - ";
    
    //subtracts random number to sum and updates string expression every loop
    for (int i = 0; i <= 10000; i++) {
      intRandom = rand.nextInt(randLimit);
      sum -= intRandom;
      testExpression += intRandom + " - ";
    }
 
    assertEquals(calc.evaluate(testExpression), sum,
        "Evaluate should return the same value as sum,"
        + " because sum had kept track of the subtractions.");
  }  

  @Test
  void testBasicMultiplication() {
    assertEquals(calc.evaluate("6 2 *"), 12.0f, 
        "It should pop the first value and be multiplied by the second popped value.");
  }
  
  @Test
  void testTwentyRandomNumbersMultiplication() {
    //Will hold the randomly generated number in every loop
    int intRandom = 0;
    //The highest number intRandom can hold
    int randLimit = 10;
    //Lowest number intRandom can hold, to prevent zero multiplication
    int minLimit = 1;
    
    //set up beginning expression
    intRandom = rand.nextInt(randLimit + 1 - minLimit) + minLimit;
    //Only first number will be added to sum
    sum += intRandom;
    testExpression += intRandom;
    intRandom = rand.nextInt(randLimit + 1 - minLimit) + minLimit;
    sum *= intRandom;
    testExpression += " " + intRandom + " * ";
    
    //multiplies random number to sum and updates string expression every loop
    for (int i = 0; i <= 20; i++) {
      intRandom = rand.nextInt(randLimit + 1 - minLimit) + minLimit;
      sum *= intRandom;
      testExpression += intRandom + " * ";
    }
 
    assertEquals(calc.evaluate(testExpression), sum,
        "Evaluate should return the same value as sum,"
        + " because sum had kept track of the multplication.");
  }  
}
