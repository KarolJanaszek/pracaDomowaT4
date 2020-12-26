package pl.bykowski.pdt4th.repository;

import pl.bykowski.pdt4th.model.Car;

import java.util.List;

//CRUD
public interface CarDao {
    boolean saveCar(Car car);
    List<Car> findAllCars();
    List<Car> findCarsBeetweenProdYears(int beginYear, int endYear);
    List<Car> findCarsFromProdYears(int beginYear);
    List<Car> findCarsToProdYears(int endYear);
    void updateCar(Car car);
    void deleteCar(Long id);

    Car getCarById(Long id);
}
