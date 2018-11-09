package repositories;

import models.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.List;

public class UsersRepositoryJdbcTemplateImpl implements UsersRepository{

    // класс из Spring Framework
    private JdbcTemplate jdbcTemplate;

    //language=SQL
    private static final String SQL_SELECT_USER_BY_ID =
            "select * from users where id = ?";

    //language=SQL
    private static final String SQL_SELECT_ALL_USERS =
            "select * from users";

    //language=SQL
    private static final String SQL_INSERT_USER =
            "insert into users(name) values (?)";

    //language=SQL
    private static final String SQL_SELECT_BY_EMAIL=
            "select * from users where email = ?";

    private RowMapper<User> userRowMapper = (resultSet, i) -> User.builder()
            .id(resultSet.getLong("id"))
            .email(resultSet.getString("email"))
            .hashPassword(resultSet.getString("hashPassword"))
            .build();

    public UsersRepositoryJdbcTemplateImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public User findByEmail(String email) {
        return jdbcTemplate.queryForObject(SQL_SELECT_BY_EMAIL,userRowMapper,email);
    }

    public List<User> findAll() {
        return jdbcTemplate.query(SQL_SELECT_ALL_USERS, userRowMapper);
    }

    public User find(Long id) {
        return jdbcTemplate.queryForObject(SQL_SELECT_USER_BY_ID,
                userRowMapper, id);
    }

    public void save(User model) {
        jdbcTemplate.update(SQL_INSERT_USER, model.getEmail(),model.getHashPassword());
    }

    public void delete(Long id) {

    }

    public void update(User model) {

    }
}
