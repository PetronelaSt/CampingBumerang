package camping.dao;

import camping.entities.Objednavka;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import javax.swing.JOptionPane;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class MySqlObjednavkaDao implements ObjednavkaDao {

    private JdbcTemplate jdbcTemplate;

    public MySqlObjednavkaDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void createObjednavku(Objednavka objednavka) {
        if (objednavka.getId() == null) {
            String objednavka_create = "INSERT INTO objednavky(pozemky_id, pouzivatel_id, datum_objednavky, datum_prichodu, datum_odchodu, pocet_dni, platba) VALUE(?, ?, ?, ?, ?, ?, ?)";
            if (objednavka.isPlatba()) {
                jdbcTemplate.update(objednavka_create, objednavka.getPozemokId(), objednavka.getPouzivatelId(), objednavka.getDatumObjednavky(), objednavka.getDatumPrichodu(), objednavka.getDatumOdchodu(), objednavka.getPocetDni(), 1);
            } else {
                jdbcTemplate.update(objednavka_create, objednavka.getPozemokId(), objednavka.getPouzivatelId(), objednavka.getDatumObjednavky(), objednavka.getDatumPrichodu(), objednavka.getDatumOdchodu(), objednavka.getPocetDni(), 0);
            }
        }
    }

    @Override
    public List<Objednavka> getAll() {
        String objednavka_getAll = "SELECT * FROM objednavky";
        return jdbcTemplate.query(objednavka_getAll, new ObjednavkaRowMapper());
    }

    @Override
    public void updateObjednavku(Objednavka objednavka) {
        if (objednavka.getId() == null) {
            createObjednavku(objednavka);
        } else {
            String objednavka_update = "UPDATE pouzivatel SET pozemok_id = ?, pouzivatel_id = ?, datum_objednavky = ?, datum_prichodu = ?, datum_odchodu = ?, pocet_dni = ?, platba = ? WHERE id = ?";
            if (objednavka.isPlatba()) {
                jdbcTemplate.update(objednavka_update, objednavka.getPozemokId(), objednavka.getPouzivatelId(), objednavka.getDatumObjednavky(), objednavka.getDatumPrichodu(), objednavka.getDatumOdchodu(), objednavka.getPocetDni(), 1);
            } else {
                jdbcTemplate.update(objednavka_update, objednavka.getPozemokId(), objednavka.getPouzivatelId(), objednavka.getDatumObjednavky(), objednavka.getDatumPrichodu(), objednavka.getDatumOdchodu(), objednavka.getPocetDni(), 0);
            }
        }
    }

    @Override
    public boolean deleteObjednavku(Objednavka objednavka) {
        String objednavka_delete = "DELETE FROM objednavky WHERE id = " + objednavka.getId();
        int zmazanych = jdbcTemplate.update(objednavka_delete);
        return zmazanych == 1;

    }

    @Override
    public List<Objednavka> findById(Long id) {
        String objednavka_findById = "SELECT * FROM objednavky "
                + "WHERE id = " + id;
        return jdbcTemplate.query(objednavka_findById, new ObjednavkaRowMapper());
    }

    @Override
    public List<Objednavka> findByPozemokId(Long pozemok_id) {
        String objednavka_findByPozemokId = "SELECT * FROM objednavky "
                + "WHERE pozemok_id = " + pozemok_id;
        return jdbcTemplate.query(objednavka_findByPozemokId, new ObjednavkaRowMapper());
    }

    @Override
    public List<Objednavka> findByPouzivatelId(Long pouzivatel_id) {
        String objednavka_findByPouzivatelId = "SELECT * FROM objednavky "
                + "WHERE pouzivatel_id = " + pouzivatel_id;
        return jdbcTemplate.query(objednavka_findByPouzivatelId, new ObjednavkaRowMapper());
    }

    @Override
    public List<Objednavka> findByDatumObjednavky(LocalDate datumObjednavky) {
        String objednavka_findByDatumObjednavky = "SELECT * FROM objednavky "
                + "WHERE datum_objednavky = " + datumObjednavky;
        return jdbcTemplate.query(objednavka_findByDatumObjednavky, new ObjednavkaRowMapper());
    }

    @Override
    public List<Objednavka> findByDatumPrichodu(LocalDate datumPrichodu) {
        String objednavka_findByDatumPrichodu = "SELECT * FROM objednavky "
                + "WHERE datum_prichodu = " + datumPrichodu;
        return jdbcTemplate.query(objednavka_findByDatumPrichodu, new ObjednavkaRowMapper());
    }

    @Override
    public List<Objednavka> findByDatumOdchodu(LocalDate datumOdchodu) {
        String objednavka_findByDatumOdchodu = "SELECT * FROM objednavky "
                + "WHERE datum_odchodu = " + datumOdchodu;
        return jdbcTemplate.query(objednavka_findByDatumOdchodu, new ObjednavkaRowMapper());
    }

    @Override
    public List<Objednavka> findByPocetDni(int pocetDni) {
        String objednavka_findByDatumPocetDni = "SELECT * FROM objednavky "
                + "WHERE pocet_dni = " + pocetDni;
        return jdbcTemplate.query(objednavka_findByDatumPocetDni, new ObjednavkaRowMapper());
    }

    @Override
    public List<Objednavka> findByPlatba(boolean platba) {
        String objednavka_findByPlatba = "";
        if (platba == true) {
            objednavka_findByPlatba = "SELECT * FROM objednavky "
                    + "WHERE platba = " + 1;
        } else {
            objednavka_findByPlatba = "SELECT * FROM objednavky "
                    + "WHERE platba = " + 0;
        }
        return jdbcTemplate.query(objednavka_findByPlatba, new ObjednavkaRowMapper());
    }

    private class ObjednavkaRowMapper implements RowMapper<Objednavka> {

        @Override
        public Objednavka mapRow(ResultSet rs, int i) throws SQLException {
            Objednavka o = new Objednavka();
            o.setId(rs.getLong(1));
            o.setPozemokId(rs.getLong(2));
            o.setPouzivatelId(rs.getLong(3));
            o.setDatumObjednavky((LocalDate) rs.getDate(4).toLocalDate());
            o.setDatumPrichodu((LocalDate) rs.getDate(5).toLocalDate());
            o.setDatumOdchodu((LocalDate) rs.getDate(4).toLocalDate());
            o.setPocetDni(rs.getLong(7));
            if (rs.getInt(8) == 1) {
                o.setPlatba(true);
            } else {
                o.setPlatba(false);
            }
            return o;
        }

    }

    public static void main(String[] args) {
        MySqlObjednavkaDao ms = (MySqlObjednavkaDao) CampingDaoFactory.INSTANCE.getMySqlObjednavkaDao();
        List<Objednavka> objednavky = ms.getAll();
        for (Objednavka objednavka : objednavky) {
            System.out.println(objednavka);
        }

    }
}
