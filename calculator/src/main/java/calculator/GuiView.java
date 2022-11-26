package calculator;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * This is the JavaFX View that is filled by the FXML loader at runtime.
 *
 * @author HIJI, Dave
 */
public class GuiView implements ViewInterface {

  /**
   * This allows a new observer to be added to the change calculate strategy action.
   *
   * @param observer The Observer to be notified.
   */
  public void addCalcObserver(Observer observer) {
    submit.setOnAction(new EventHandler<ActionEvent>() {

      @Override
      public void handle(ActionEvent event) {
        observer.tell();
      }
    });
  }

  /**
   * A hook to expose the question to another class.
   *
   * @return the arithmetic expression to be evaluated.
   */
  public String getExpression() {
    return input.getText();
  }

  /**
   * A hook to allow the answer to be displayed.
   *
   * @param result the evaluated answer.
   */
  public void setAnswer(String result) {
    answer.setText(result);
  }
  
  /**
   * The text object which displays the answer on the screen.
   */
  @FXML
  //fx:id="answer"
  private Text answer; // Value injected by FXMLLoader

  /**
   * The field which allows users to input expression in the application.
   */
  //fx:id="input"
  @FXML
  private TextField input; // Value injected by FXMLLoader

  /**
   * The submit button on the application.
   */
  //fx:id="submit"
  @FXML
  private Button submit; // Value injected by FXMLLoader
}
