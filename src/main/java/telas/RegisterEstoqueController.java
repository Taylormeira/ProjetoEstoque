package telas;

import controllers.EstoqueController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import lombok.Getter;
import models.EstoqueModels;

import java.net.URL;
import java.sql.SQLException;
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
    private EstoqueController estoque = new EstoqueController();


    public void initialize(URL Location, ResourceBundle resources) {
        btnRegisterSave.setOnAction(event -> buttonSave());

        initButtonGoOut(btnRegisterEstoqueGoOut);

        limitSize(tfDescEstoque,100);
        limitSize(tfLocation,100);
    }
    private void buttonSave(){
        try {
            estoque.createEstoque(tfDescEstoque.getText(),tfLocation.getText());

            Message.sucesso("Estoque Salvo com sucesso!");
        } catch (Exception e) {
            Message.erro("erro ao criar o estoque", e);
        }


       //// TODO: 22/10/2023 Adicionar fechamento de Scena no após compilar os dados na tabela de estoque
    }
    public void loadEstoque(EstoqueModels estoque){
        tfCodEstoque.setText(String.valueOf(estoque.getCodEstoque()));
        tfDescEstoque.setText(estoque.getDescEstoque());
        tfLocation.setText(estoque.getLocation());
    }
}


