package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.dao.CarDAO;
import web.service.CarService;

@Controller
@RequestMapping(value = "/cars")
public class CarController {
    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping()
    public String showListCar(@RequestParam(value = "count", defaultValue = "5") int count, Model model) {
        if ((count >= 0) & (count <= 5)) {
            model.addAttribute("listOfCars", carService.getCarsList(count));
            return "index_cars";
        }
        model.addAttribute("listOfCars", carService.getCarsList(5));
        return "index_cars";
    }

}
