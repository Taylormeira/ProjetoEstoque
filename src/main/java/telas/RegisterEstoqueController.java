package telas;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import lombok.Getter;
import models.EstoqueModels;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.UUID;

public class RegisterEstoqueController extends PageController implements Initializable {
    @FXML
    private Button btnRegisterEstoqueGoOut;
    @FXML
    private Button btnRegisterSave;
    @FXML
    private TextField tfDescEstoque;
    @FXML
    private TextField tfLocation;
    @FXML
    private TextField tfCodEstoque;
    @Getter
    private EstoqueModels estoque = null;


    public void initialize(URL Location, ResourceBundle resources) {
        btnRegisterSave.setOnAction(event -> buttonSave());

        initButtonGoOut(btnRegisterEstoqueGoOut);
    }
    private void buttonSave(){
        estoque = new EstoqueModels();

        estoque.setCodEstoque(UUID.randomUUID());
        estoque.setDescEstoque(tfDescEstoque.getText());
        estoque.setLocation(tfLocation.getText());

        Message.sucesso("Estoque Salvo com sucesso!");

       //// TODO: 22/10/2023 Adicionar fechamento de Scena no após compilar os dados na tabela de estoque
    }
    public void loadEstoque(EstoqueModels estoque){
        tfCodEstoque.setText(String.valueOf(estoque.getCodEstoque()));
        tfDescEstoque.setText(estoque.getDescEstoque());
        tfLocation.setText(estoque.getLocation());
    }
}


