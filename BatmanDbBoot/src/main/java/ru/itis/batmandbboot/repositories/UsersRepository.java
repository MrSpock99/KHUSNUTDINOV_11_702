package ru.itis.batmandbboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.batmandbboot.models.User;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {
    Optional<User> findOneByEmail(String email);
    Optional<User> findOneByConfirmString(String confirmString);
}
