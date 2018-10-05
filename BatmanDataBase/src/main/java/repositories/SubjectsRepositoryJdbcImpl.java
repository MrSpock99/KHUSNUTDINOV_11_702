package repositories;

import lombok.SneakyThrows;
import models.Subject;
import models.SubjectType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SubjectsRepositoryJdbcImpl implements SubjectRepository {

    //language=sql
    private static final String SQL_FIND_BY_ALIAS =
            "select * from subjects where alias = ?";
    //language=sql
    private static final String SQL_FIND_BY_ID =
            "select * from subjects where id = ?";
    //language=sql
    private static final String SQL_INSERT_NAME =
            "insert into subjects (alias, real_name, type) values (?,?,?)";
    //language=sql
    private static final String SQL_DELETE_BY_ID =
            "delete from subjects where id = ?";
    //language=sql
    private static final String SQL_SELECT_ALL =
            "select * from subjects";
    //language=sql
    private static final String SQL_UPDATE_ALIAS =
            "update subjects set alias = ? where alias = ?";
    private Connection connection;
    private WeaponRepositoryJdbcImpl weapon;
    private EquipmentRepositoryJdbcImpl equipment;
    private PreparedStatement statement;

    @SneakyThrows
    public SubjectsRepositoryJdbcImpl(Connection connection) {
        this.connection = connection;
        statement = connection.prepareStatement(SQL_FIND_BY_ALIAS);
        weapon = new WeaponRepositoryJdbcImpl(connection);
        equipment = new EquipmentRepositoryJdbcImpl(connection);

    }

    @Override
    @SneakyThrows
    public Subject findByAlias(String alias) {
        statement = connection.prepareStatement(SQL_FIND_BY_ALIAS);
        statement.setString(1, alias);
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();

        return Subject.builder()
                .id(resultSet.getLong("id"))
                .alias(resultSet.getString("alias"))
                .realName(resultSet.getString("real_name"))
                .type(SubjectType.valueOf(resultSet.getString("type")))
                .weakness(weapon.findOne(resultSet.getLong("weaknes_id")))
                .defence(equipment.findOne(resultSet.getLong("defence_id")))
                .build();
    }

    @Override
    @SneakyThrows
    public void save(Subject model) {
        statement = connection.prepareStatement(SQL_INSERT_NAME);
        statement.setString(1, model.getAlias());
        statement.setString(2, model.getRealName());
        statement.setString(3, model.getType().name());

        statement.executeQuery();
    }

    @Override
    @SneakyThrows
    public void update(Subject model) {
        statement = connection.prepareStatement(SQL_UPDATE_ALIAS);
        statement.setString(1, model.getAlias());
        statement.setString(2, model.getRealName());
    }

    @Override
    @SneakyThrows
    public void delete(Long id) {
        statement = connection.prepareStatement(SQL_DELETE_BY_ID);
        statement.setLong(1, id);
        statement.executeQuery();
    }

    @Override
    @SneakyThrows
    public Subject findOne(Long id) {
        statement = connection.prepareStatement(SQL_FIND_BY_ID);
        statement.setLong(1, id);
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();

        return Subject.builder()
                .id(resultSet.getLong("id"))
                .alias(resultSet.getString("alias"))
                .realName(resultSet.getString("real_name"))
                .type(SubjectType.valueOf(resultSet.getString("type")))
                .weakness(weapon.findOne(resultSet.getLong("weaknes_id")))
                .defence(equipment.findOne(resultSet.getLong("defence_id")))
                .build();
    }

    @Override
    @SneakyThrows
    public List findAll() {
        statement = connection.prepareStatement(SQL_SELECT_ALL);
        ResultSet resultSet = statement.executeQuery();

        List<Subject> subjectList = new ArrayList<>();
        while (resultSet.next()) {
            subjectList.add(Subject.builder()
                    .id(resultSet.getLong("id"))
                    .alias(resultSet.getString("alias"))
                    .realName(resultSet.getString("real_name"))
                    .type(SubjectType.valueOf(resultSet.getString("type")))
                    .weakness(weapon.findOne(resultSet.getLong("weaknes_id")))
                    .defence(equipment.findOne(resultSet.getLong("defence_id")))
                    .build());
        }
        return subjectList;
    }
}
