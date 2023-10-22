package telas;

import controllers.EstoqueController;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import lombok.Getter;
import models.EstoqueModels;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EstoquePageController extends PageController implements Initializable {
    @FXML
    private Button btnEstoqueGoOut;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnAlter;
    @FXML
    private Button btnDelete;
    @FXML
    private Button btnDeploy;
    @FXML
    private TableView<EstoqueModels> tbEstoques;
    @FXML
    private TableColumn<EstoqueModels, String> colCodEstoque;
    @FXML
    private TableColumn<EstoqueModels, String> colDescEstoque;
    @FXML
    private TableColumn<EstoqueModels, String> colLocation;


    private EstoqueController estoqueController = new EstoqueController();

    @Override
    public void initialize(URL Location, ResourceBundle resources) {
        btnAdd.setOnAction(event -> buttonAdd());
        btnAlter.setOnAction(event -> buttonAlter());
        btnDelete.setOnAction(event -> buttonDelete());
        btnDeploy.setOnAction(event -> buttonDeploy());

        initButtonGoOut(btnEstoqueGoOut);

        colCodEstoque.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getCodEstoque().toString().substring(0, 8)));
        colDescEstoque.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getDescEstoque()));
        colLocation.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getLocation()));

        loadSheet();
    }

    public void loadSheet() {
        try {
            tbEstoques.getItems().clear();
            tbEstoques.getItems().addAll(estoqueController.loadEstoque());
        } catch (Exception e) {
            Message.erro("erro ao carregar planilha", e);
        }
    }

    public void buttonAdd() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(("/telas/RegisterEstoque.fxml")));

            Stage load = new Stage();
            load.setScene(new Scene(loader.load()));

            load.setTitle("cadastrar Estoque");

            load.showAndWait();

            RegisterEstoqueController registerEstoqueController = loader.getController();

            EstoqueModels estoqueModels = registerEstoqueController.getEstoque();

            if (estoqueModels != null) {
                tbEstoques.getItems().add(estoqueModels);
            }

        } catch (Exception e) {
            Message.erro("Erro ao adicionar estoque", e);
        }
    }

    public void buttonAlter() {
        int index = tbEstoques.getSelectionModel().getSelectedIndex();

        if (index >= 0) {
            try {

                FXMLLoader loader = new FXMLLoader(getClass().getResource(("/telas/RegisterEstoque.fxml")));

                Stage load = new Stage();
                load.setScene(new Scene(loader.load()));

                load.setTitle("Alterar Estoque");

                RegisterEstoqueController registerEstoqueController = loader.getController();
                registerEstoqueController.loadEstoque(tbEstoques.getItems().get(index));

                load.showAndWait();

                EstoqueModels estoqueModels = registerEstoqueController.getEstoque();

                if (estoqueModels != null) {
                    tbEstoques.getItems().set(index, estoqueModels);
                }
                Message.sucesso("Item Excluido");
                //// TODO: 22/10/2023 revissar o porque a mensagem de sucesso não está aparecendo

            } catch (Exception e) {
                Message.erro("Erro ao alterar o estoque", e);
            }
        }
    }

    public void buttonDelete() {
        int index = tbEstoques.getSelectionModel().getSelectedIndex();

        if (index >= 0) {
            tbEstoques.getItems().remove(index);
        }
    }

    public void buttonDeploy() {
        Message.sucesso("Deploy no Banco executado");

        //// TODO: 22/10/2023 realizar a comunicação com a base de dados para assim poder realizar o deploy dos dados.
    }
}
