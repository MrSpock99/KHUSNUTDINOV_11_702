package repositories;

import lombok.SneakyThrows;
import models.Weapon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class WeaponRepositoryJdbcImpl implements WeaponRepository {

    //language=sql
    private static final String SQL_FIND_BY_ID =
            "select * from weapon_ammo where weapon_id = ?";
    //language=sql
    private static final String SQL_FIND_BY_ID_IN_WEAPON_TABLE =
            "select * from weapon where id = ?";

    private Connection connection;
    private PreparedStatement findByIdStatement;

    private AmmoRepositoryJdbcImpl ammoRepositoryJdbc;

    @SneakyThrows
    public WeaponRepositoryJdbcImpl(Connection connection) {
        this.connection = connection;
        ammoRepositoryJdbc = new AmmoRepositoryJdbcImpl(connection);
    }

    @Override
    public void save(Weapon model) {

    }

    @Override
    public void update(Weapon model) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    @SneakyThrows
    public Weapon findOne(Long id) {
        findByIdStatement = connection.prepareStatement(SQL_FIND_BY_ID);
        findByIdStatement.setLong(1, id);
        ResultSet resultSet = findByIdStatement.executeQuery();

        if (!resultSet.next()) {
            return null;
        }

        Weapon weapon = new Weapon();
        weapon.setId(resultSet.getLong("weapon_id"));
        weapon.setAmmo(ammoRepositoryJdbc.findOne(resultSet.getLong("ammo_id")));

        findByIdStatement = connection.prepareStatement(SQL_FIND_BY_ID_IN_WEAPON_TABLE);
        findByIdStatement.setLong(1, id);
        resultSet = findByIdStatement.executeQuery();

        if (!resultSet.next()) {
            return null;
        }

        weapon.setAmount(resultSet.getInt("amount"));

        return weapon;
    }

    @Override
    public List<Weapon> findAll() {
        return null;
    }

}
