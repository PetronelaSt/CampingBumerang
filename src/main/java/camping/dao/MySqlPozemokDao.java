package camping.dao;

import camping.entities.Pozemok;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

public class MySqlPozemokDao implements PozemokDao {

    private JdbcTemplate jdbcTemplate;

    public MySqlPozemokDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // FUNGUJE (pridavanie jedneho pozemku do DB)
    @Override
    public void createPozemok(Pozemok pozemok) {
        String pozemok_create = "INSERT INTO pozemky(cislo_pozemku, kategoria, obsadenost) VALUE(?, ?, ?);";
        try {
            if (!pozemok.isObsadenost()) {
                jdbcTemplate.update(pozemok_create, pozemok.getCisloPozemku(), pozemok.getKategoria(), 0);
            } else {
                jdbcTemplate.update(pozemok_create, pozemok.getCisloPozemku(), pozemok.getKategoria(), 1);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Pozemok" + pozemok.getCisloPozemku() + "sa nepodarilo vlozit");
        }
        JOptionPane.showMessageDialog(null, "Pozemky sa uspesne ulozili do databazy");

    }

    // FUNGUJE (vrati vsetky pozemky)
    @Override
    public List<Pozemok> getAll() {
        String pozemok_getAll = "SELECT * FROM pozemky";
        return jdbcTemplate.query(pozemok_getAll, new PozemokRowMapper());

    }

    // TODO ()
    @Override
    public void updatePozemok(Pozemok pozemok) {
        String pozemok_update = "UPDATE pozemky SET kategoria = ?, obsadenost = ? WHERE cislo_pozemku = ?";
        jdbcTemplate.update(pozemok_update, pozemok.getKategoria(), pozemok.isObsadenost(), pozemok.getCisloPozemku());

    }

    @Override
    public boolean deletePozemokByCisloPozemku(long cisloPozemku) {
        String pozemok_delete = "DELETE FROM pozemky WHERE cislo_pozemku = " + cisloPozemku;
        int zmazanych = jdbcTemplate.update(pozemok_delete);
        return zmazanych == 1;
    }

    // VYMYSLIET DACO LEPSIE
    @Override
    public boolean deletePozemokById(long id) {
        String pozemok_delete = "DELETE FROM pozemky WHERE id = " + id;
        int zmazanych = jdbcTemplate.update(pozemok_delete);
        return zmazanych == 1;
    }

    @Override
    public List<Pozemok> findById(long id) {
        String pozemok_findById = "SELECT * FROM pozemky "
                + "WHERE id = " + id;
        return jdbcTemplate.query(pozemok_findById, new PozemokRowMapper());
    }

    @Override
    public List<Pozemok> findByCisloPozemku(long cisloPozemku) {
        String pozemok_findById = "SELECT * FROM pozemky "
                + "WHERE cislo_pozemku = " + cisloPozemku;
        return jdbcTemplate.query(pozemok_findById, new PozemokRowMapper());

    }

    private class PozemokRowMapper implements RowMapper<Pozemok> {

        @Override
        public Pozemok mapRow(ResultSet rs, int i) throws SQLException {
            Pozemok p = new Pozemok();
            p.setId(rs.getLong(1));
            p.setCisloPozemku(rs.getLong(2));
            p.setKategoria(rs.getString(3));
            if (rs.getInt(4) == 1) {
                p.setObsadenost(true);
            } else {
                p.setObsadenost(false);
            }
            return p;
        }

    }

    public static void main(String[] args) {
        MySqlPozemokDao ms = (MySqlPozemokDao) CampingDaoFactory.INSTANCE.getMySqlPozemokDao();
        List<Pozemok> p = ms.getAll();
        for (Pozemok pozemok : p) {
            System.out.println(pozemok);
        }
    }

}
