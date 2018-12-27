package repositories;

import models.Expenses;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.List;

public class ExpensesRepositoryJdbcImpl implements ExpensesRepository {
    //language=sql
    private static final String SQL_SELECT_ALL =
            "select * from expense";
    //language=sql
    private static final String SQL_DELETE_BY_ID =
            "delete from expense where id = ?";
    private JdbcTemplate template;
    private RowMapper<Expenses> expensesRowMapper = (row, rowNum) -> Expenses.builder()
            .id(row.getLong("id"))
            .name(row.getString("name"))
            .amount(row.getInt("amount"))
            .budget(row.getLong("budget"))
            .cost(row.getInt("cost"))
            .type(row.getString("type"))
            .build();

    public ExpensesRepositoryJdbcImpl(DataSource dataSource) {
        template = new JdbcTemplate(dataSource);
    }

    @Override
    public void save(Expenses model) {

    }

    @Override
    public void update(Expenses model) {

    }

    @Override
    public boolean delete(Long id) {
        return template.update(SQL_DELETE_BY_ID, expensesRowMapper, id) > 0;
    }

    @Override
    public Expenses findOne(Long id) {
        return null;
    }

    @Override
    public List<Expenses> findAll() {
        return template.query(SQL_SELECT_ALL, expensesRowMapper);
    }
}
