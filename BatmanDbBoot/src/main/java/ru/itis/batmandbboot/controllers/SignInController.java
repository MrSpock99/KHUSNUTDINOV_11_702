package ru.itis.batmandbboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.batmandbboot.forms.UserForm;
import ru.itis.batmandbboot.services.LoginService;

@Controller
public class SignInController {
    @Autowired
    private LoginService loginService;

    @GetMapping("/signIn")
    public String getSignInPage() {
        return "signIn";
    }

    @PostMapping("/signIn")
    public String signUnUser(UserForm userForm) {
        loginService.signIn(userForm);
        return "redirect:/mainPage";
    }
}
