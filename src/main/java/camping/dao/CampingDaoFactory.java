package camping.dao;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

public enum CampingDaoFactory {
    INSTANCE;

    private JdbcTemplate jdbcTemplate;

    private JdbcTemplate getJDBCTemplate() {
        if (jdbcTemplate == null) {
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setUser("CampingUser");
            dataSource.setPassword("campingbumerang");
            dataSource.setUrl("jdbc:mysql://localhost/campingsql?serverTimezone=Europe/Bratislava");

            jdbcTemplate = new JdbcTemplate(dataSource);
        }
        return jdbcTemplate;
    }

    public PozemokDao getMySqlPozemokDao() {
        return new MySqlPozemokDao(getJDBCTemplate());
        
    }

    public ObjednavkaDao getMySqlObjednavkaDao() {
        return new MySqlObjednavkaDao(getJDBCTemplate());
    }

    public PouzivatelDao getMySqlPouzivatelDao() {
        return new MySqlPouzivatelDao(getJDBCTemplate());
    }

}
