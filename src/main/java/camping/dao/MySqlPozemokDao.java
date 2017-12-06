package camping.dao;

import camping.entities.Kategoria;
import camping.entities.Pozemok;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class MySqlPozemokDao implements PozemokDao {

    private JdbcTemplate jdbcTemplate;

    public MySqlPozemokDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // FUNGUJE (pridavanie jedneho pozemku do DB)
    @Override
    public void createPozemok(Pozemok pozemok) {
        if (pozemok.getId() == null) {
            String pozemok_create = "INSERT INTO pozemky(cislo_pozemku, kategoria_id, cena, obsadenost) VALUES(?, ?, ?, ?);";
            if (!pozemok.isObsadenost()) {
                jdbcTemplate.update(pozemok_create, pozemok.getCisloPozemku(), pozemok.getKategoria_id(), pozemok.getCena(), 0);
            } else {
                jdbcTemplate.update(pozemok_create, pozemok.getCisloPozemku(), pozemok.getKategoria_id(), pozemok.getCena(), 1);
            }
        }
    }

    @Override
    public List<Pozemok> getAll() {
        String pozemok_getAll = "SELECT * FROM pozemky";
        return jdbcTemplate.query(pozemok_getAll, new PozemokRowMapper());
    }

    // Update cely pozemok
    @Override
    public void updatePozemok(Pozemok pozemok) {
        String pozemok_update = "UPDATE pozemky SET cislo_pozemku = ?, cena = ?, kategoria_id = ?, obsadenost = ? WHERE id = ?";
        if (pozemok.getId() == null) {
            createPozemok(pozemok);
        } else {
            if (pozemok.isObsadenost()) {
                jdbcTemplate.update(pozemok_update, pozemok.getCisloPozemku(), pozemok.getCena(), pozemok.getKategoria_id(), 1);
            } else {
                jdbcTemplate.update(pozemok_update, pozemok.getCisloPozemku(), pozemok.getCena(), pozemok.getKategoria_id(), 0);
            }
        }

    }

    @Override
    public boolean deletePozemokById(long id) {
        String pozemok_delete = "DELETE FROM pozemky WHERE id = " + id;
        int zmazanych = jdbcTemplate.update(pozemok_delete);
        return zmazanych == 1;
    }

    @Override
    public boolean deletePozemokByCisloPozemku(long cisloPozemku) {
        String pozemok_delete = "DELETE FROM pozemky WHERE cislo_pozemku = " + cisloPozemku;
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
        String pozemok_findByCisloPozemku = "SELECT * FROM pozemky "
                + "WHERE cislo_pozemku = " + cisloPozemku;
        return jdbcTemplate.query(pozemok_findByCisloPozemku, new PozemokRowMapper());

    }

    // PREROBIT, NOVA TRIEDA KATEGORIА
    @Override
    public List<Pozemok> findByKategoria(String kategoria) {
        String pozemok_findByKategoria = "SELECT * from pozemky where kategoria_nazov = " + "'" + kategoria + "'";
        return jdbcTemplate.query(pozemok_findByKategoria, new PozemokRowMapper());

    }

    @Override
    public List<Pozemok> findByCena(int cena) {
        String pozemok_findByCena = "SELECT * FROM pozemky "
                + "WHERE cena = " + cena;
        return jdbcTemplate.query(pozemok_findByCena, new PozemokRowMapper());
    }

    @Override
    public List<Pozemok> findByObsadenost(boolean obsadenost) {
        String pozemok_findByObsadenost = "";
        if (obsadenost == true) {
            pozemok_findByObsadenost = "SELECT * FROM pozemky "
                    + "WHERE obsadenost = " + 1;
        } else {
            pozemok_findByObsadenost = "SELECT * FROM pozemky "
                    + "WHERE obsadenost = " + 0;
        }
        return jdbcTemplate.query(pozemok_findByObsadenost, new PozemokRowMapper());

    }

    private class PozemokRowMapper implements RowMapper<Pozemok> {

        @Override
        public Pozemok mapRow(ResultSet rs, int i) throws SQLException {
            Pozemok p = new Pozemok();
            p.setId(rs.getLong(1));
            p.setCisloPozemku(rs.getLong(2));
            p.setKategoria_id(rs.getLong(3));
            p.setCena(rs.getInt(4));
            if (rs.getInt(5) == 1) {
                p.setObsadenost(true);
            } else {
                p.setObsadenost(false);
            }

            return p;
        }

    }

}
