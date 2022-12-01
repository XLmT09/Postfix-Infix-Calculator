package calculator;

import java.util.EmptyStackException;

/**
 * This class evaluates infix {@code String} expressions.
 *
 * @author HIJI
 */
public class StandardCalc implements Calculator { 
  private OpStack opStack;
  private RevPolishCalc rpCalc;
  
  public StandardCalc() {
    opStack = new OpStack();
    rpCalc = new RevPolishCalc();
  }
  
  @Override
  public float evaluate(String expression) {
    // Split and store components of expression in an array
    String[] expressionParts = expression.split(" ");
    // Forming postfix expression
    String postfix = "";
    // loop through elements of an expression
    for (String part : expressionParts) {
      // check if string element is a number
      if (part.equals("+")) {
        opStack.push(Symbol.PLUS);
      } else if (part.equals("-")) {
        opStack.push(Symbol.MINUS);
      } else if (part.equals("*")) {
        opStack.push(Symbol.TIMES);
      }  else {
        postfix += part + " ";
      }
    }
    
    if (!opStack.isEmpty()) {
      postfix += opStack.pop().toString();
    }
    
    return rpCalc.evaluate(postfix);
  }
}
