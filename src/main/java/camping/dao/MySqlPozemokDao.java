package camping.dao;

import camping.design.PozemokFxModel;
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

    @Override
    public void createPozemok(PozemokFxModel pozemok) {
        String pozemok_create = "INSERT INTO pozemky(cislo_pozemku, kategoria_id, cena, obsadenost) VALUES(?, ?, ?, ?)";
        if (!pozemok.getObsadenost()) {
            jdbcTemplate.update(pozemok_create, pozemok.getCisloPozemku(), pozemok.getKategoriaId(), pozemok.getCena(), 0);
        } else {
            jdbcTemplate.update(pozemok_create, pozemok.getCisloPozemku(), pozemok.getKategoriaId(), pozemok.getCena(), 1);
        }

    }

    @Override
    public List<PozemokFxModel> getAll() {
        String pozemok_getAll = "SELECT * FROM pozemky";
        return jdbcTemplate.query(pozemok_getAll, new PozemokRowMapper());
    }

    // Update cely pozemok
    @Override
    public void updatePozemok(PozemokFxModel pozemok) {
        String pozemok_update = "UPDATE pozemky SET  cena = ?, kategoria_id = ?, obsadenost = ? WHERE cislo_pozemku = ?";
        if (pozemok.getCisloPozemku() == null) {
            createPozemok(pozemok);
        } else {
            if (pozemok.getObsadenost()) {
                jdbcTemplate.update(pozemok_update, pozemok.getCena(), pozemok.getKategoriaId(), 1, pozemok.getCisloPozemku());
            } else {
                jdbcTemplate.update(pozemok_update, pozemok.getCena(), pozemok.getKategoriaId(), 0, pozemok.getCisloPozemku());
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
    public PozemokFxModel findById(long id) {
        String pozemok_findById = "SELECT * FROM pozemky "
                + "WHERE id = " + id;
        return jdbcTemplate.query(pozemok_findById, (rs) -> {
            PozemokFxModel p = new PozemokFxModel();
            while (rs.next()) {
                p.setCisloPozemku(rs.getLong(2));
                p.setKategoriaId(rs.getLong(3));
                p.setCena(rs.getInt(4));
                if (rs.getInt(5) == 1) {
                    p.setObsadenost(true);
                } else {
                    p.setObsadenost(false);
                }

            }

            return p;
        });
    }

    @Override
    public PozemokFxModel findByCisloPozemku(long cisloPozemku) {
        String pozemok_findByCisloPozemku = "SELECT * FROM pozemky "
                + "WHERE cislo_pozemku = " + cisloPozemku;
        return jdbcTemplate.query(pozemok_findByCisloPozemku, (rs) -> {
            PozemokFxModel p = new PozemokFxModel();
            while (rs.next()) {
                p.setCisloPozemku(rs.getLong(2));
                p.setKategoriaId(rs.getLong(3));
                p.setCena(rs.getInt(4));
                if (rs.getInt(5) == 1) {
                    p.setObsadenost(true);
                } else {
                    p.setObsadenost(false);
                }

            }

            return p;
        });
    }

    // PREROBIT, NOVA TRIEDA KATEGORIА
    @Override
    public List<PozemokFxModel> findByKategoria(String kategoria) {
        String pozemok_findByKategoria = "SELECT * from pozemky where kategoria_nazov = " + "'" + kategoria + "'";
        return jdbcTemplate.query(pozemok_findByKategoria, new PozemokRowMapper());

    }

    @Override
    public List<PozemokFxModel> findByCena(int cena) {
        String pozemok_findByCena = "SELECT * FROM pozemky "
                + "WHERE cena = " + cena;
        return jdbcTemplate.query(pozemok_findByCena, new PozemokRowMapper());
    }

    @Override
    public List<PozemokFxModel> findByObsadenost(boolean obsadenost) {
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

    private class PozemokRowMapper implements RowMapper<PozemokFxModel> {

        @Override
        public PozemokFxModel mapRow(ResultSet rs, int i) throws SQLException {
            PozemokFxModel p = new PozemokFxModel();
            p.setCisloPozemku(rs.getLong(2));
            p.setKategoriaId(rs.getLong(3));
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
