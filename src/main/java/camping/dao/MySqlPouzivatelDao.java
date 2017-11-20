package camping.dao;

import camping.entities.Pouzivatel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class MySqlPouzivatelDao implements PouzivatelDao {

    private JdbcTemplate jdbcTemplate;

    public MySqlPouzivatelDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void createPouzivatela(Pouzivatel pouzivatel) {
        if (pouzivatel.getId() == null) {
            String pouzivatel_create = "INSERT INTO pouzivatel(pozicia, meno, heslo) VALUE(?, ?, ?)";
            jdbcTemplate.update(pouzivatel_create, pouzivatel.getPozicia(), pouzivatel.getMeno(), pouzivatel.getHeslo());
        }
    }

    @Override
    public List<Pouzivatel> getAll() {
        String pouzivatel_getAll = "SELECT * FROM pouzivatel";
        return jdbcTemplate.query(pouzivatel_getAll, new PouzivatelRowMapper());
    }

    @Override
    public void updatePouzivatela(Pouzivatel pouzivatel) {
        String pouzivatel_update = "UPDATE pouzivatel SET pozicia = ?, meno = ?, heslo = ? WHERE id = ?";
        if (pouzivatel.getId() == null) {
            createPouzivatela(pouzivatel);
        } else {
            jdbcTemplate.update(pouzivatel_update, pouzivatel.getPozicia(), pouzivatel.getMeno(), pouzivatel.getHeslo(), pouzivatel.getId());
        }

    }

    @Override
    public boolean deletePouzivatela(Pouzivatel pouzivatel) {
        String pouzivatel_delete = "DELETE FROM pouzivatel WHERE id = " + pouzivatel.getId();
        int zmazanych = jdbcTemplate.update(pouzivatel_delete);
        return zmazanych == 1;
    }

    @Override
    public List<Pouzivatel> findById(Long id) {
        String pouzivatel_findById = "SELECT * FROM pouzivatel "
                + "WHERE id = " + id;
        return jdbcTemplate.query(pouzivatel_findById, new PouzivatelRowMapper());
    }

    @Override
    public List<Pouzivatel> findByPozicia(String pozicia) {
        String pouzivatel_findByPozicia = "SELECT * FROM pouzivatel "
                + "WHERE pozicia = " + pozicia;
        return jdbcTemplate.query(pouzivatel_findByPozicia, new PouzivatelRowMapper());
    }

    @Override
    public List<Pouzivatel> findByMeno(String meno) {
        String pouzivatel_findByMeno = "SELECT * FROM pouzivatel "
                + "WHERE meno = " + meno;
        return jdbcTemplate.query(pouzivatel_findByMeno, new PouzivatelRowMapper());
    }

    private class PouzivatelRowMapper implements RowMapper<Pouzivatel> {

        @Override
        public Pouzivatel mapRow(ResultSet rs, int i) throws SQLException {
            Pouzivatel p = new Pouzivatel();
            p.setId(rs.getLong(1));
            p.setMeno(rs.getString(2));
            p.setPozicia(rs.getString(3));
            p.setPocet_odrobenych_hodin(rs.getInt(4));
            p.setVyplata(rs.getInt(5));
            p.setHeslo(rs.getString(6));
            return p;
        }

    }

    public static void main(String[] args) {
        MySqlPouzivatelDao ms = (MySqlPouzivatelDao) CampingDaoFactory.INSTANCE.getMySqlPouzivatelDao();
        List<Pouzivatel> pouzivatelia = ms.getAll();
        for (Pouzivatel pouzivatel : pouzivatelia) {
            System.out.println(pouzivatel);
        }

    }
}
