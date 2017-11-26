package camping.dao;

import camping.entities.Heslo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class MySqlHesloDao implements HesloDao {

    private JdbcTemplate jdbcTemplate;

    MySqlHesloDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void createHeslo(Heslo heslo) {
        if (heslo.getId() == null) {
            String heslo_create = "INSERT INTO hesla (uzivatel, heslo) VALUES(?, ?)";
            jdbcTemplate.update(heslo_create, heslo.getUzivatel(), heslo.getHeslo());
        }
    }

    @Override
    public void updateHeslo(Heslo heslo) {
        String heslo_update = "UPDATE hesla SET uzivatel = ?, heslo = ? WHERE id = ?";
        jdbcTemplate.update(heslo_update, heslo.getUzivatel(), heslo.getHeslo(), heslo.getId());

    }

    @Override
    public List<Heslo> getHeslo(String uzivatel) {
        String heslo_get = "SELECT heslo FROM hesla WHERE uzivatel =" + "'" + uzivatel + "'";
        return jdbcTemplate.query(heslo_get, new HesloRowMapper());
    }

    private class HesloRowMapper implements RowMapper<Heslo> {

        @Override
        public Heslo mapRow(ResultSet rs, int i) throws SQLException {
            Heslo h = new Heslo();
            h.setId(rs.getLong(1));
            h.setUzivatel(rs.getString(2));
            h.setHeslo(rs.getString(3));
            return h;
        }

    }
}
