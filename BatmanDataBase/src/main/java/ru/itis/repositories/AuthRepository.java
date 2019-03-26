package ru.itis.repositories;

import ru.itis.models.Auth;

import java.util.Optional;

public interface AuthRepository extends CrudRepository<Auth, Long> {
    Optional<Auth> findByCookieValue(String cookieValue);
}
