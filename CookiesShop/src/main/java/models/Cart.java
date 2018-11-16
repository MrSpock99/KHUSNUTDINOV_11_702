package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class Cart {
    private Long id;
    private User owner;
    private List<Product> productList = new ArrayList<>();

    public void add(Product product) {
        productList.add(product);
    }
}
