package ru.itis.repositories;

import ru.itis.models.User;

public interface UsersRepository extends CrudRepository<User, Long> {
    User findByEmail(String email);
}
