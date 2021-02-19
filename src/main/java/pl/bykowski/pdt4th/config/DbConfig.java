package pl.bykowski.pdt4th.config;

import javax.sql.DataSource;

//@Configuration
public class DbConfig {

    /*
    Wyłączenie łączenia z DB, bo nie mam darmowego SQL DB
     */

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

//    private DataSource dataSource;
//
//    //@Autowired
//    public DbConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }
//
//    @Bean
//    public JdbcTemplate jdbcTemplate() {
//        return new JdbcTemplate(dataSource);
//    }

//    @EventListener(ApplicationReadyEvent.class)
//    public void init(){
//        String sql = "CREATE TABLE cars (id int, mark varchar(255), model varchar(255), color varchar (255), PRIMARY KEY (id))";
//        jdbcTemplate().update(sql);
//    }

}
