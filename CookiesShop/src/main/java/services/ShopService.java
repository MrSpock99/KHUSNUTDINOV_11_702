package services;

import models.Cart;
import models.Product;

import javax.servlet.http.Cookie;
import java.util.List;

public interface ShopService {
    List<Product> getProductList(Cart cart);

    Cart findByOwnerId(Long id);

    Cart buy(Long productId, Cookie[] cookies, LoginService loginService);

    Cart getUserCart(LoginService loginService, Cookie[] cookies);
}
