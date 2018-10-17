package repositories;

import models.User;

public interface UsersRepository extends CrudRepository<User, Long> {
    User findByEmail(String email);
}
