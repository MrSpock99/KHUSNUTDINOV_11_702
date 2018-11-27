package services;

import models.Cart;
import models.Product;
import models.User;
import repositories.CartRepository;
import repositories.ProductRepository;

import javax.servlet.http.Cookie;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private CartRepository cartRepository;
    private ProductRepository productRepository;

    public ShopServiceImpl(CartRepository cartRepository, ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }


    @Override
    public Cart buy(Long productId, Cookie[] cookies, LoginService loginService) {
        Product product = productRepository.find(productId);

        User cartOwner = null;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("AuthFilter")) {
                if (loginService.isExistByCookie(cookie.getValue())) {
                    cartOwner = loginService.getUserByCookie(cookie.getValue());
                    break;
                }
            }
        }
        Cart cart = cartRepository.findByOwnerId(cartOwner.getId());

        if (product == null){
            return cart;
        }

        if (cart == null) {
            cart = new Cart(1L, cartOwner, new HashMap<>());
            cart.add(product);
            cartRepository.save(cart);
        } else {
            cart.add(product);
            cartRepository.addProduct(cart,product);
        }
        return cart;
    }

    @Override
    public Cart deleteFromCart(Long productId,Cookie[] cookies, LoginService loginService) {
        Product product = productRepository.find(productId);

        User cartOwner = null;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("AuthFilter")) {
                if (loginService.isExistByCookie(cookie.getValue())) {
                    cartOwner = loginService.getUserByCookie(cookie.getValue());
                    break;
                }
            }
        }
        Cart cart = cartRepository.findByOwnerId(cartOwner.getId());

        cartRepository.deleteProductFromCart(cart,product);
        cart.deleteProduct(product);

        return cart;
    }

    @Override
    public Cart getUserCart(LoginService loginService, Cookie[] cookies) {
        User cartOwner = null;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("AuthFilter")) {
                if (loginService.isExistByCookie(cookie.getValue())) {
                    cartOwner = loginService.getUserByCookie(cookie.getValue());
                    break;
                }
            }
        }
        Cart cart = cartRepository.findByOwnerId(cartOwner.getId());

        if (cart == null) {
            cart = new Cart(1L, cartOwner, new HashMap<>());
            cartRepository.save(cart);
        }
        return cart;
    }
}
