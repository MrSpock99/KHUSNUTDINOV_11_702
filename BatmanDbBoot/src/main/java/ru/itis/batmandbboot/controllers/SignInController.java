package ru.itis.batmandbboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.batmandbboot.forms.UserForm;
import ru.itis.batmandbboot.services.LoginService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Controller
public class SignInController {
    @Autowired
    private LoginService loginService;

    @GetMapping("/signIn")
    public String getSignInPage() {
        System.out.println("LOGIN!!!!!!!!!!!!!!! ");
        return "signIn";
    }

    @PostMapping("/signIn")
    public String signInUser(UserForm userForm, HttpServletResponse response) {
        Optional<String> optionalCookieValue = loginService.signIn(userForm);
        System.out.println("LOGIN!!!!!!!!!!!!!!! " + optionalCookieValue);
        if (optionalCookieValue.isPresent()) {
            Cookie cookie = new Cookie("AuthFilter", optionalCookieValue.get());
            response.addCookie(cookie);
            response.setStatus(201);
            return "redirect:/mainPage";
        } else return "redirect:/signIn";
    }
}
