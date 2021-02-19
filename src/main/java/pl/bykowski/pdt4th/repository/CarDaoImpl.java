package pl.bykowski.pdt4th.repository;

import org.springframework.stereotype.Repository;

@Repository
public class CarDaoImpl
        //implements CarDao
{

    /*
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CarDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public boolean saveCar(Car car) {
        try {
            String sql = "INSERT INTO cars VALUES(null,'" + car.getMark() + "','" + car.getModel() + "','" + car.getColor() + "',?)";
            jdbcTemplate.update(sql, car.getProdDate());
        } catch (DataAccessException e) {
            return false;
        }
        return true;
    }

    @Override
    public List<Car> findAllCars() {
        String sql = "SELECT * FROM cars";
        return fillCarListByQuery(sql);
    }

    @Override
    public List<Car> findCarsBetweenProdYears(int beginYear, int endYear) {
        endYear++;
        String sql = "SELECT * FROM cars c WHERE c.PROD_DATE >= '" + beginYear + "-01-01' AND c.PROD_DATE < '" + endYear + "-01-01'";
        return fillCarListByQuery(sql);
    }

    @Override
    public List<Car> findCarsFromProdYears(int beginYear) {
        String sql = "SELECT * FROM cars c WHERE c.PROD_DATE >= '" + beginYear + "-01-01'";
        return fillCarListByQuery(sql);
    }

    @Override
    public List<Car> findCarsToProdYears(int endYear) {
        endYear++;
        String sql = "SELECT * FROM cars c WHERE c.PROD_DATE < '" + endYear + "-01-01'";
        return fillCarListByQuery(sql);
    }

    @Override
    public void updateCar(Car car) {
        String sql = "UPDATE cars c SET c.MODEL = ?, c.MARK = ?, c.COLOR = '" + car.getColor() + "', c.PROD_DATE = ? WHERE c.ID = ?";
        jdbcTemplate.update(sql, car.getModel(), car.getMark(), car.getProdDate(), car.getCarId());
    }

    @Override
    public void deleteCar(Long id) {
        String sql = "DELETE FROM cars WHERE ID = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public Car getCarById(Long id) {
        String sql = "SELECT * FROM cars WHERE ID = ?";
        Car car = jdbcTemplate.queryForObject(sql,
//                new RowMapper<Car>() {
//                    @Override
//                    public Car mapRow(ResultSet rs, int i) throws SQLException {
//                        return new Car(rs.getLong(1), rs.getString(2), rs.getString(3), Color.valueOf(rs.getString(4)));
//                    }}
                (rs, i) -> new Car(rs.getLong("id"), rs.getString("mark"), rs.getString("model"), Color.valueOf(rs.getString("color")), rs.getDate("prod_date").toLocalDate())
                , id);
        return car;
    }

    private List<Car> fillCarListByQuery(String sql) {
        List<Car> carList = new ArrayList<>();
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        maps.stream().forEach(element -> carList.add(new Car(
                Long.parseLong(String.valueOf(element.get("id"))),
                String.valueOf(element.get("mark")),
                String.valueOf(element.get("model")),
                Color.valueOf(String.valueOf(element.get("color"))),
                LocalDate.parse(element.get("prod_date").toString())
        )));
        return carList;
    }
*/

}
