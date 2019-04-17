package ru.itis.batmandbboot.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ru.itis.batmandbboot.models.User;
import ru.itis.batmandbboot.repositories.UsersRepository;

import java.util.Optional;

@Component(value = "my")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> userOptional = usersRepository.findOneByEmail(email);

        if (userOptional.isPresent()) {
            return new UserDetailsImpl(userOptional.get());
        } else throw new SecurityException();
    }
}
