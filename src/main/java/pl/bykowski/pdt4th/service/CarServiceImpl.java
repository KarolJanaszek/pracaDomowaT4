package pl.bykowski.pdt4th.service;

import org.springframework.stereotype.Service;
import pl.bykowski.pdt4th.model.Car;
import pl.bykowski.pdt4th.model.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {
    private List<Car> carList;

    public CarServiceImpl() {
        createCars();
    }

    @Override
    public List<Car> getAllCars() {
        return carList;
    }

    @Override
    public Optional<Car> getCarById(long id) {
        return carList
                .stream()
                .filter(car -> car.getCarId() == id)
                .findFirst();
    }

    @Override
    public List<Car> getCarsByColor(String color) {
        return carList
                .stream()
                .filter(car -> color.equalsIgnoreCase(car.getColor().name()))
                .collect(Collectors.toList());
    }

    @Override
    public boolean addCar(Car car) {
        setIdForNewCar(car);
        return carList.add(car);
    }

    @Override
    public void removeCar(Car car) {
        carList.remove(car);
    }

    private void setIdForNewCar(Car car) {
        car.setCarId(carList.stream().mapToLong(c -> c.getCarId()).max().orElseThrow(NoSuchElementException::new)+1);
    }

    private List<Car> createCars() {
        carList = new ArrayList<>();
        carList.add(new Car("Fiat", "Panda", Color.RED));
        carList.add(new Car("Volkswagen", "DasAuto", Color.RED));
        carList.add(new Car("Lada", "Niva", Color.GREEN));
        carList.add(new Car("Volvo", "V40", Color.BLACK));
        carList.add(new Car("Volvo", "C30", Color.BLACK));
        carList.add(new Car("Toyota", "Auris", Color.BLACK));
        carList.add(new Car("Toyota", "Yaris", Color.SILVER));
        carList.add(new Car("Subaru ", "XV", Color.BLUE));
        return carList;
    }
}
