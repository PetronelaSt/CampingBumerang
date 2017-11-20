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
        String objednavka_create = "INSERT INTO objednavky(pozemky_id, pouzivatel_id, datum_objednavky, datum_prichodu, datum_odchodu, pocet_dni, platba) VALUE(?, ?, ?, ?, ?, ?, ?)";
        try {
            if (objednavka.isPlatba()) {
                jdbcTemplate.update(objednavka_create, objednavka.getPozemokId(), objednavka.getPouzivatelId(), objednavka.getDatumObjednavky(), objednavka.getDatumPrichodu(), objednavka.getDatumOdchodu(), objednavka.getPocetDni(), 1);
            } else {
                jdbcTemplate.update(objednavka_create, objednavka.getPozemokId(), objednavka.getPouzivatelId(), objednavka.getDatumObjednavky(), objednavka.getDatumPrichodu(), objednavka.getDatumOdchodu(), objednavka.getPocetDni(), 0);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Objednavka" + objednavka.getId() + "sa nepodarilo vlozit");
        }
        JOptionPane.showMessageDialog(null, "Objednavka sa uspesne ulozila do databazy");

    }

    @Override
    public List<Objednavka> getAll() {
        String objednavka_getAll = "SELECT * FROM objednavky";
        return jdbcTemplate.query(objednavka_getAll, new ObjednavkaRowMapper());
    }

    @Override
    public void updateObjednavku(Objednavka objednavka) {
        String objednavka_update = "UPDATE pouzivatel SET pozemok_id = ?, pouzivatel_id = ?, datum_objednavky = ?, datum_prichodu = ?, datum_odchodu = ?, pocet_dni = ?, platba = ? WHERE id = ?";
        if (objednavka.isPlatba()) {
            jdbcTemplate.update(objednavka_update, objednavka.getPozemokId(), objednavka.getPouzivatelId(), objednavka.getDatumObjednavky(), objednavka.getDatumPrichodu(), objednavka.getDatumOdchodu(), objednavka.getPocetDni(), 1);
        } else {
            jdbcTemplate.update(objednavka_update, objednavka.getPozemokId(), objednavka.getPouzivatelId(), objednavka.getDatumObjednavky(), objednavka.getDatumPrichodu(), objednavka.getDatumOdchodu(), objednavka.getPocetDni(), 0);
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
