package Telas;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PrincipalPageController implements Initializable {
    @FXML
    private Button btnEstoque;

    @Override
    public void initialize(URL Location, ResourceBundle resources){
        btnEstoque.setOnAction(event -> botaoEstoque());
    }
    private void botaoEstoque(){
        System.out.println("teste");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/telas/Estoque.fxml"));

            Stage load = new Stage();
            load.setScene(new Scene(loader.load()));
            load.showAndWait();

        }catch (Exception e){
            Mensagem.erro("Erro ao abrir a tela de Estoque", e);
        }
    }

}
