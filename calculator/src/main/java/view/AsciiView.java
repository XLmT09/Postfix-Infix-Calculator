package view;

import calculator.Observer;
import enums.OpType;
import java.util.Scanner;
import java.util.function.Consumer;

/**
 * This class specifies what a View must be able to do. In particular it allows us to dynamically
 * set observers for view events.
 *
 * @author Dave, HIJI
 */
public class AsciiView implements ViewInterface {
  /**
   * The arithmetic expression that need to be resolved.
   */
  private String question;
  /**
   * The observer of the Calculate action.
   */
  Observer calc = null;
  /**
   * The observer of the "change type of calculation" event.
   */
  Consumer<OpType> changeType = null;

  /**
   * This is the main method of the class that keeps prompting for questions and notifies the
   * appropriate observers in order to print answers. The method returns when a Q is entered.
   */
  public void menu() {
    Scanner s = new Scanner(System.in);
    boolean finished = false;
    help();

    // The order of these checks is critical because hasNext blocks
    while (!finished && s.hasNext()) {
      String t = s.next();
      switch (t.charAt(0)) {
        case 'C':
        case 'c':
          if (calc != null) {
            calc.tell();
          }
          break;
        case 'I':
        case 'i':
          if (changeType != null) {
            System.out.println("Type changed to infix.");
            changeType.accept(OpType.INFIX);
          }
          break;
        case 'P':
        case 'p':
          if (changeType != null) {
            System.out.println("Type changed to postfix.");
            changeType.accept(OpType.POSTFIX);
          }
          break;
        case '?':
          question = s.nextLine();
          System.out.println("Question set to: " + question);
          break;
        case 'Q':
        case 'q':
          System.out.println("Bye");
          finished = true;
          break;
        default:
          help();
      }
    }
    s.close();
  }

  /**
   * A help text string.
   */
  private void help() {
    System.out.println("Use one of the following:");
    System.out.println("Expression - to set expression");
    System.out.println("P - to change to postfix");
    System.out.println("I - to change to infix");
    System.out.println("C - to calculate");
    System.out.println("Q - to exit");
  }

  /**
   * This allows a new observer to be added to the calculate action.
   *
   * @param f the Observer to be notified.
   */
  public void addCalcObserver(Observer f) {
    calc = f;
  }

  /**
   * This allows a new observer to be added to the change calculate strategy action.
   *
   * @param l the Observer to be notified.
   */
  public void addTypeObserver(Consumer<OpType> l) {
    changeType = l;
  }

  /**
   * A hook to expose the question to another class.
   *
   * @return the arithmetic expression to be evaluated.
   */
  public String getExpression() {
    return question;
  }

  /**
   * A hook to allow the answer to be displayed.
   *
   * @param a the evaluated answer.
   */
  public void setAnswer(String a) {
    System.out.println("Result: " + a);
  }
}
