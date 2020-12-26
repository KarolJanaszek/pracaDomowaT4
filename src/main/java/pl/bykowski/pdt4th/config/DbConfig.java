package pl.bykowski.pdt4th.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DbConfig {

//    Definiowanie dla jednej bazy danych. Gdy kilka, lepiej przez app properties
//    @Bean
//    public DataSource getDataSource() {
//        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
//        dataSourceBuilder.url("jdbc:mysql://sql2.freemysqlhosting.net:3306/sql2379848")
//                .username("sql2379848")
//                .password("dI2*dC5*")
//                .driverClassName("com.mysql.cj.jdbc.Driver");
//        return dataSourceBuilder.build();
//    }

    private DataSource dataSource;

    @Autowired
    public DbConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource);
    }

//    @EventListener(ApplicationReadyEvent.class)
//    public void init(){
//        String sql = "CREATE TABLE cars (id int, mark varchar(255), model varchar(255), color varchar (255), PRIMARY KEY (id))";
//        jdbcTemplate().update(sql);
//    }

}
