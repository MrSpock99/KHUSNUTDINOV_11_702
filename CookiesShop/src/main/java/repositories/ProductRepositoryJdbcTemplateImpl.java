package repositories;

import models.Product;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.List;

public class ProductRepositoryJdbcTemplateImpl implements ProductRepository {

    private JdbcTemplate jdbcTemplate;

    //language=SQL
    private static final String SQL_SELECT_PRODUCT_BY_ID =
            "select * from product where id = ?";

    //language=SQL
    private static final String SQL_SELECT_ALL_PRODUCTS =
            "select * from product";

    //language=SQL
    private static final String SQL_INSERT_PRODUCT =
            "insert into product(name,cost) values (?,?)";

    //language=SQL
    private static final String SQL_UPDATE_PRODUCT =
            "update product set(name,cost) = (?,?) where id = ?";

    private RowMapper<Product> productRowMapper = (resultSet, i) -> Product.builder()
            .id(resultSet.getLong("id"))
            .name(resultSet.getString("name"))
            .cost(resultSet.getInt("cost"))
            .build();

    public ProductRepositoryJdbcTemplateImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Product> findAll() {
        return jdbcTemplate.query(SQL_SELECT_ALL_PRODUCTS, productRowMapper);
    }

    @Override
    public Product find(Long id) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_PRODUCT_BY_ID, productRowMapper, id);
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public void save(Product model) {
        jdbcTemplate.update(SQL_INSERT_PRODUCT, productRowMapper, model.getName(), model.getCost());
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(Product model) {

    }
}
