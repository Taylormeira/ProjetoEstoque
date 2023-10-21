package controllers;

import models.EstoqueModels;

import java.util.List;
import java.util.UUID;

public class EstoqueController {
    public void createEstoque(UUID codEstoque, String descEstoque, String location) {
        System.out.println("criar Estoque");
    }

    public void alterEstoque() {
        System.out.println("Estoque alteradp");
    }

    public void deleteEstoque() {
        System.out.println("Estoque Deletado");
    }

    public void viewEstoque() {
        System.out.println("Visualiza o estoque");
    }

    public List<EstoqueModels> loadEstoque() {
        return List.of(
                EstoqueModels.mock(),
                EstoqueModels.mock(),
                EstoqueModels.mock(),
                EstoqueModels.mock(),
                EstoqueModels.mock(),
                EstoqueModels.mock()
        );
    }
}
