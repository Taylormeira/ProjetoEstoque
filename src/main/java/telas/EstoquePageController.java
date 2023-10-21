package telas;

import controllers.EstoqueController;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import models.EstoqueModels;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.UUID;

public class EstoquePageController extends PageController implements Initializable {
    @FXML
    private Button btnEstoqueGoOut;
    @FXML
    private TableView<EstoqueModels> tbEstoques;
    @FXML
    private TableColumn<EstoqueModels, String> colCodEstoque;
    @FXML
    private TableColumn<EstoqueModels, String> colDescEstoque;
    @FXML
    private TableColumn<EstoqueModels, String> colLocation;

    private EstoqueController estoqueController = new EstoqueController();

    public void initialize(URL Location, ResourceBundle resources) {
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
            Mensagem.erro("erro ao carregar planilha", e);
        }
    }
}
