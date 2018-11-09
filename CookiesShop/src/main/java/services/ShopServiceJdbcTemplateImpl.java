package services;

import models.Cart;
import models.Product;
import models.User;
import repositories.CartRepository;
import repositories.ProductRepository;

import javax.servlet.http.Cookie;
import java.util.ArrayList;
import java.util.List;

public class ShopServiceJdbcTemplateImpl implements ShopService {
    private CartRepository cartRepository;
    private ProductRepository productRepository;

    public ShopServiceJdbcTemplateImpl(CartRepository cartRepository, ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getProductList(Cart cart) {

        return null;
    }

    @Override
    public Cart findByOwnerId(Long ownerId) {
        Cart cart = cartRepository.findByOwnerId(ownerId);
        cart.getProductList().addAll(getProductList(cart));
        return cart;
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

        if (cart == null) {
            cart = new Cart(1L, cartOwner, new ArrayList<>());
            cart.add(product);
            cartRepository.save(cart);
        } else {
            cart.add(product);
            cartRepository.addProduct(cart);
        }
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
            cart = new Cart(1L, cartOwner, new ArrayList<>());
            cartRepository.save(cart);
        }
        return cart;
    }

}
