package repositories;

import lombok.SneakyThrows;
import models.Equipment;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.List;

public class EquipmentRepositoryJdbcImpl implements EquipmentRepository {

    //language=sql
    private static final String SQL_FIND_BY_ID =
            "select * from equipment where id = ?";
    //language=sql
    private static final String SQL_SELECT_ALL =
            "select * from equipment";
    //language=sql
    private static final String SQL_DELETE_BY_ID =
            "delete from equipment where id = ?";
    private static final String SQL_INSERT =
            "insert into equipment (name, bullet, knife, explosion, amount, image_base_64) values (?,?,?,?,?,?);";

    private JdbcTemplate template;

    private RowMapper<Equipment> equipmentRowMapper = (row, rowNum) -> {
        Equipment equipment = new Equipment(row.getBoolean("bullet"),
                row.getBoolean("knife"), row.getBoolean("explosion"));
        equipment.setName(row.getString("name"));
        equipment.setId(row.getLong("id"));
        equipment.setImageBase64(row.getString("image_base_64"));
        equipment.setAmount(row.getInt("amount"));
        return equipment;
    };

    @SneakyThrows
    public EquipmentRepositoryJdbcImpl(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    @Override
    public boolean save(Equipment model) {
        return template.update(SQL_INSERT, model.getName(),
                model.getBullet(), model.getKnife(), model.getExplosion(), model.getAmount(), model.getImageBase64()) > 0;
    }

    @Override
    public void update(Equipment model) {

    }

    @Override
    public boolean delete(Long id) {
        return template.update(SQL_DELETE_BY_ID, id) > 0;
    }

    @Override
    @SneakyThrows
    public Equipment findOne(Long id) {
        try {
            return template.queryForObject(SQL_FIND_BY_ID, equipmentRowMapper, id);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<Equipment> findAll() {
        return template.query(SQL_SELECT_ALL, equipmentRowMapper);
    }
}
