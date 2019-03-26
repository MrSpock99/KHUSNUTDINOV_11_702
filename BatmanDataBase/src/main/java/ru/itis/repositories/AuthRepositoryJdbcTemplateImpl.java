package ru.itis.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.itis.models.Auth;

import java.util.List;
import java.util.Optional;

public class AuthRepositoryJdbcTemplateImpl implements AuthRepository {
    //language=SQL
    private static final String SQL_INSERT =
            "insert into auth(user_id, cookie_value) values (?, ?)";

    //language=SQL
    private static final String SQL_SELECT_BY_COOKIE_VALUE =
            "select * from auth where cookie_value = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private UsersRepository usersRepository;
    private RowMapper<Auth> authRowMapper = (rs, rowNum) -> Auth.builder()
            .id(rs.getLong("id"))
            .user(usersRepository.findOne(rs.getLong("user_id")))
            .cookieValue(rs.getString("cookie_value"))
            .build();


    @Override
    public List<Auth> findAll() {
        return null;
    }

    @Override
    public boolean save(Auth model) {
        return jdbcTemplate.update(SQL_INSERT, model.getUser().getId(), model.getCookieValue()) > 0;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public Auth findOne(Long id) {
        return null;
    }

    @Override
    public void update(Auth model) {

    }

    @Override
    public Optional<Auth> findByCookieValue(String cookieValue) {
        try {
            return Optional.of(jdbcTemplate.queryForObject(SQL_SELECT_BY_COOKIE_VALUE, authRowMapper, cookieValue));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }
}
