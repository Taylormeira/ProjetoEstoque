package telas;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class PrincipalPageController extends PageController implements Initializable {
    @FXML
    private Button btnEstoque;
    @FXML
    private Button btnGoOut;

    @Override
    public void initialize(URL Location, ResourceBundle resources) {
        btnEstoque.setOnAction(event -> actionOpenEstoque());
        initButtonGoOut(btnGoOut);
    }

    private void actionOpenEstoque() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/telas/Estoque.fxml"));

            Stage load = new Stage();
            load.setScene(new Scene(loader.load()));
            load.showAndWait();

        } catch (Exception e) {
            Message.erro("Erro ao abrir a tela de Estoque", e);
        }
    }
}
