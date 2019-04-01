package ru.itis.filter;

import org.springframework.beans.factory.annotation.Autowired;
import ru.itis.models.User;
import ru.itis.services.LoginService;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/*
@WebFilter("/mainPage")*/
public class AuthFilter implements Filter {

    @Autowired
    private LoginService loginService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        Cookie[] cookies = request.getCookies();

        boolean exists = false;

        if (cookies == null) {
            cookies = new Cookie[0];
        }

        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("AuthFilter")) {
                if (!loginService.isExistByCookie(cookie.getValue())) {
                    User user = loginService.getUserByCookie(cookie.getValue());
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
