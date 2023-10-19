package models;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ProductModels {
    private UUID codProduct;
    private String descProduct;
    private int quantity;
    private Float value;

}
