package services;

import models.Cart;
import models.Product;

import javax.servlet.http.Cookie;
import java.util.List;

public interface ShopService {
    Cart buy(Long productId, Cookie[] cookies, LoginService loginService);

    Cart deleteFromCart(Long productId,Cookie[] cookies, LoginService loginService);

    Cart getUserCart(LoginService loginService, Cookie[] cookies);
}
