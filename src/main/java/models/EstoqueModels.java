package models;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
public class EstoqueModels {

    private UUID codEstoque;
    private String descEstoque;
    private String location;
}
