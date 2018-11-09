package repositories;

import models.Cart;
import models.Product;

import java.util.List;

public interface CartRepository extends CrudRepository<Cart>{
    Cart findByOwnerId(Long ownerId);
    List<Product> getProductList(Cart cart);
    void addProduct(Cart product);
}
