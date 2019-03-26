package ru.itis.servlets;

import lombok.SneakyThrows;
import ru.itis.forms.UserForm;
import ru.itis.repositories.AuthRepository;
import ru.itis.repositories.AuthRepositoryJdbcTemplateImpl;
import ru.itis.repositories.UsersRepository;
import ru.itis.repositories.UsersRepositoryJdbcImpl;
import ru.itis.services.LoginServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.Optional;

public class SignUpServlet extends HttpServlet {

    private LoginServiceImpl loginService;

    @SneakyThrows
    @Override
    public void init(ServletConfig config) {
        ServletContext context = config.getServletContext();
        DataSource dataSource = (DataSource) context.getAttribute("dataSource");

        UsersRepository usersRepository = new UsersRepositoryJdbcImpl();
        AuthRepository authRepository = new AuthRepositoryJdbcTemplateImpl();
        loginService = new LoginServiceImpl(usersRepository, authRepository);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //req.getRequestDispatcher("/ftl/signUp.jsp").forward(req, resp);
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
    }
}
