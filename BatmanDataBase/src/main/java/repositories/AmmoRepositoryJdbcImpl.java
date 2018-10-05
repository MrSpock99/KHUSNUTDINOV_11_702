package repositories;

import lombok.SneakyThrows;
import models.Ammo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class AmmoRepositoryJdbcImpl implements AmmoRepository {

    //language=sql
    private static final String SQL_FIND_BY_ID =
            "select * from ammo where id = ?";
    private Connection connection;
    private PreparedStatement findByIdStatement;

    @SneakyThrows
    public AmmoRepositoryJdbcImpl(Connection connection) {
        this.connection = connection;
        findByIdStatement = connection.prepareStatement(SQL_FIND_BY_ID);
    }

    @Override
    public void save(Ammo model) {

    }

    @Override
    public void update(Ammo model) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    @SneakyThrows
    public Ammo findOne(Long id) {
        findByIdStatement.setLong(1, id);
        ResultSet resultSet = findByIdStatement.executeQuery();
        resultSet.next();

        Ammo ammo = new Ammo();
        ammo.setId(resultSet.getLong("id"));
        ammo.setAmount(resultSet.getInt("amount"));
        ammo.setName(resultSet.getString("name"));

        return ammo;
    }

    @Override
    public List<Ammo> findAll() {
        return null;
    }
}
