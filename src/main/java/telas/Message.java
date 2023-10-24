package telas;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class Message {
    private Message() {
    }

    public static void erro(String mensagem, Exception ex) {
        ex.printStackTrace();

        Alert alert = new Alert(Alert.AlertType.ERROR, ex.getMessage(), ButtonType.YES);
        alert.setTitle("Erro");
        alert.setHeaderText(mensagem);
        alert.showAndWait();
    }

    public static void erro(String mensagem) {

        Alert alert = new Alert(Alert.AlertType.ERROR, "Erro", ButtonType.YES);
        alert.setTitle("Erro");
        alert.setHeaderText(mensagem);
        alert.showAndWait();
    }

    public static void sucesso(String mensagem) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, mensagem, ButtonType.YES);
        alert.setTitle("Sucesso");
        alert.setHeaderText("Sucesso ao salvar!");
        alert.showAndWait();
    }

}
