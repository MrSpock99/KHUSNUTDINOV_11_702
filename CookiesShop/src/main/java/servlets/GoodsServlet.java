package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.Cart;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import repositories.*;
import services.ShopService;
import services.LoginService;
import services.LoginServiceImpl;
import services.ShopServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/goods")
public class GoodsServlet extends HttpServlet {
    private AuthRepository authRepository;
    private CartRepository cartRepository;
    private ProductRepository productRepository;
    private ObjectMapper mapper = new ObjectMapper();
    private LoginService loginService;
    private ShopService shopService;


    @Override
    public void init() throws ServletException {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUsername("postgres");
        dataSource.setPassword("Metallica1981");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/cookie_shop_db");
        UsersRepository usersRepository = new UsersRepositoryJdbcTemplateImpl(dataSource);
        authRepository = new AuthRepositoryJdbcTemplateImpl(dataSource);
        cartRepository = new CartRepositoryJdbcImpl(dataSource);
        productRepository = new ProductRepositoryJdbcTemplateImpl(dataSource);
        loginService = new LoginServiceImpl(authRepository, usersRepository);
        shopService = new ShopServiceImpl(cartRepository, productRepository);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/goods.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // достаешь id продукта
        // достаешь куку пользователя
        // добавляешь этот продукт в корзину этого пользователя
        // достаешь все продукты из этой корзины
        // отправляешь клиенту джейсон

        String productIdStr = (req.getParameter("product_id"));
        Long productId;

        if (productIdStr != null) {
            productId = Long.valueOf(productIdStr);
        } else {
            productId = null;
        }

        Cookie[] cookies = req.getCookies();

        if (cookies == null) {
            cookies = new Cookie[0];
        }

        Cart cart = null;
        switch (req.getParameter("action")){
            case "delete":
                cart = shopService.deleteFromCart(productId, cookies, loginService);
                break;
            case "buy":
                cart = shopService.buy(productId, cookies, loginService);
                break;
        }
        String resultJson = mapper.writeValueAsString(cart.getProductsCount());

        resp.setStatus(200);
        resp.setContentType("application/json");
        PrintWriter writer = resp.getWriter();
        writer.write(resultJson);
    }
}
