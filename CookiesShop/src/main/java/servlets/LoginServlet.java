package servlets;

import forms.LoginForm;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import repositories.AuthRepository;
import repositories.AuthRepositoryJdbcTemplateImpl;
import repositories.UsersRepository;
import repositories.UsersRepositoryJdbcTemplateImpl;
import services.LoginService;
import services.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private LoginService service;

    @Override
    public void init() throws ServletException {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUsername("postgres");
        dataSource.setPassword("Metallica1981");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/cookie_shop_db");
        UsersRepository usersRepository = new UsersRepositoryJdbcTemplateImpl(dataSource);
        AuthRepository authRepository = new AuthRepositoryJdbcTemplateImpl(dataSource);
        this.service = new LoginServiceImpl(authRepository, usersRepository);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("jsp/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");

        LoginForm loginForm = LoginForm.builder()
                .email(name)
                .password(password)
                .build();

        Optional<String> optionalCookieValue = service.login(loginForm);

        if (optionalCookieValue.isPresent()) {
            Cookie cookie = new Cookie("AuthFilter", optionalCookieValue.get());
            resp.addCookie(cookie);
            resp.setStatus(201);
            resp.sendRedirect("/goods");
        } else {
            resp.setStatus(403);
        }
    }
}
