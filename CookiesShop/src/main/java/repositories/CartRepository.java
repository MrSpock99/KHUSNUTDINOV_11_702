package repositories;

import models.Cart;
import models.Product;

import java.util.List;
import java.util.Map;

public interface CartRepository extends CrudRepository<Cart>{
    Cart findByOwnerId(Long ownerId);
    List<Product> getProductList(Cart cart);
    void addProduct(Cart cart, Product product);
    void deleteProductFromCart(Cart cart, Product product);
    Map<Product,Integer> toMap(List<Product> productList);
}
