package services;

import forms.UserForm;
import models.Auth;
import models.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import repositories.AuthRepository;
import repositories.UsersRepository;

import java.util.Optional;
import java.util.UUID;

public class LoginServiceImpl implements LoginService {

    private UsersRepository usersRepository;
    private AuthRepository authRepository;

    private PasswordEncoder passwordEncoder;

    public LoginServiceImpl(UsersRepository usersRepository, AuthRepository authRepository) {
        this.usersRepository = usersRepository;
        this.authRepository = authRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public void signUp(UserForm userForm) {
        User newUser = User.builder()
                .name(userForm.getName())
                .email(userForm.getEmail())
                .hashPassword(passwordEncoder.encode(userForm.getPassword()))
                .build();
        usersRepository.save(newUser);
    }

    @Override
    public boolean isExistByCookie(String cookieValue) {
        return authRepository.findByCookieValue(cookieValue).isPresent();
    }

    @Override
    public Optional<String> signIn(UserForm userForm) {
        User user = usersRepository.findByEmail(userForm.getEmail());
        if (user != null && passwordEncoder.matches(userForm.getPassword(), user.getHashPassword())) {
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
    public User getUserByCookie(String cookieValue) {
        Auth auth = authRepository.findByCookieValue(cookieValue).get();
        return User.builder()
                .id(auth.getUser().getId())
                .name(usersRepository.findOne(auth.getUser().getId()).getName())
                .email(usersRepository.findOne(auth.getUser().getId()).getEmail())
                .hashPassword(usersRepository.findOne(auth.getUser().getId()).getHashPassword())
                .build();
    }

    @Override
    public boolean registered(UserForm userForm) {
        return usersRepository.findByEmail(userForm.getEmail()).getEmail() != null;
    }
}
