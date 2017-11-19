package camping.dao;

import camping.entities.Pouzivatel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class MySqlPouzivatelDao implements PouzivatelDao {

    private JdbcTemplate jdbcTemplate;

    public MySqlPouzivatelDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void createPouzivatela(Pouzivatel pouzivatel) {
    }

    @Override
    public List<Pouzivatel> getAll() {
        String pouzivatel_getAll = "SELECT * FROM pouzivatel";
        return jdbcTemplate.query(pouzivatel_getAll, new RowMapper<Pouzivatel>() {
            @Override
            public Pouzivatel mapRow(ResultSet rs, int i) throws SQLException {
                Pouzivatel p = new Pouzivatel();
                p.setId(rs.getLong(1));
                p.setPozicia(rs.getString(2));
                p.setMeno(rs.getString(3));
                p.setHeslo(rs.getString(4));
                return p;
            }
        });
    }

    @Override
    public void updatePouzivatela(Pouzivatel pouzivatel) {
    }

    @Override
    public boolean deletePouzivatela(Pouzivatel pouzivatel) {
        String pouzivatel_delete = "DELETE FROM pouzivatel WHERE id = " + pouzivatel.getId();
        int zmazanych = jdbcTemplate.update(pouzivatel_delete);
        return zmazanych == 1;
    }

    @Override
    public void findById(Long id) {
    }

    public static void main(String[] args) {
        MySqlPouzivatelDao ms = (MySqlPouzivatelDao) CampingDaoFactory.INSTANCE.getMySqlPouzivatelDao();
        List<Pouzivatel> pouzivatelia = ms.getAll();
        for (Pouzivatel pouzivatel : pouzivatelia) {
            System.out.println(pouzivatel);
        }

    }
}
