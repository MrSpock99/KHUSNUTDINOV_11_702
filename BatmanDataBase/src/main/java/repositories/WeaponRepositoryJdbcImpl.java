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
    private Connection connection;
    private PreparedStatement findByIdStatement;

    private AmmoRepositoryJdbcImpl ammoRepositoryJdbc;

    @SneakyThrows
    public WeaponRepositoryJdbcImpl(Connection connection) {
        this.connection = connection;
        findByIdStatement = connection.prepareStatement(SQL_FIND_BY_ID);
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
        findByIdStatement.setLong(1, id);
        ResultSet resultSet = findByIdStatement.executeQuery();
        resultSet.next();

        Weapon weapon = new Weapon();
        weapon.setAmount(1);
        weapon.setId(resultSet.getLong("weapon_id"));
        weapon.setAmmo(ammoRepositoryJdbc.findOne(resultSet.getLong("ammo_id")));

        return weapon;
    }

    @Override
    public List<Weapon> findAll() {
        return null;
    }
}
