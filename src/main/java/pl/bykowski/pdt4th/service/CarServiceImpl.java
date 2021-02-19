package pl.bykowski.pdt4th.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pl.bykowski.pdt4th.model.Car;
import pl.bykowski.pdt4th.repository.CarDao;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    private CarDao carDao;

    @Autowired
    public CarServiceImpl(@Qualifier("carDaoImplWithNoDb") CarDao carDao) {
        this.carDao = carDao;
    }

    @Override
    public List<Car> getAllCars() {
        return carDao.findAllCars();
    }

    @Override
    public Optional<Car> getCarById(long id) {
        return getAllCars()
                .stream()
                .filter(car -> car.getCarId() == id)
                .findFirst();
    }

    @Override
    public List<Car> getCarsByColor(String color) {
        return getAllCars()
                .stream()
                .filter(car -> color.equalsIgnoreCase(car.getColor().name()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Car> getCarsByYear(int beginYear, int endYear) {
        if (beginYear != 0 && endYear != 0) {
            return carDao.findCarsBetweenProdYears(beginYear, endYear);
        } else if (beginYear != 0) {
            return carDao.findCarsFromProdYears(beginYear);
        } else if (endYear != 0) {
            return carDao.findCarsToProdYears(endYear);
        }
        return getAllCars();
    }

    @Override
    public boolean addCar(Car car) {
        return carDao.saveCar(car);
    }

    @Override
    public void removeCar(Long id) {
        carDao.deleteCar(id);
    }

    @Override
    public void updateCar(Car car) {
        carDao.updateCar(car);
    }

}
