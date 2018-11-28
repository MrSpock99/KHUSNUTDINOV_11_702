package servlets;

import forms.UserForm;
import lombok.SneakyThrows;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import repositories.AuthRepository;
import repositories.AuthRepositoryJdbcTemplateImpl;
import repositories.UsersRepository;
import repositories.UsersRepositoryJdbcImpl;
import services.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

/**
 * 12.10.2018
 * SignUpServlet
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class SignUpServlet extends HttpServlet {

    private LoginServiceImpl loginService;

    @SneakyThrows
    @Override
    public void init() {
//        Class.forName("org.postgresql.Driver");
//        Properties properties = new Properties();
//        properties.load(new FileReader("C:\\Users\\khusn\\Desktop\\University\\KHUSNUTDINOV_11_702\\BatmanDataBase\\src\\main\\resources\\ru.itis\\application.properties"));
//        Connection connection =
//                DriverManager.getConnection(properties.getProperty("db.url"),
//                        properties.getProperty("db.user"),
//                        properties.getProperty("db.password"));
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUsername("postgres");
        dataSource.setPassword("Metallica1981");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/batman_db");

        UsersRepository usersRepository = new UsersRepositoryJdbcImpl(dataSource);
        AuthRepository authRepository = new AuthRepositoryJdbcTemplateImpl(dataSource);
        loginService = new LoginServiceImpl(usersRepository, authRepository);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/signUp.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        UserForm userForm;
        userForm = UserForm.builder()
                .email(req.getParameter("email"))
                .password(req.getParameter("password"))
                .build();

        Optional<String> optionalCookieValue = loginService.signIn(userForm);

        if (optionalCookieValue.isPresent()) {
            Cookie cookie = new Cookie("AuthFilter", optionalCookieValue.get());
            resp.addCookie(cookie);
            resp.setStatus(201);
            resp.sendRedirect("/mainPage");
            return;
        } else {
            if (req.getParameter("name") != null) {
                userForm.setName(req.getParameter("name"));
                loginService.signUp(userForm);
                resp.sendRedirect("/signUp");
            } else {
                resp.setStatus(403);
            }
        }
/*
        if (req.getParameter("name") == null) {
            userForm = UserForm.builder()
                    .email(req.getParameter("email"))
                    .password(req.getParameter("password"))
                    .build();
            if (loginService.registered(userForm)) {
                loginService.signIn(userForm);
                resp.sendRedirect("/mainPage");
                return;
            }
        } else {
            userForm = UserForm.builder()
                    .name(req.getParameter("name"))
                    .email(req.getParameter("email"))
                    .password(req.getParameter("password"))
                    .build();
            loginService.signUp(userForm);
            resp.sendRedirect("/signUp");
        }*/
    }
}
