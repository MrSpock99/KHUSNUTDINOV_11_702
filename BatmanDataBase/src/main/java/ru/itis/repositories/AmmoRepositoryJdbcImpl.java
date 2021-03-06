package ru.itis.repositories;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.itis.models.Ammo;

import java.util.List;

public class AmmoRepositoryJdbcImpl implements AmmoRepository {

    //language=sql
    private static final String SQL_FIND_BY_ID =
            "select * from ammo where id = ?";
    //language=sql
    private static final String SQL_SELECT_ALL =
            "select * from ammo";
    //language=sql
    private static final String SQL_INSERT = "insert into ammo (name, amount) values (?,?)";
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private RowMapper<Ammo> ammoRowMapper = (row, rowNum) -> {
        Ammo ammo = new Ammo();
        ammo.setId(row.getLong("id"));
        ammo.setName(row.getString("name"));
        ammo.setAmount(row.getInt("amount"));
        return ammo;
    };


    @Override
    public boolean save(Ammo model) {
        return jdbcTemplate.update(SQL_INSERT, ammoRowMapper, model.getName(), model.getAmount()) > 0;
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
        return jdbcTemplate.queryForObject(SQL_FIND_BY_ID, ammoRowMapper, id);
    }

    @Override
    public List<Ammo> findAll() {
        return jdbcTemplate.query(SQL_SELECT_ALL, ammoRowMapper);
    }
}
