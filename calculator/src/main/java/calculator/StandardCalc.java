package calculator;

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
        return;
    }
  }

  @Override
  public float evaluate(String expression) {
    // Split and store components of expression in an array
    String[] expressionParts = expression.split(" ");
    // This regular expression checks if a string is an integer or decimal
    String regex = "[-]*[0-9]+[\\.]?[0-9]*";
    // Forming postfix expression
    String postfix = "";

    // loop through elements of an expression
    for (String part : expressionParts) {
      // check if string element is a number
      if (part.matches(regex)) {
        postfix += part + " ";
      } else if (part.equals("(")) {
        push(part);
      } else if (part.equals(")")) {
        while (!opStack.isEmpty() && !(opStack.peek().equals("("))) {
          postfix += opStack.pop().toString() + " ";
        }
        opStack.pop();
      } else {
        while (!opStack.isEmpty() && (precedence(part) <= precedence(opStack.peek()))) {
          postfix += opStack.pop().toString() + " ";
        }
        push(part);
      }
    }

    while (!opStack.isEmpty()) {
      postfix += opStack.pop().toString() + " ";
    }

    return rpCalc.evaluate(postfix);
  }
}
