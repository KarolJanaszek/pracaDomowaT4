package pl.bykowski.pdt4th.service;

import pl.bykowski.pdt4th.model.Car;

import java.util.List;
import java.util.Optional;

public interface CarService {
    List<Car> getAllCars();
    Optional<Car> getCarById(long id);
    List<Car> getCarsByColor(String color);
    List<Car> getCarsByYear(int beginYear, int endYear);
    boolean addCar(Car car);
    void removeCar(Long id);
    void updateCar(Car car);
}
