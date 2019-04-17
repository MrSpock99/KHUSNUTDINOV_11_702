package ru.itis.batmandbboot.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.batmandbboot.models.Auth;

import java.util.Optional;

public interface AuthRepository extends JpaRepository<Auth, Long> {
    Optional<Auth> findOneByCookieValue(String cookieValue);
}
