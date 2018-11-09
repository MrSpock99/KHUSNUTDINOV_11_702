package services;

import forms.LoginForm;
import models.User;

import java.util.Optional;

/**
 * 24.10.2018
 * LoginService
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface LoginService {
    Optional<String> login(LoginForm loginForm);
    boolean isExistByCookie(String cookieValue);
    User getUserByCookie(String cookie);
}
