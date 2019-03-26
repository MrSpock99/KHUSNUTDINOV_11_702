package ru.itis.repositories;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.itis.models.User;

import java.util.List;

public class UsersRepositoryJdbcImpl implements UsersRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    //language=sql
    private static final String SQL_FIND_BY_ID =
            "select * from db_user where id = ?";
    //language=sql
    private static final String SQL_FIND_BY_EMAIL =
            "select * from db_user where email = ?";
    //language=sql
    private static final String SQL_UPDATE_BY_ID =
            "update db_user set name = ?," +
                    "email = ? where id = ?;";
    //language=sql
    private static final String SQL_INSERT_USER =
            "insert into db_user(name, email, hash_password) values (?, ?, ?)";
    //language=sql
    private static final String SQL_DELETE_BY_ID =
            "delete from db_user where id = ?";

    private RowMapper<User> userRowMapper = (resultSet, i) -> User.builder()
            .id(resultSet.getLong("id"))
            .name(resultSet.getString("name"))
            .email(resultSet.getString("email"))
            .hashPassword(resultSet.getString("hash_password"))
            .build();

    @Override
    @SneakyThrows
    public boolean save(User model) {
        return jdbcTemplate.update(SQL_INSERT_USER, model.getEmail(), model.getName(), model.getHashPassword()) > 0;
    }

    @Override
    public void update(User model) {

    }

    @Override
    public boolean delete(Long id) {
        return jdbcTemplate.update(SQL_DELETE_BY_ID, id) > 0;
    }

    @Override
    @SneakyThrows
    public User findOne(Long id) {
        return jdbcTemplate.queryForObject(SQL_FIND_BY_ID, userRowMapper, id);
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    @SneakyThrows
    public User findByEmail(String email) {
        try {
            return jdbcTemplate.queryForObject(SQL_FIND_BY_EMAIL, userRowMapper, email);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }
}
