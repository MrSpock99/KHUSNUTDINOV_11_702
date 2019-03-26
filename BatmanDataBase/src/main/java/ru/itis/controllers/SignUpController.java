package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.forms.UserForm;
import ru.itis.services.LoginService;

import javax.servlet.http.Cookie;
import java.util.Optional;

@Controller
public class SignUpController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/signUp", method = RequestMethod.GET)
    public ModelAndView getSignUpPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("signUp");
     /*   UserForm userForm;
        userForm = UserForm.builder()
                .email(req.getParameter("email"))
                .password(req.getParameter("password"))
                .build();

        Optional<String> optionalCookieValue = loginService.signIn(userForm);

        if (optionalCookieValue.isPresent()) {
            Cookie cookie = new Cookie("AuthFilter", optionalCookieValue.get());
            resp.addCookie(cookie);

            resp.setStatus(201);
            //resp.sendRedirect("/mainPage");
            modelAndView.setViewName("mainPage");
        } else {
            if (req.getParameter("name") != null) {
                userForm.setName(req.getParameter("name"));
                loginService.signUp(userForm);
                modelAndView.setViewName("signUp");
                //resp.sendRedirect("/signUp");
            } else {
                resp.setStatus(403);
            }
        }*/
        return modelAndView;
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public String signUpUser(UserForm userForm) {
        Optional<String> optionalCookieValue = loginService.signIn(userForm);
        if (optionalCookieValue.isPresent()) {
            Cookie cookie = new Cookie("AuthFilter", optionalCookieValue.get());
        } else {
            if (userForm.getName() != null) {
                loginService.signUp(userForm);
                return "redirect:/mainPage";
            } else {
                return "redirect:/signUp";
            }
        }
        return "redirect:/signUp";
    }
}
