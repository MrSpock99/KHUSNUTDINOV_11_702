package repositories;

import lombok.SneakyThrows;
import models.Cart;
import models.Product;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.util.List;

public class CartRepositoryJdbcImpl implements CartRepository {

    private JdbcTemplate jdbcTemplate;
    private UsersRepository usersRepository;

    //language=SQL
    private static final String SQL_SELECT_CART_BY_ID =
            "select * from cart where id = ?";

    //language=SQL
    private static final String SQL_SELECT_CART_BY_OWNER_ID =
            "select * from cart where owner_id = ?";

    //language=SQL
    private static final String SQL_INSERT_CART =
            "insert into cart(owner_id) values (?)";

    //language=SQL
    private static final String SQL_UPDATE_CART =
            "update cart set owner_id = ? where id = ?";

    //language=SQL
    private static final String SQL_INSERT_CART_PRODUCTS =
            "insert into cart_product(cart_id, product_id) values (?,?)";

    //language=SQL
    private static final String SQL_UPDATE_CART_PRODUCTS =
            "update cart_product set(cart_id,product_id) = (?,?) where cart_id = ?";

    //language=SQL
    private static final String SQL_SELECT_CART_PRODUCTS =
            "select * from cart_product,product where cart_id = ? and product.id = product_id";

    //language=SQL
    private static final String SQL_ADD_PRODUCT_TO_CART =
            "insert into cart_product(cart_id,product_id) values(?,?)";

    private PreparedStatement insertCartProductsStatement;
    private PreparedStatement insertCartStatement;
    private PreparedStatement updateCartStatement;
    private PreparedStatement updateCartProductStatement;
    private PreparedStatement addProductStatement;

    private RowMapper<Cart> cartRowMapper = (resultSet, i) -> Cart.builder()
            .id(resultSet.getLong("id"))
            .build();
    private RowMapper<Product> productRowMapper = (resultSet, i) -> Product.builder()
            .id(resultSet.getLong("product_id"))
            .name(resultSet.getString("name"))
            .cost(resultSet.getInt("cost"))
            .build();

    @SneakyThrows
    public CartRepositoryJdbcImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.usersRepository = new UsersRepositoryJdbcTemplateImpl(dataSource);

        insertCartProductsStatement = dataSource.getConnection().prepareStatement(SQL_INSERT_CART_PRODUCTS);
        insertCartStatement = dataSource.getConnection().prepareStatement(SQL_INSERT_CART);
        updateCartStatement = dataSource.getConnection().prepareStatement(SQL_UPDATE_CART);
        updateCartProductStatement = dataSource.getConnection().prepareStatement(SQL_UPDATE_CART_PRODUCTS);
        addProductStatement = dataSource.getConnection().prepareStatement(SQL_ADD_PRODUCT_TO_CART);
    }

    public List<Cart> findAll() {
        return null;
    }

    public Cart find(Long id) {
        return null;
    }

    @SneakyThrows
    public void save(Cart model) {
        for (Product product : model.getProductList()) {
            insertCartProductsStatement.setLong(1, model.getId());
            insertCartProductsStatement.setLong(2, product.getId());
            insertCartProductsStatement.executeUpdate();
        }

        insertCartStatement.setLong(1, model.getOwner().getId());

        insertCartStatement.executeUpdate();
        /*for (Product product : model.getProductList()) {
            jdbcTemplate.update(SQL_INSERT_CART_PRODUCTS, productRowMapper, model.getId(),product.getId());
        }
        jdbcTemplate.update(SQL_INSERT_CART, cartRowMapper, model.getId(), model.getOwner().getId());*/
    }

    public void delete(Long id) {

    }

    @SneakyThrows
    public void update(Cart model) {

        for (Product product : model.getProductList()) {
            updateCartProductStatement.setLong(1, model.getId());
            updateCartProductStatement.setLong(3, model.getId());
            updateCartProductStatement.setLong(2, product.getId());
            updateCartProductStatement.executeUpdate();
        }

        updateCartStatement.setLong(1, model.getOwner().getId());
        updateCartStatement.setLong(2, model.getId());

        updateCartStatement.executeUpdate();


        /*for (Product product : model.getProductList()) {
            jdbcTemplate.update(SQL_INSERT_CART_PRODUCTS, productRowMapper, product.getId(), product.getName(), product.getCost());
        }
        jdbcTemplate.update(SQL_UPDATE_CART, cartRowMapper, model.getOwner().getId());*/
    }

    @Override
    public Cart findByOwnerId(Long ownerId) {
        Cart cart;
        try {
            cart = jdbcTemplate.queryForObject(SQL_SELECT_CART_BY_OWNER_ID, cartRowMapper, ownerId);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }

        cart.setOwner(usersRepository.find(ownerId));
        cart.setProductList(getProductList(cart));
        return cart;
    }

    @Override
    public List<Product> getProductList(Cart cart) {
        return jdbcTemplate.query(SQL_SELECT_CART_PRODUCTS, productRowMapper, cart.getId());
    }

    @Override
    @SneakyThrows
    public void addProduct(Cart cart) {
        addProductStatement.setLong(1, cart.getId());
        addProductStatement.setLong(2, cart.getProductList().get(cart.getProductList().size() - 1).getId());
        addProductStatement.executeUpdate();
    }
}
