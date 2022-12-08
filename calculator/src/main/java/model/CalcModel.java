package model;

import enums.OpType;

/**
 * A state class which switches between postfix and infix.
 *
 * @author HIJI
 */
public class CalcModel {
  //The state that will be tracked
  private Calculator currentState;
  //Possible states for the calculator
  private Calculator scalc;
  private Calculator rcalc;
  
  /**
   * Initially sets the current state of the model to {@link model.RevPolishCalc
   * RevPolishCalc}.
   */
  public CalcModel() {
    scalc = new StandardCalc();
    rcalc = new RevPolishCalc();
    currentState = rcalc;
  }
  
  /**
   * Change calculator to either infix or postfix.
   *
   * @param type The mode calculator should be in 
   */
  public void setState(OpType type) {
    //Check if state should be in infix mode
    if (type == OpType.INFIX) {
      currentState = scalc;
    } else {
      currentState = rcalc;
    }
  }
  
  /**
   * Evaluates user expression either in infix or postfix.
   */
  public String evaluate(String expression) {
    return currentState.evaluate(expression);
  }
}
