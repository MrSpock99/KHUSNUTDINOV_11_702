package services;


import forms.LoginForm;
import helper.Current;
import models.Auth;
import models.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import repositories.AuthRepository;
import repositories.UsersRepository;

import java.util.Optional;
import java.util.UUID;

/**
 * 24.10.2018
 * LoginServiceImpl
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class LoginServiceImpl implements LoginService {

    private AuthRepository authRepository;

    private UsersRepository usersRepository;

    private BCryptPasswordEncoder encoder;

    public LoginServiceImpl(AuthRepository authRepository, UsersRepository usersRepository) {
        this.authRepository = authRepository;
        this.usersRepository = usersRepository;
        this.encoder = new BCryptPasswordEncoder();
    }

    @Override
    public Optional<String> login(LoginForm loginForm) {
        User user = usersRepository.findByEmail(loginForm.getEmail());
        if (user != null && encoder.matches(loginForm.getPassword(), user.getHashPassword())) {
            String cookieValue = UUID.randomUUID().toString();
            Auth auth = Auth.builder()
                    .cookieValue(cookieValue)
                    .user(user)
                    .build();
            authRepository.save(auth);
            return Optional.of(cookieValue);
        } else return Optional.empty();
    }

    @Override
    public boolean isExistByCookie(String cookieValue) {
        return authRepository.findByCookieValue(cookieValue).isPresent();
    }

    @Override
    public User getUserByCookie(String cookieValue) {
        Auth auth = authRepository.findByCookieValue(cookieValue).get();
        return User.builder()
                .id(auth.getId())
                .email(usersRepository.find(auth.getId()).getEmail())
                .hashPassword(usersRepository.find(auth.getId()).getHashPassword())
                .build();
    }
}
