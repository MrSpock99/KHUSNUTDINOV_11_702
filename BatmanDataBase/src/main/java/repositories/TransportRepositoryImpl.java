package repositories;

import models.Transport;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.List;

public class TransportRepositoryImpl implements TransportRepository {
    //language=sql
    private static final String SQL_SELECT_ALL =
            "select * from transport";
    //language=sql
    private static final String SQL_DELETE_BY_ID =
            "delete from transport where id = ?";
    private JdbcTemplate template;

    private RowMapper<Transport> transportRowMapper = (row, rowNum) -> {
        Transport transport = new Transport();
        transport.setId(row.getLong("id"));
        transport.setName(row.getString("name"));
        transport.setAir(row.getBoolean("air"));
        transport.setGround(row.getBoolean("ground"));
        transport.setWater(row.getBoolean("water"));
        return transport;
    };

    public TransportRepositoryImpl(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    @Override
    public void save(Transport model) {

    }

    @Override
    public void update(Transport model) {

    }

    @Override
    public boolean delete(Long id) {
        return template.update(SQL_DELETE_BY_ID, id) > 0;
    }

    @Override
    public Transport findOne(Long id) {
        return null;
    }

    @Override
    public List<Transport> findAll() {
        return template.query(SQL_SELECT_ALL, transportRowMapper);
    }
}
