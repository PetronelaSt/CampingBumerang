package camping.dao;

import camping.entities.Heslo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.xml.bind.DatatypeConverter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.crypto.bcrypt.BCrypt;

public class MySqlHesloDao implements HesloDao {

    private JdbcTemplate jdbcTemplate;

    MySqlHesloDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void createHeslo(Heslo heslo) {
        String heslo_update = "INSERT INTO hesla (uzivatel, heslo, sol) VALUES (?, ?, ?)";
        String sol = BCrypt.gensalt();
        String hash = BCrypt.hashpw(heslo.getHeslo(), sol);
        jdbcTemplate.update(heslo_update, heslo.getUzivatel(), hash, sol);

    }

    @Override
    public void updateHeslo(Heslo heslo) {
        String heslo_update = "UPDATE hesla SET uzivatel = ?, heslo = ?, sol = ? WHERE id = ?";
        String sol = BCrypt.gensalt();
        String hash = BCrypt.hashpw(heslo.getHeslo(), sol);
        jdbcTemplate.update(heslo_update, heslo.getUzivatel(), hash, sol, heslo.getId());

    }
//TODOOOOOOOOOOOOO

    @Override
    public List<Heslo> getAll() {
        String heslo_get = "SELECT * FROM hesla";

        return jdbcTemplate.query(heslo_get, new HesloRowMapper());
    }

    @Override
    public List<String> findByUzivatel(String uzivatel) {
        String heslo_findByUzivatel = "SELECT * FROM hesla "
                + "WHERE uzivatel = " + "'" + uzivatel + "'";
        List<Heslo> hesla = jdbcTemplate.query(heslo_findByUzivatel, new HesloRowMapper());
        if (hesla.size() < 1) {
            JOptionPane.showMessageDialog(null, "Nenasiel sa uzivatel");
        }
        String heslo = "";
        String sol = "";
        for (Heslo heslo1 : hesla) {
            if (heslo1.getUzivatel().equals(uzivatel)) {
                heslo = heslo1.getHeslo();
                sol = heslo1.getSol();
            }
        }
        List<String> passwords = new ArrayList<>();
        passwords.add(heslo);
        passwords.add(sol);
        
        return passwords;
    }

    @Override
    public boolean deleteHesloById(long id) {
        String heslo_delete = "DELETE FROM hesla WHERE id = " + id;
        int zmazanych = jdbcTemplate.update(heslo_delete);
        return zmazanych == 1;
    }

    private class HesloRowMapper implements RowMapper<Heslo> {

        @Override
        public Heslo mapRow(ResultSet rs, int i) throws SQLException {
            Heslo h = new Heslo();
            h.setId(rs.getLong(1));
            h.setUzivatel(rs.getString(2));
            h.setHeslo(rs.getString(3));
            h.setSol(rs.getString(4));
            return h;
        }

    }

}
