package pl.bykowski.pdt4th.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import pl.bykowski.pdt4th.model.Car;
import pl.bykowski.pdt4th.model.MarketData;
import pl.bykowski.pdt4th.model.MarketModel;
import pl.bykowski.pdt4th.service.CarService;
import pl.bykowski.pdt4th.service.MarketService;

import java.util.List;
import java.util.stream.Collectors;


@Controller
@RequestMapping("/market")
public class MarketController {

    private final MarketService marketService;
    private final CarService carService;

    @Autowired
    public MarketController(MarketService marketService, CarService carService) {
        this.marketService = marketService;
        this.carService = carService;
    }

    @GetMapping
    public String getMarksList() {
        return "marketMarks";
    }

    @GetMapping("/{id}")
    public String getModelsList(Model model, @PathVariable int id, @RequestParam(required = false, defaultValue = "") String marketModel) {
        List<MarketModel> models = marketService.getMarketData(id).getResults();
        model.addAttribute("markId", models.get(0).getMakeID());

        if (!marketModel.isEmpty()) {
            models = models.stream().filter(m -> m.getModelName().toUpperCase().equals(marketModel.toUpperCase())).collect(Collectors.toList());
        }
        model.addAttribute("marketModels", models);
        model.addAttribute("car", new Car());

        return "marketModels";
    }

    @PostMapping("/{id}/add/{modelIdToAdd}")
    public String addCarFromMarket(@PathVariable int id, @PathVariable int modelIdToAdd, @ModelAttribute Car car) {
        MarketModel modelToAdd = marketService.getMarketData(id).getResults().stream().filter(m -> m.getModelID() == modelIdToAdd).findFirst().get();

        car.setMark(modelToAdd.getMakeName());
        car.setModel(modelToAdd.getModelName());

        carService.addCar(car);

        return "redirect:/market/{id}";
    }

}
