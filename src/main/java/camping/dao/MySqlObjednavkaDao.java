package camping.dao;

import camping.entities.Objednavka;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class MySqlObjednavkaDao implements ObjednavkaDao {
    
    private JdbcTemplate jdbcTemplate;
    
    public MySqlObjednavkaDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    @Override
    public void createObjednavku(Objednavka objednavka) {
        
    }
    
    @Override
    public List<Objednavka> getAll() {
        String objednavka_getAll = "SELECT * FROM objednavky";
        return jdbcTemplate.query(objednavka_getAll, new RowMapper<Objednavka>() {
            @Override
            public Objednavka mapRow(ResultSet rs, int i) throws SQLException {
                Objednavka o = new Objednavka();
                o.setId(rs.getLong(1));
                o.setPozemokId(rs.getLong(2));
                o.setPouzivatelId(rs.getLong(3));
                o.setDatumObjednavky(rs.getTimestamp(4).toLocalDateTime());
                o.setDatumPrichodu(rs.getTimestamp(5).toLocalDateTime());
                o.setDatumOdchodu(rs.getTimestamp(6).toLocalDateTime());
                o.setPocetDni(rs.getLong(7));
                if (rs.getInt(8) == 1) {
                    o.setPlatba(true);
                } else {
                    o.setPlatba(false);
                }
                return o;
            }
        });
    }
    
    @Override
    public void updateObjednavku(Objednavka objednavka) {
        
    }
    
    @Override
    public void deleteObjednavku(Objednavka objednavka) {
        
    }
    
    @Override
    public void findById(Long id) {
        
    }
    public static void main(String[] args) {
        MySqlObjednavkaDao ms = (MySqlObjednavkaDao) CampingDaoFactory.INSTANCE.getMySqlObjednavkaDao();
        List<Objednavka> objednavky = ms.getAll();
        for (Objednavka objednavka : objednavky) {
            System.out.println(objednavka);
        }
        
    }
}
