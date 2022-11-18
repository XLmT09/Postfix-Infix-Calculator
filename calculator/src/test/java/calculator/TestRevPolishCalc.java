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
    System.out.println(calc.evaluate("1 2 -"));
    assertEquals(calc.evaluate("1 2 -"), -1.0f, 
        "It should pop the first value and be subtracted by the second popped value.");
  }
  
  @Test
  void testTenThousandRandomNumbersSubtraction() {
    float sum = 0;
    //Will hold the randomly generated number in every loop
    int intRandom = 0;
    String testExpression = "";
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
    
    //Adds random number to sum and updates string expression every loop
    for (int i = 0; i < 10000; i++) {
      intRandom = rand.nextInt(randLimit);
      sum -= intRandom;
      testExpression += intRandom + " - ";
    }
 
    System.out.println(calc.evaluate(testExpression));
    System.out.println(sum);
    assertEquals(calc.evaluate(testExpression), sum,
        "Evaluate should return the same value as sum,"
        + " because sum had kept track of the subtractions.");
  }  

}
