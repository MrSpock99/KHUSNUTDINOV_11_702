package repositories;

import lombok.SneakyThrows;
import models.Equipment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class EquipmentRepositoryJdbcImpl implements EquipmentRepository {

    //language=sql
    private static final String SQL_FIND_BY_ID =
            "select * from equipment where id = ?";
    private Connection connection;
    private PreparedStatement findByIdStatement;


    @SneakyThrows
    public EquipmentRepositoryJdbcImpl(Connection connection) {
        this.connection = connection;
        findByIdStatement = connection.prepareStatement(SQL_FIND_BY_ID);

    }

    @Override
    public void save(Equipment model) {

    }

    @Override
    public void update(Equipment model) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    @SneakyThrows
    public Equipment findOne(Long id) {
        findByIdStatement.setLong(1, id);
        ResultSet resultSet = findByIdStatement.executeQuery();
        if (!resultSet.next()) {
            return null;
        }

        Equipment equipment = new Equipment();
        equipment.setId(resultSet.getLong("id"));
        equipment.setName(resultSet.getString("name"));
        equipment.setBullet(resultSet.getBoolean("bullet"));
        equipment.setExplosion(resultSet.getBoolean("explosion"));
        equipment.setKnife(resultSet.getBoolean("knife"));
        equipment.setAmount(resultSet.getInt("amount"));
        return equipment;
    }

    @Override
    public List<Equipment> findAll() {
        return null;
    }
}
