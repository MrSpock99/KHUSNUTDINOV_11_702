package ru.itis.batmandbboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.batmandbboot.models.User;
import ru.itis.batmandbboot.models.UserState;
import ru.itis.batmandbboot.repositories.UsersRepository;

import java.util.Optional;

@Service
public class ConfirmServiceImpl implements ConfirmService {
    @Autowired
    private UsersRepository usersRepository;

    @Override
    public void confirm(String userConfirmString) {
        Optional<User> userOptional = usersRepository.findOneByConfirmString(userConfirmString);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setState(UserState.CONFIRMED);
            usersRepository.save(user);
        } else {
            throw new IllegalArgumentException();
        }
    }
}
