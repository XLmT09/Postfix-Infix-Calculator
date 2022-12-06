package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import exceptions.InvalidExpressionException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Random;
import model.RevPolishCalc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestRevPolishCalc {
  private RevPolishCalc calc;
  // random numbers which will be used for test expressions.
  private Random rand;
  // This string will be used to build large expressions for my test cases.
  private String testExpression;
  private BigDecimal sum;

  @BeforeEach
  void setUp() {
    calc = new RevPolishCalc();
    rand = new Random();
    testExpression = "";
    sum = new BigDecimal(0);
  }

  @Test
  void testBasicAddition() {
    assertEquals(BigDecimal.valueOf(2), calc.evaluate("1 1 +"));
    assertEquals(BigDecimal.valueOf(3), calc.evaluate("1 2 +"));
    assertEquals(BigDecimal.valueOf(2), calc.evaluate(" 1 1 +"));
  }

  @Test
  void testTenThousandRandomNumbersAddtion() {
    // Will hold the randomly generated number in every loop
    int intRandom = 0;
    // The highest number intRandom can hold
    int randLimit = 1000;

    // set up beginning expression
    intRandom = rand.nextInt(randLimit);
    sum = sum.add(BigDecimal.valueOf(intRandom));
    testExpression += intRandom;
    intRandom = rand.nextInt(randLimit);
    sum = sum.add(BigDecimal.valueOf(intRandom));
    testExpression += " " + intRandom + " + ";

    // Adds random number to sum and updates string expression every loop
    for (int i = 0; i < 10000; i++) {
      intRandom = rand.nextInt(randLimit);
      sum = sum.add(BigDecimal.valueOf(intRandom));
      testExpression += intRandom + " + ";
    }

    assertEquals(sum, calc.evaluate(testExpression),
        "Evaluate should return the same value as sum,"
            + " because sum had kept track of the additions.");
  }

  @Test
  void testBasicSubtraction() {
    assertEquals(BigDecimal.valueOf(-1), calc.evaluate("1 2 -"),
        "It should pop the first value and be subtracted by the second popped value.");
  }

  @Test
  void testTenThousandRandomNumbersSubtraction() {
    // Will hold the randomly generated number in every loop
    int intRandom = 0;
    // The highest number intRandom can hold
    int randLimit = 1000;

    // set up beginning expression
    intRandom = rand.nextInt(randLimit);
    // Only first number will be added to sum
    sum = sum.add(BigDecimal.valueOf(intRandom));
    testExpression += intRandom;
    intRandom = rand.nextInt(randLimit);
    sum = sum.subtract(BigDecimal.valueOf(intRandom));
    testExpression += " " + intRandom + " - ";

    // subtracts random number to sum and updates string expression every loop
    for (int i = 0; i <= 10000; i++) {
      intRandom = rand.nextInt(randLimit);
      sum = sum.subtract(BigDecimal.valueOf(intRandom));
      testExpression += intRandom + " - ";
    }

    assertEquals(sum, calc.evaluate(testExpression),
        "Evaluate should return the same value as sum,"
            + " because sum had kept track of the subtractions.");
  }

  @Test
  void testBasicMultiplication() {
    assertEquals(BigDecimal.valueOf(12), calc.evaluate("6 2 *"),
        "It should pop the first value and be multiplied by the second popped value.");
  }

  @Test
  void testTwentyRandomNumbersMultiplication() {
    // Will hold the randomly generated number in every loop
    int intRandom = 0;
    // The highest number intRandom can hold
    int randLimit = 10;
    // Lowest number intRandom can hold, to prevent zero multiplication
    int minLimit = 1;

    // set up beginning expression
    intRandom = rand.nextInt(randLimit + 1 - minLimit) + minLimit;
    // Only first number will be added to sum
    sum = sum.add(BigDecimal.valueOf(intRandom));
    testExpression += intRandom;
    intRandom = rand.nextInt(randLimit + 1 - minLimit) + minLimit;
    sum = sum.multiply(BigDecimal.valueOf(intRandom));
    testExpression += " " + intRandom + " * ";

    // multiplies random number to sum and updates string expression every loop
    for (int i = 0; i <= 20; i++) {
      intRandom = rand.nextInt(randLimit + 1 - minLimit) + minLimit;
      sum = sum.multiply(BigDecimal.valueOf(intRandom));
      testExpression += intRandom + " * ";
    }

    assertEquals(sum, calc.evaluate(testExpression),
        "Evaluate should return the same value as sum,"
            + " because sum had kept track of the multplication.");
  }

  @Test
  void testBasicDivision() {
    assertEquals(BigDecimal.valueOf(2), calc.evaluate("6 3 /"),
        "It should pop the first value and be divided by the second popped value.");
  }

  @Test
  void testTwentyRandomNumbersDivsion() {
    // Will hold the randomly generated number in every loop
    int intRandom = 0;
    // The highest number intRandom can hold
    int randLimit = 10;
    // Lowest number intRandom can hold, to prevent zero division
    int minLimit = 1;
    
    // set up beginning expression
    intRandom = rand.nextInt(randLimit + 1 - minLimit) + minLimit;
    // Only first number will be added to sum
    sum = sum.add(BigDecimal.valueOf(intRandom));
    testExpression += intRandom;
    intRandom = rand.nextInt(randLimit + 1 - minLimit) + minLimit;
    sum = sum.divide(BigDecimal.valueOf(intRandom), MathContext.DECIMAL32);
    testExpression += " " + intRandom + " / ";

    // Divides random number to sum and updates string expression every loop
    for (int i = 0; i <= 20; i++) {
      intRandom = rand.nextInt(randLimit + 1 - minLimit) + minLimit;
      sum = sum.divide(BigDecimal.valueOf(intRandom), MathContext.DECIMAL32);
      testExpression += intRandom + " / ";
    }

    assertEquals(sum, calc.evaluate(testExpression),
        "Evaluate should return the same value as sum,"
            + " because sum had kept track of the Division.");
  }

  @Test
  void testOperationOnNegativeNumbers() {
    assertEquals(BigDecimal.valueOf(-5), calc.evaluate("-5 1 /"));
    assertEquals(BigDecimal.valueOf(-10), calc.evaluate("-20 10 +"));
  }

  @Test
  void testTwoDifferentOperations() {
    assertEquals(BigDecimal.valueOf(-14), calc.evaluate("-5 1 + 10 -"));
  }

  @Test
  void testTwoOperationsInRow() {
    assertEquals(BigDecimal.valueOf(-16), calc.evaluate("-5 1 10 + -"));
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
    assertEquals(BigDecimal.valueOf(10), calc.evaluate("5 5 +"));
  }

}
