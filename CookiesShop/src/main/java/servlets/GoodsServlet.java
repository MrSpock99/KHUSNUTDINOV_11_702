package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.Cart;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import repositories.*;
import services.ShopService;
import services.LoginService;
import services.LoginServiceImpl;
import services.ShopServiceJdbcTemplateImpl;
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
        shopService = new ShopServiceJdbcTemplateImpl(cartRepository,productRepository);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();

        if (cookies == null) {
            cookies = new Cookie[0];
        }

        Cart cart = shopService.getUserCart(loginService,cookies);
        String resultJson = mapper.writeValueAsString(cart.getProductList());

        resp.setStatus(202);
        resp.setContentType("application/json");
        PrintWriter writer = resp.getWriter();
        writer.write(resultJson);

        req.getRequestDispatcher("/jsp/goods.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // достаешь id продукта
        // достаешь куку пользователя
        // добавляешь этот продукт в корзину этого пользователя
        // достаешь все продукты из этой корзины
        // отправляешь клиенту джейсон

        Long productId = Long.valueOf(req.getParameter("product_id"));

        Cookie[] cookies = req.getCookies();

        if (cookies == null) {
            cookies = new Cookie[0];
        }

        Cart cart = shopService.buy(productId, cookies, loginService);

        String resultJson = mapper.writeValueAsString(cart.getProductList());

        resp.setStatus(200);
        resp.setContentType("application/json");
        PrintWriter writer = resp.getWriter();
        writer.write(resultJson);
    }
}
