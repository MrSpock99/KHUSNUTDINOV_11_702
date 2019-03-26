package ru.itis.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import ru.itis.models.User;
import ru.itis.repositories.AuthRepository;
import ru.itis.repositories.AuthRepositoryJdbcTemplateImpl;
import ru.itis.repositories.UsersRepository;
import ru.itis.repositories.UsersRepositoryJdbcImpl;
import ru.itis.services.LoginService;
import ru.itis.services.LoginServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/mainPage.json")
public class JsonDataServlet extends HttpServlet {

    private ObjectMapper mapper = new ObjectMapper();

    private LoginService loginService;
    private AuthRepository authRepository;

    @Override
    @SneakyThrows
    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        DataSource dataSource = (DataSource) context.getAttribute("dataSource");

        UsersRepository usersRepository = new UsersRepositoryJdbcImpl();
        authRepository = new AuthRepositoryJdbcTemplateImpl();
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

