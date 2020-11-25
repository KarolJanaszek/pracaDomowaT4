package pl.bykowski.pdt4th.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.bykowski.pdt4th.model.Car;
import pl.bykowski.pdt4th.service.CarService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/cars")
public class CarController {

    private CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public String getCars(Model model, @RequestParam(required = false, defaultValue = "") String color) {
        List<Car> allCars = carService.getAllCars();
        if (!color.isEmpty()) {
            allCars = carService.getCarsByColor(color);
        }
        model.addAttribute("cars", allCars);
        return "cars";
    }

    @GetMapping("/{id}")
    public String getCarById(Model model, @PathVariable long id) {
        Car carSelected = carService.getCarById(id).get();
        if (carSelected != null) {
            model.addAttribute("car", carSelected);
            return "carShow";
        }
        return "redirect:/cars";
    }

    @GetMapping("/addCar")
    public String addNewCar(Model model) {
        model.addAttribute("car", new Car());
        return "addCar";
    }

    @PostMapping("/addCar")
    public String addCar(Model model, @ModelAttribute Car car) {
        if (car.getMark().isEmpty() || car.getModel().isEmpty()) {
            return "redirect:/cars/addCar";
        }
        boolean add = carService.addCar(car);
        if (add) {
            return "redirect:/cars";
        }
        return "redirect:/cars/addCar";
    }

    @GetMapping("/edit/{id}")
    public String modifyCarView(Model model, @PathVariable long id) {
        Optional<Car> first = carService.getAllCars().stream().filter(car -> car.getCarId() == id).findFirst();
        if (first.isPresent()) {
            model.addAttribute("editedCar", first.get());
            return "carEdit";
        }
        return "redirect:/cars";
    }

    @PostMapping("/edit/{id}")
    public String modifyCar(@ModelAttribute Car editedCar, @PathVariable long id) {
        Car first = carService.getAllCars().stream().filter(car -> car.getCarId() == id).findFirst().get();
        if (!editedCar.getMark().isEmpty()) {first.setMark(editedCar.getMark());}
        if (!editedCar.getModel().isEmpty()) {first.setModel(editedCar.getModel());}
        first.setColor(editedCar.getColor());
        return "redirect:/cars";
    }

    @GetMapping("/delete/{id}")
    public String removeCar(@PathVariable long id) {
        Optional<Car> first = carService.getAllCars().stream().filter(car -> car.getCarId() == id).findFirst();
        if (first.isPresent()) {
            carService.removeCar(first.get());
        }
        return "redirect:/cars";
    }

}
