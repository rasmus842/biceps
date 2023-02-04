package ee.biceps.api.config;

import ee.biceps.api.dao.ProductDao;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;
import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;

import javax.sql.DataSource;

@Controller
@ComponentScan({
        "ee.biceps.api.dao",
        "ee.biceps.api.service"})
public class RootConfig {
    /*
    @Bean
    public DataSource dataSource() {
        // TODO - configure datasource
        // can use PgSimpleDataSource
        // install SqlObjectPlugin etc
        // alternatively do not need to use DataSource
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        return dataSource;
    }
     */

    @Bean
    public Jdbi jdbi(){
        // TODO - just load props and configure jdbi here
        // or use DataSource - if I want to use HikariCP aswell
        String url = "jdbc:postgresql://localhost:5432/bicepsdb";
        String user = "biceps";
        String pw = "biceps";
        Jdbi jdbi = Jdbi.create(url, user, pw);
        jdbi.installPlugin(new SqlObjectPlugin());
        return jdbi;
    }

    @Bean
    public ProductDao productDao(Jdbi jdbi) {
        return jdbi.onDemand(ProductDao.class);
    }
}
