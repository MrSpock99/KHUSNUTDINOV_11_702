package repositories;

import lombok.SneakyThrows;
import models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class UsersRepositoryJdbcImpl implements UsersRepository {
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
    private Connection connection;
    private PreparedStatement findByIdStatement;
    private PreparedStatement findByEmailStatement;
    private PreparedStatement updateByIdStatement;
    private PreparedStatement insertStatement;

    @SneakyThrows
    public UsersRepositoryJdbcImpl(Connection connection) {
        this.connection = connection;
        findByIdStatement = connection.prepareStatement(SQL_FIND_BY_ID);
        updateByIdStatement = connection.prepareStatement(SQL_UPDATE_BY_ID);
        insertStatement = connection.prepareStatement(SQL_INSERT_USER);
        findByEmailStatement = connection.prepareStatement(SQL_FIND_BY_EMAIL);
    }

    @Override
    @SneakyThrows
    public void save(User model) {
        insertStatement.setString(1, model.getName());
        insertStatement.setString(2, model.getEmail());
        insertStatement.setString(3, model.getHashPassword());
        int affectedRows = insertStatement.executeUpdate();
        if (affectedRows != 1) {
            throw new IllegalArgumentException("SQL Exception");
        }
    }

    @Override
    public void update(User model) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    @SneakyThrows
    public User findOne(Long id) {
        findByIdStatement.setLong(1, id);
        ResultSet resultSet = findByIdStatement.executeQuery();
        resultSet.next();
        return User.builder()
                .id(resultSet.getLong("id"))
                .name(resultSet.getString("name"))
                .email(resultSet.getString("email"))
                .hashPassword(resultSet.getString("hash_password"))
                .build();
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    @SneakyThrows
    public User findByEmail(String email) {
        findByEmailStatement.setString(1, email);
        ResultSet resultSet = findByEmailStatement.executeQuery();
        resultSet.next();

        return User.builder()
                .id(resultSet.getLong("id"))
                .name(resultSet.getString("name"))
                .email(resultSet.getString("email"))
                .hashPassword(resultSet.getString("hash_password"))
                .build();
    }
}
