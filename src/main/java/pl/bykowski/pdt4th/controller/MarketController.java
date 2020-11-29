package pl.bykowski.pdt4th.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.bykowski.pdt4th.model.Car;
import pl.bykowski.pdt4th.model.Color;
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

    @GetMapping("/{markId}")
    public String getModelsList(Model model, @PathVariable int markId,
                                @ModelAttribute("flashAttr") String flashAttr,
                                @ModelAttribute("flashAttrAdd") String added,
                                @RequestParam(required = false, defaultValue = "") String searchModel) {
        List<MarketModel> models = marketService.getMarkById(markId).getResults();
        model.addAttribute("markId", models.get(0).getMakeID());

        if (!searchModel.isEmpty()) {
            models = models.stream().filter(m -> m.getModelName().toUpperCase().equals(searchModel.toUpperCase())).collect(Collectors.toList());
        }
        model.addAttribute("marketModels", models);
        model.addAttribute("car", new Car());
        model.addAttribute("msg", flashAttr);
        model.addAttribute("added", added);

        return "marketModels";
    }

    @PostMapping("/{markId}/add/{modelId}")
    public String addCarFromMarket(@ModelAttribute Car car, @PathVariable int markId, @PathVariable int modelId, RedirectAttributes ra) {
        MarketModel modelToAdd = marketService.getModelByMarkIdAndModelId(markId, modelId);

        if (modelToAdd != null) {
            car.setMark(modelToAdd.getMakeName());
            car.setModel(modelToAdd.getModelName());

            boolean add = carService.addCar(car);
            if (add) {
                ra.addFlashAttribute("flashAttr", "Car: " + car.getMark() + " " + car.getModel() + " succesfully added");
                ra.addFlashAttribute("flashAttrAdd", true);
            } else {
                ra.addFlashAttribute("flashAttr", "Car: " + car.getMark() + " " + car.getModel() + " failed to add");
                ra.addFlashAttribute("flashAttrAdd", false);
            }
        } else {
            ra.addFlashAttribute("flashAttr", "Car with id: " + modelId + " not found.");
            ra.addFlashAttribute("flashAttrAdd", false);
        }

        return "redirect:/market/{markId}";
    }

}
