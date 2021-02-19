package pl.bykowski.pdt4th.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.bykowski.pdt4th.model.Car;
import pl.bykowski.pdt4th.service.CarService;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@RestController
@RequestMapping(value = "/api/cars", produces = {MediaType.APPLICATION_JSON_VALUE})
public class CarApi {
    private final CarService carService;

    @Autowired
    public CarApi(CarService carService) {
        this.carService = carService;
    }

    //(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @GetMapping
    public ResponseEntity<Resources<Car>> getCars() {
        List<Car> allCars = carService.getAllCars();
        if (allCars.stream().noneMatch(ResourceSupport::hasLinks)) {
            allCars.forEach(car -> car.add(linkTo(CarApi.class).slash(car.getCarId()).withSelfRel()));
        }
        Link link = linkTo(CarApi.class).withSelfRel();
        Resources<Car> carResources = new Resources<>(allCars, link);
        return new ResponseEntity<>(carResources, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resource<Car>> getCarById(@PathVariable long id) {
        Link link = linkTo(CarApi.class).slash(id).withSelfRel();
        Optional<Car> carSelected = carService.getCarById(id);
        if (carSelected.isPresent()) {
            Resource<Car> carResource = new Resource<>(carSelected.get(), link);
            return new ResponseEntity<>(carResource, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/color/{color}")
    public ResponseEntity<Resources<Car>> getCarsByColor(@PathVariable String color) {
        List<Car> carsSelected = carService.getCarsByColor(color);
        carsSelected.forEach(car -> car.add(linkTo(CarApi.class).slash(car.getCarId()).withSelfRel()));
        carsSelected.forEach(car -> car.add(linkTo(CarApi.class).withRel("allColors")));
        Link link = linkTo(CarApi.class).withSelfRel();
        Resources<Car> carResources = new Resources<>(carsSelected, link);
        if (carsSelected.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(carResources, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity addCar(@Validated @RequestBody Car car) {
        boolean add = carService.addCar(car);
        if (add) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping
    public ResponseEntity modifyCar(@Validated @RequestBody Car modCar) {
        Optional<Car> carSelected = carService.getAllCars().stream().filter(car -> car.getId() == modCar.getId()).findFirst();
        if (carSelected.isPresent()) {
            carService.removeCar(carSelected.get().getCarId());
            carService.addCar(modCar);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @PatchMapping
    public ResponseEntity modifyCarElement(@RequestBody Car modCar) {
        Optional<Car> carSelected = carService.getAllCars().stream().filter(car -> car.getId() == modCar.getId()).findFirst();
        if (carSelected.isPresent()) {
            if (modCar.getColor() != null) {
                carSelected.get().setColor(modCar.getColor());
            }
            if (modCar.getMark() != null) {
                carSelected.get().setMark(modCar.getMark());
            }
            if (modCar.getModel() != null) {
                carSelected.get().setModel(modCar.getModel());
            }
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity removeCar(@PathVariable long id) {
        Optional<Car> first = carService.getAllCars().stream().filter(car -> car.getCarId() == id).findFirst();
        if (first.isPresent()) {
            carService.removeCar(first.get().getCarId());
            return new ResponseEntity<>(first.get(), HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

}
