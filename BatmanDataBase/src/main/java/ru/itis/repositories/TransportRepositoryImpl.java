package ru.itis.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.itis.models.Transport;

import java.util.List;

public class TransportRepositoryImpl implements TransportRepository {
    //language=sql
    private static final String SQL_SELECT_ALL =
            "select * from transport";
    //language=sql
    private static final String SQL_DELETE_BY_ID =
            "delete from transport where id = ?";
    //language=sql
    private static final String SQL_INSERT =
            "insert into transport (name, water, air, ground,image_base_64) VALUES (?,?,?,?,?)";
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<Transport> transportRowMapper = (row, rowNum) -> {
        Transport transport = new Transport();
        transport.setId(row.getLong("id"));
        transport.setName(row.getString("name"));
        transport.setAir(row.getBoolean("air"));
        transport.setGround(row.getBoolean("ground"));
        transport.setWater(row.getBoolean("water"));
        transport.setImageBase64(row.getString("image_base_64"));
        return transport;
    };

    @Override
    public boolean save(Transport model) {
        return jdbcTemplate.update(SQL_INSERT, model.getName(),
                model.isWater(), model.isAir(), model.isGround(), model.getImageBase64()) > 0;
    }

    @Override
    public void update(Transport model) {

    }

    @Override
    public boolean delete(Long id) {
        return jdbcTemplate.update(SQL_DELETE_BY_ID, id) > 0;
    }

    @Override
    public Transport findOne(Long id) {
        return null;
    }

    @Override
    public List<Transport> findAll() {
        return jdbcTemplate.query(SQL_SELECT_ALL, transportRowMapper);
    }
}
