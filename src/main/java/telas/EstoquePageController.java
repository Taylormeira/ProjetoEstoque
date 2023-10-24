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
import models.EstoqueModels;

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

        initButtonGoOut(btnEstoqueGoOut);

        colCodEstoque.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getCodEstoque().toString().substring(0, 8)));
        colDescEstoque.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getDescEstoque()));
        colLocation.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getLocation()));

        loadDataInformartion();
    }

    public void loadDataInformartion() {
        try {
            tbEstoques.getItems().clear();
            tbEstoques.getItems().addAll(estoqueController.selectAll());
        } catch (Exception e) {
            Message.erro("erro ao carregar dados", e);
        }
    }

    public void buttonAdd() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(("/telas/RegisterEstoque.fxml")));

            Stage load = new Stage();
            load.setScene(new Scene(loader.load()));

            load.setTitle("cadastrar Estoque");

            load.showAndWait();

            loadDataInformartion();

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
                registerEstoqueController.load(tbEstoques.getItems().get(index).getCodEstoque());

                load.showAndWait();
                loadDataInformartion();

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
}
