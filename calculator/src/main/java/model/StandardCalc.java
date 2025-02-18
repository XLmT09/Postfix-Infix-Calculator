package model;

import enums.Symbol;
import exceptions.InvalidExpressionException;
import stack.OpStack;

/**
 * This class evaluates infix {@code String} expressions.
 *
 * @author HIJI
 */
public class StandardCalc implements Calculator {
  private OpStack opStack;
  private RevPolishCalc rpCalc;

  /**
   * Initialises an empty {@link stack.OpStack OpStack} and creates a
   * {@link calculator.RevPolishClac RevPolishCalc} object.
   */
  public StandardCalc() {
    opStack = new OpStack();
    rpCalc = new RevPolishCalc();
  }

  // Check which operator has the greatest priority.
  private int precedence(String operation) {
    switch (operation) {
      case "/":
        return 4;
      case "*":
        return 3;
      case "+":
        return 2;
      case "-":
        return 1;
      default:
        return 0;
    }
  }

  private void push(String sym) {
    switch (sym) {
      case "/":
        opStack.push(Symbol.DIVIDE);
        break;
      case "*":
        opStack.push(Symbol.TIMES);
        break;
      case "+":
        opStack.push(Symbol.PLUS);
        break;
      case "-":
        opStack.push(Symbol.MINUS);
        break;
      case "(":
        opStack.push(Symbol.LEFT_BRACKET);
        break;
      default:
        throw new InvalidExpressionException("Expression contains an invalid operator");
    }
  }

  /**
   * Returns a solution for infix notation expressions.
   *
   * @param expression The {@code String} to be evaluated
   * @return The solution for the expression
   */
  @Override
  public String evaluate(String expression) {
    // Split and store components of expression in an array
    String[] expressionParts = expression.split("\\s+");
    // This regular expression checks if a string is an integer or decimal
    String regex = "[-]*[0-9]+[\\.]?[0-9]*";
    // checj if previous part was a number
    boolean prevNumber = false;
    // Forming postfix expression
    String postfix = "";
    
    // loop through elements of an expression
    for (String part : expressionParts) {
      // check if string element is a number
      if (part.matches(regex)) {
        if (prevNumber) {
          throw new InvalidExpressionException("Invalid infix expression");
        }
        postfix += part + " ";
        prevNumber = true;
      } else if (part.equals("(")) {
        push(part);
        prevNumber = false;
      } else if (part.equals(")")) {
        // If there is a close bracket, then keep popping operators until open bracket is found.
        while (!opStack.isEmpty() && !(opStack.peek().equals("("))) {
          postfix += opStack.pop().toString() + " ";
        }
        opStack.pop();
        prevNumber = false;
      } else {
        //Keep popping if top operator on stack has a greater priority.
        while (!opStack.isEmpty() && (precedence(part) <= precedence(opStack.peek()))) {
          postfix += opStack.pop().toString() + " ";
        }
        push(part);
        prevNumber = false;
      }
    }

    //pop any left over operators.
    while (!opStack.isEmpty()) {
      postfix += opStack.pop().toString() + " ";
    }

    //postfix string has been created, so now just needs to be evaluated.
    try {
      return rpCalc.evaluate(postfix);
    } catch (InvalidExpressionException e) {
      throw new InvalidExpressionException("Invalid infix expression");
    }

  }
}
