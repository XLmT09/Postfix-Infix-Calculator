package view;

import controller.Observer;
import enums.OpType;
import java.util.function.Consumer;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
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
   * This allows a new observer to be added to the change calculate strategy action.
   *
   * @param l the Observer to be notified.
   */
  public void addTypeObserver(Consumer<OpType> l) {
    calcType.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
      @Override
      public void changed(ObservableValue<? extends Toggle> observable, Toggle from, Toggle to) {
        l.accept(to == infixButton ? OpType.INFIX : OpType.POSTFIX);
      }
    });
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
  
  /**
   * The polish radio button on the application.
   */
  //fx:id="polishButton"
  @FXML
  private RadioButton polishButton;
  
  /**
   * The infix radio button on the application.
   */
  //fx:id="infixButton"
  @FXML
  private RadioButton infixButton;
  
  /**
   * The object that links the two radio buttons.
   */
  //fx:id="calcType"
  @FXML
  private ToggleGroup calcType;
}
