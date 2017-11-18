package camping.dao;

import camping.entities.Pozemok;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

public class MySqlPozemokDao implements PozemokDao {

    private JdbcTemplate jdbcTemplate;

    public MySqlPozemokDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void createPozemok(Pozemok pozemok) {
        String pozemok_create = "INSERT INTO pozemky(cislo_pozemku, kategoria, obsadenost) VALUE(?, ?, ?);";
      
    }

    @Override
    public List<Pozemok> getAll() {
        String pozemok_getAll = "SELECT * FROM pozemky";
        return jdbcTemplate.query(pozemok_getAll, new RowMapper<Pozemok>() {
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
        });

    }

    @Override
    public void updatePozemok(Pozemok pozemok) {
        
    }

    @Override
    public boolean deletePozemokById(Long id) {
        String pozemok_delete = "DELETE FROM pozemky WHERE id = " + id;
        int zmazanych = jdbcTemplate.update(pozemok_delete);    
        return zmazanych == 1;
    }

    @Override
    public List<Pozemok> findById(Long id) {
        String pozemok_findById = "SELECT * FROM pozemky "
                + "WHERE cislo_pozemku = " + id;
        return jdbcTemplate.query(pozemok_findById, new RowMapper<Pozemok>() {
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
        });
    }

    public static void main(String[] args) {
        MySqlPozemokDao ms = (MySqlPozemokDao) CampingDaoFactory.INSTANCE.getMySqlPozemokDao();
        ms.deletePozemokById(7L);

    }
}
