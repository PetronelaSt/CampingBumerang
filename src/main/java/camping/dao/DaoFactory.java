package camping.dao;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public enum DaoFactory {

    INSTANCE;

    private JdbcTemplate jdbcTemplate;

    private JdbcTemplate getJDBCTemplate() {
        if (jdbcTemplate == null) {
            MysqlDataSource dataSource = new MysqlDataSource();
            // tu pojde nastavenie mena a hesla uzivatela k databaze
            dataSource.setUrl("jdbc:mysql://localhost/prezenckovnik?serverTimezone=Europe/Bratislava");

            jdbcTemplate = new JdbcTemplate(dataSource);
        }
        return jdbcTemplate;
    }

    // tu pojdu triedyDao pre Camping
}
