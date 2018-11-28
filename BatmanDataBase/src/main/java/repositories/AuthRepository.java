package repositories;

import models.Auth;

import java.util.Optional;

public interface AuthRepository extends CrudRepository<Auth, Long> {
    Optional<Auth> findByCookieValue(String cookieValue);
}
