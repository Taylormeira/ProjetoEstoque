package telas;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PageController {
    public void initButtonGoOut(Button button) {
        button.setOnAction(event -> {
            Stage stage = (Stage) button.getScene().getWindow();
            stage.close();
        });
    }

    public void limitSize(TextField textField, int maxLength) {
    textField.textProperty().addListener(new ChangeListener<String>() {
        @Override
        public void changed (ObservableValue< ? extends String > observable, String oldValue, String newValue){
            if (newValue.length() > maxLength) {
                textField.setText(oldValue);
            }
        }
    });
}
}
