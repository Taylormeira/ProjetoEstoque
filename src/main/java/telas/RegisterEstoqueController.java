package telas;

import controllers.EstoqueController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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
    private EstoqueModels estoqueModels = new EstoqueModels();


    public void initialize(URL Location, ResourceBundle resources) {
        btnRegisterSave.setOnAction(event -> buttonSave());

        initButtonGoOut(btnRegisterEstoqueGoOut);

        limitSize(tfDescEstoque, 100);
        limitSize(tfLocation, 100);
    }

    private void buttonSave() {
        try {
            estoqueModels.setDescEstoque(tfDescEstoque.getText());
            estoqueModels.setLocation(tfLocation.getText());

            if (estoqueModels.getCodEstoque() == null) {
                estoque.insert(estoqueModels);
            } else {
                estoque.alter(estoqueModels);
            }
            Message.sucesso("Estoque Salvo com sucesso!");
            closeStage(tfCodEstoque);
        } catch (Exception e) {
            Message.erro("erro ao criar o estoque", e);
        }
    }

    public void load(UUID codEstoque) throws SQLException {
        var optional = estoque.selectById(codEstoque);
        if (optional.isEmpty()) {
            Message.erro("Estoque selecionado não existe na tabela: " + codEstoque);
        } else {
            estoqueModels = optional.get();

            tfCodEstoque.setText(estoqueModels.getCodEstoque().toString());
            tfDescEstoque.setText(estoqueModels.getDescEstoque());
            tfLocation.setText(estoqueModels.getLocation());
        }
    }
}


