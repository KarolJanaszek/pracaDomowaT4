package pl.bykowski.pdt4th.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.bykowski.pdt4th.model.Car;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class CarDaoImplWithNoDb implements CarDao {

    private List<Car> carList;

    @Autowired
    public CarDaoImplWithNoDb() {
        carList = new ArrayList<>();
    }

    @Override
    public boolean saveCar(Car car) {
        Optional<Car> carId = carList.stream().max(Comparator.comparing(Car::getCarId));
        if (carId.isPresent()) {
            car.setCarId(carId.get().getCarId() + 1);
        } else {
            car.setCarId(0);
        }

        boolean added = carList.add(car);
        if (!added) {
            return false;
        }
        return true;
    }

    @Override
    public List<Car> findAllCars() {
        return carList;
    }

    @Override
    public List<Car> findCarsBetweenProdYears(int beginYear, int endYear) {
        return carList.stream()
                .filter(y -> LocalDate.parse(y.getProdDate()).isAfter(LocalDate.of(beginYear, 1, 1)))
                .filter(y -> LocalDate.parse(y.getProdDate()).isBefore(LocalDate.of(endYear, 12, 31)))
                .collect(Collectors.toList());
    }

    @Override
    public List<Car> findCarsFromProdYears(int beginYear) {
        return carList.stream()
                .filter(y -> LocalDate.parse(y.getProdDate()).isAfter(LocalDate.of(beginYear, 1, 1)))
                .collect(Collectors.toList());
    }

    @Override
    public List<Car> findCarsToProdYears(int endYear) {
        return carList.stream()
                .filter(y -> LocalDate.parse(y.getProdDate()).isBefore(LocalDate.of(endYear, 12, 31)))
                .collect(Collectors.toList());
    }

    @Override
    public void updateCar(Car carToUpdate) {
        Car car = getCarById(carToUpdate.getCarId());
        if (car != null) {
            if (carToUpdate.getMark() != null) {
                car.setMark(carToUpdate.getMark());
            }
            if (carToUpdate.getModel() != null) {
                car.setModel(carToUpdate.getModel());
            }
            if (carToUpdate.getColor() != null) {
                car.setColor(carToUpdate.getColor());
            }
            if (carToUpdate.getProdDate() != null) {
                car.setProdDate(carToUpdate.getProdDate());
            }
        }
    }

    @Override
    public void deleteCar(Long id) {
        Car car = getCarById(id);
        if (car != null) {
            carList.remove(car);
        }
    }

    @Override
    public Car getCarById(Long id) {
        Optional<Car> first = carList.stream().filter(c -> c.getCarId() == id).findFirst();
        if (first.isPresent()) {
            return first.get();
        }
        return null;
    }

}
