package telas;

import javafx.scene.control.Button;
import javafx.stage.Stage;

public class PageController {
    public void initButtonGoOut(Button button){
        button.setOnAction(event -> {
            Stage stage = (Stage) button.getScene().getWindow();
            stage.close();
        });
    }
}
