package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    assertEquals(2.0f, calc.evaluate("1 1 +"));
    assertEquals(3.0f, calc.evaluate("1 2 +"));
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
 
    assertEquals(sum, calc.evaluate(testExpression),
        "Evaluate should return the same value as sum,"
        + " because sum had kept track of the additions.");
  }
  
  @Test
  void testBasicSubtraction() {
    assertEquals(-1.0f, calc.evaluate("1 2 -"), 
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
 
    assertEquals(sum, calc.evaluate(testExpression),
        "Evaluate should return the same value as sum,"
        + " because sum had kept track of the subtractions.");
  }  

  @Test
  void testBasicMultiplication() {
    assertEquals(12.0f, calc.evaluate("6 2 *"), 
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
 
    assertEquals(sum, calc.evaluate(testExpression),
        "Evaluate should return the same value as sum,"
        + " because sum had kept track of the multplication.");
  }  
  
  @Test
  void testBasicDivision() {
    assertEquals(2.0f, calc.evaluate("6 3 /"), 
        "It should pop the first value and be divided by the second popped value.");
  }
  
  @Test
  void testTwentyRandomNumbersDivsion() {
    //Will hold the randomly generated number in every loop
    int intRandom = 0;
    //The highest number intRandom can hold
    int randLimit = 10;
    //Lowest number intRandom can hold, to prevent zero division
    int minLimit = 1;
    
    //set up beginning expression
    intRandom = rand.nextInt(randLimit + 1 - minLimit) + minLimit;
    //Only first number will be added to sum
    sum += intRandom;
    testExpression += intRandom;
    intRandom = rand.nextInt(randLimit + 1 - minLimit) + minLimit;
    sum /= intRandom;
    testExpression += " " + intRandom + " / ";
    
    //Divides random number to sum and updates string expression every loop
    for (int i = 0; i <= 20; i++) {
      intRandom = rand.nextInt(randLimit + 1 - minLimit) + minLimit;
      sum /= intRandom;
      testExpression += intRandom + " / ";
    }
 
    assertEquals(sum, calc.evaluate(testExpression),
        "Evaluate should return the same value as sum,"
        + " because sum had kept track of the Division.");
  }  
  
  @Test
  void testOperationOnNegativeNumbers() {
    assertEquals(-5.0f, calc.evaluate("-5 1 /"));
    assertEquals(-10.0f, calc.evaluate("-20 10 +"));
  }
  
  @Test
  void testTwoDifferentOperations() {
    assertEquals(-14.0f, calc.evaluate("-5 1 + 10 -"));
  }
  
  @Test
  void testTwoOperationsInRow() {
    assertEquals(-16.0f, calc.evaluate("-5 1 10 + -"));
  }
  
  @Test 
  void testInvalidExpressionNotEnoughNumbers() {
    assertThrows(InvalidExpressionException.class, () -> calc.evaluate("+ 10 10"), 
        "Need at least two numbers in stack then include an operation");
    assertThrows(InvalidExpressionException.class, () -> calc.evaluate("10 + 10"), 
        "Need at least two numbers in stack then include an operation");
  }
  
  @Test 
  void testInvalidOperator() {
    assertThrows(InvalidExpressionException.class, () -> calc.evaluate("10 10 @"), 
        "Operators can only be *, +, -, /");
  }
  
  @Test 
  void testNoOperatorsWithTwoExpressions() {
    assertThrows(InvalidExpressionException.class, () -> calc.evaluate("10 10"), 
        "This is an invalid expression as there are two numbers and no operators");
  }
  
  @Test 
  void testInvalidExpressionThenCorrectExpressiom() {
    assertThrows(InvalidExpressionException.class, () -> calc.evaluate("10 10"), 
        "This is an invalid expression as there are two numbers and no operators");
    assertEquals(10.0f, calc.evaluate("5 5 +"));
  }
  
}
