package ru.itis.filter;

import ru.itis.models.User;
import ru.itis.repositories.AuthRepository;
import ru.itis.repositories.AuthRepositoryJdbcTemplateImpl;
import ru.itis.repositories.UsersRepository;
import ru.itis.repositories.UsersRepositoryJdbcImpl;
import ru.itis.services.LoginService;
import ru.itis.services.LoginServiceImpl;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;

//как сделать фильтр на несколько страниц?
/*
@WebFilter("/mainPage")
*/
public class AuthFilter implements Filter {

    private LoginService service;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        ServletContext context = filterConfig.getServletContext();
        DataSource dataSource = (DataSource) context.getAttribute("dataSource");

        UsersRepository usersRepository = new UsersRepositoryJdbcImpl();
        AuthRepository authRepository = new AuthRepositoryJdbcTemplateImpl();
        this.service = new LoginServiceImpl(usersRepository, authRepository);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        Cookie cookies[] = request.getCookies();

        boolean exists = false;

        if (cookies == null) {
            cookies = new Cookie[0];
        }

        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("AuthFilter")) {
                if (!service.isExistByCookie(cookie.getValue())) {
                    User user = service.getUserByCookie(cookie.getValue());
                    System.out.println(user.toString());
                    response.sendRedirect("/signUp");
                    return;
                } else {
                    exists = true;
                }
            }
        }
        if (!exists) {
            response.sendRedirect("/signUp");
        } else {
            chain.doFilter(request, response);
        }

    }

    @Override
    public void destroy() {

    }
}
