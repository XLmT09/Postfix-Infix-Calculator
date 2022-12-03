package calculator;

import java.util.function.Consumer;

/**
 * How we want to interact with our calculator. Just defines the data and provides hooks for
 * notification and insertion of observers.
 *
 * @author HIJI, Dave
 *
 */
public interface ViewInterface {
  /**
   * A hook to get the arithmetic expression to be evaluated.
   *
   * @return The expression the user inputs
   */
  public String getExpression();
  
  /**
   * A hook to show the user the evaluated answer.
   *
   * @param result The answer of the given expression 
   */
  public void setAnswer(String result);
  
  /**
   * Add an observer to detect when the submit action has been performed.
   *
   * @param observer The observer of the view
   */
  public void addCalcObserver(Observer observer);

  /**
   * Add an observer of the calculate mode change action.
   *
   * @param observer the observer
   */
  void addTypeObserver(Consumer<OpType> observer);
}
