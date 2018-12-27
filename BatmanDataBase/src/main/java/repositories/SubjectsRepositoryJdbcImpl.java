package repositories;

import lombok.SneakyThrows;
import models.Subject;
import models.SubjectType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class SubjectsRepositoryJdbcImpl implements SubjectRepository {

    //language=sql
    private static final String SQL_FIND_BY_ALIAS =
            "select * from subject where alias = ?";
    //language=sql
    private static final String SQL_FIND_BY_ID =
            "select * from subject where id = ?";
    //language=sql
    private static final String SQL_INSERT_NAME =
            "insert into subject (alias, real_name, type) values (?,?,?)";
    //language=sql
    private static final String SQL_DELETE_BY_ID =
            "delete from subject where id = ?";
    //language=sql
    private static final String SQL_SELECT_ALL =
            "select * from subject";
    //language=sql
    private static final String SQL_SELECT_ALL_HEROES =
            "select * from subject where type = 'HERO'";
    //language=sql
    private static final String SQL_SELECT_ALL_VILLAINS =
            "select * from subject where type = 'VILLAIN'";
    //language=sql
    private static final String SQL_UPDATE_ALL_BY_ID =
            "update subject set alias = ?, real_name = ?,weakness_id = ?, defence_id = ?, type = ?   where id = ?";
    private WeaponRepositoryJdbcImpl weapon;
    private EquipmentRepositoryJdbcImpl equipment;
    private JdbcTemplate template;
    private RowMapper<Subject> subjectRowMapper = (row, rowNum) -> Subject.builder()
            .id(row.getLong("id"))
            .alias(row.getString("alias"))
            .realName(row.getString("real_name"))
            .type(SubjectType.valueOf(row.getString("type")))
            .defence(equipment.findOne(row.getLong("defence_id")))
            .weakness(weapon.findOne(row.getLong("weakness_id")))
            .imageBase64(row.getString("image_base_64"))
            .build();

    @SneakyThrows
    public SubjectsRepositoryJdbcImpl(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
        weapon = new WeaponRepositoryJdbcImpl(dataSource);
        equipment = new EquipmentRepositoryJdbcImpl(dataSource);
    }

    @Override
    @SneakyThrows
    public Subject findByAlias(String alias) {
        return template.queryForObject(SQL_FIND_BY_ALIAS, subjectRowMapper, alias);
    }

    @Override
    public Optional<List<Subject>> getHeroes() {
        return Optional.of(template.query(SQL_SELECT_ALL_HEROES, subjectRowMapper));
    }

    @Override
    public Optional<List<Subject>> getVillains() {
        return Optional.of(template.query(SQL_SELECT_ALL_VILLAINS, subjectRowMapper));
    }

    @Override
    @SneakyThrows
    public boolean save(Subject model) {
        return template.update(SQL_INSERT_NAME, model.getAlias(), model.getRealName(), model.getType().name()) > 0;
    }

    @Override
    @SneakyThrows
    public void update(Subject model) {
        template.update(SQL_UPDATE_ALL_BY_ID, model.getAlias(),
                model.getRealName(), model.getWeakness().getId(),
                model.getDefence().getId(), model.getType().name());
    }

    @Override
    @SneakyThrows
    public boolean delete(Long id) {
        return template.update(SQL_DELETE_BY_ID, id) > 0;
    }

    @Override
    @SneakyThrows
    public Subject findOne(Long id) {
        return template.queryForObject(SQL_FIND_BY_ID, subjectRowMapper, id);
    }

    @Override
    @SneakyThrows
    public List findAll() {
        return template.query(SQL_SELECT_ALL, subjectRowMapper);
    }
}
