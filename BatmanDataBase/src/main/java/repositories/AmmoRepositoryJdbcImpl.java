package repositories;

import lombok.SneakyThrows;
import models.Ammo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.List;

public class AmmoRepositoryJdbcImpl implements AmmoRepository {

    //language=sql
    private static final String SQL_FIND_BY_ID =
            "select * from ammo where id = ?";
    //language=sql
    private static final String SQL_SELECT_ALL =
            "select * from ammo";
    private JdbcTemplate template;
    private RowMapper<Ammo> ammoRowMapper = (row, rowNum) -> {
        Ammo ammo = new Ammo();
        ammo.setId(row.getLong("id"));
        ammo.setName(row.getString("name"));
        ammo.setAmount(row.getInt("amount"));
        return ammo;
    };

    @SneakyThrows
    public AmmoRepositoryJdbcImpl(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    @Override
    public void save(Ammo model) {

    }

    @Override
    public void update(Ammo model) {

    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    @SneakyThrows
    public Ammo findOne(Long id) {
        return template.queryForObject(SQL_FIND_BY_ID, ammoRowMapper, id);
    }

    @Override
    public List<Ammo> findAll() {
        return template.query(SQL_SELECT_ALL, ammoRowMapper);
    }
}
