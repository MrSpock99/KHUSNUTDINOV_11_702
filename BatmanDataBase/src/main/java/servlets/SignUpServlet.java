package servlets;

import forms.UserForm;
import lombok.SneakyThrows;
import repositories.UsersRepository;
import repositories.UsersRepositoryJdbcImpl;
import services.UserServiceImpl;
import services.UsersService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * 12.10.2018
 * SignUpServlet
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class SignUpServlet extends HttpServlet {

    private UsersService usersService;

    @SneakyThrows
    @Override
    public void init() {
        Class.forName("org.postgresql.Driver");
        Properties properties = new Properties();
        properties.load(new FileReader("C:\\Users\\khusn\\Desktop\\University\\KHUSNUTDINOV_11_702\\BatmanDataBase\\src\\main\\resources\\ru.itis\\application.properties"));
        Connection connection =
                DriverManager.getConnection(properties.getProperty("db.url"),
                        properties.getProperty("db.user"),
                        properties.getProperty("db.password"));
        UsersRepository usersRepository = new UsersRepositoryJdbcImpl(connection);
        usersService = new UserServiceImpl(usersRepository);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/signUp.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        UserForm userForm;
        if (req.getParameter("name") == null) {
            userForm = UserForm.builder()
                    .email(req.getParameter("email"))
                    .password(req.getParameter("password"))
                    .build();
            if (usersService.registered(userForm)) {
                usersService.signIn(userForm);
                resp.sendRedirect("/mainPage");
                return;
            }
        } else {
            userForm = UserForm.builder()
                    .name(req.getParameter("name"))
                    .email(req.getParameter("email"))
                    .password(req.getParameter("password"))
                    .build();
            usersService.signUp(userForm);
            resp.sendRedirect("/signUp");
        }
    }
}
