package ru.itis.batmandbboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.batmandbboot.forms.UserForm;
import ru.itis.batmandbboot.models.Auth;
import ru.itis.batmandbboot.models.User;
import ru.itis.batmandbboot.repositories.AuthRepository;
import ru.itis.batmandbboot.repositories.UsersRepository;

import java.util.Optional;
import java.util.UUID;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UsersRepository usersRepository;
    @Autowired
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
        return authRepository.findOneByCookieValue(cookieValue).isPresent();
    }

    @Override
    public Optional<String> signIn(UserForm userForm) {
        Optional<User> user = usersRepository.findOneByEmail(userForm.getEmail());
        if (user.isPresent() && passwordEncoder.matches(userForm.getPassword(), user.get().getHashPassword())) {
            String cookieValue = UUID.randomUUID().toString();
            Auth auth = Auth.builder()
                    .cookieValue(cookieValue)
                    .user(user.get())
                    .build();
            authRepository.save(auth);
            return Optional.of(cookieValue);
        } else return Optional.empty();
    }

    @Override
    public User getUserByCookie(String cookieValue) {
        Auth auth = authRepository.findOneByCookieValue(cookieValue).get();
        return User.builder()
                .id(auth.getUser().getId())
                .name(usersRepository.getOne(auth.getUser().getId()).getName())
                .email(usersRepository.getOne(auth.getUser().getId()).getEmail())
                .hashPassword(usersRepository.getOne(auth.getUser().getId()).getHashPassword())
                .build();
    }

    @Override
    public boolean registered(UserForm userForm) {
        return usersRepository.findOneByEmail(userForm.getEmail()).get().getEmail() != null;
    }
}
