package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import models.User;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import repositories.AuthRepository;
import repositories.AuthRepositoryJdbcTemplateImpl;
import repositories.UsersRepository;
import repositories.UsersRepositoryJdbcImpl;
import services.LoginService;
import services.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

@WebServlet("/mainPage.json")
public class JsonDataServlet extends HttpServlet {

    private ObjectMapper mapper = new ObjectMapper();

    private LoginService loginService;
    private AuthRepository authRepository;

    @Override
    @SneakyThrows
    public void init() throws ServletException {
        Properties properties = new Properties();
        properties.load(new FileReader("C:\\Users\\khusn\\Desktop\\University\\KHUSNUTDINOV_11_702\\BatmanDataBase\\src\\main\\resources\\ru.itis\\application.properties"));

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUsername(properties.getProperty("db.user"));
        dataSource.setPassword(properties.getProperty("db.password"));
        dataSource.setUrl(properties.getProperty("db.url"));
        UsersRepository usersRepository = new UsersRepositoryJdbcImpl(dataSource);
        authRepository = new AuthRepositoryJdbcTemplateImpl(dataSource);
        loginService = new LoginServiceImpl(usersRepository, authRepository);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();

        if (cookies == null) {
            cookies = new Cookie[0];
        }

        User user = null;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("AuthFilter")) {
                if (loginService.isExistByCookie(cookie.getValue())) {
                    user = loginService.getUserByCookie(cookie.getValue());
                    break;
                }
            }
        }

        String resultJson = mapper.writeValueAsString(user.getName());

        resp.setStatus(200);
        resp.setContentType("application/json");
        PrintWriter writer = resp.getWriter();
        writer.write(resultJson);
    }
}

