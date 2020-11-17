package pl.bykowski.pdt4th.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping
    public String getMenu() {
        return "menu";
    }
}
