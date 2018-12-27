package repositories;

import lombok.SneakyThrows;
import models.Ammo;
import models.Weapon;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.List;

public class WeaponRepositoryJdbcImpl implements WeaponRepository {

    //language=sql
    private static final String SQL_FIND_BY_ID =
            "select image_base_64,weapon_id, ammo_id,w.amount as weapon_amount,a.amount as ammo_amount,weapon_ammo.name as weapon_ammo_name, a.name as ammo_name\n" +
                    "from weapon_ammo\n" +
                    "       join ammo a on ammo_id = a.id\n" +
                    "       join weapon w on weapon_id = w.id\n" +
                    "where weapon_ammo.id = ?;";
    //language=sql
    private static final String SQL_FIND_BY_ID_IN_WEAPON_TABLE =
            "select * from weapon where id = ?";

    private static final String SQL_SELECT_ALL =
            "select image_base_64, weapon_id, ammo_id,w.amount as weapon_amount,a.amount as ammo_amount, weapon_ammo.name as weapon_ammo_name, a.name as ammo_name\n" +
                    "from weapon_ammo\n" +
                    "       join ammo a on ammo_id = a.id\n" +
                    "       join weapon w on weapon_id = w.id\n;";

    //language=sql
    private static final String SQL_DELETE_BY_ID =
            "delete from weapon_ammo where id = ?";


    private RowMapper<Weapon> weaponRowMapper = (row, rowNum) -> {
        Weapon weapon = new Weapon();
        weapon.setId(row.getLong("weapon_id"));
        weapon.setName(row.getString("weapon_ammo_name"));
        weapon.setAmount(row.getInt("weapon_amount"));
        Ammo ammo = new Ammo();
        ammo.setId(row.getLong("ammo_id"));
        ammo.setName(row.getString("ammo_name"));
        ammo.setAmount(row.getInt("ammo_amount"));
        weapon.setAmmo(ammo);
        weapon.setImageBase64(row.getString("image_base_64"));
        return weapon;
    };
    private JdbcTemplate template;

    @SneakyThrows
    public WeaponRepositoryJdbcImpl(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    @Override
    public void save(Weapon model) {

    }

    @Override
    public void update(Weapon model) {

    }

    @Override
    public boolean delete(Long id) {
        return template.update(SQL_DELETE_BY_ID, id) > 0;
    }

    @Override
    @SneakyThrows
    public Weapon findOne(Long id) {
        return template.queryForObject(SQL_FIND_BY_ID, weaponRowMapper, id);
    }

    @Override
    public List<Weapon> findAll() {
        return template.query(SQL_SELECT_ALL, weaponRowMapper);
    }
}
