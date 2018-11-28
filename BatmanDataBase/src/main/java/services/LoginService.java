package services;

import forms.UserForm;
import models.User;

import java.util.Optional;

public interface LoginService {
    void signUp(UserForm userForm);

    Optional<String> signIn(UserForm userForm);

    boolean isExistByCookie(String cookieValue);

    User getUserByCookie(String cookieValue);

    boolean registered(UserForm userForm);
}
