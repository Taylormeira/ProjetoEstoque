package models;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;
import java.util.UUID;

@Getter
@Setter
public class EstoqueModels {

    private UUID codEstoque;
    private String descEstoque;
    private String location;

    public static EstoqueModels mock() {
        var estoqueModel = new EstoqueModels();
        estoqueModel.setCodEstoque(UUID.randomUUID());
        estoqueModel.setDescEstoque("estoque Teste");
        estoqueModel.setLocation("Local Teste");
        return estoqueModel;
    }
}
