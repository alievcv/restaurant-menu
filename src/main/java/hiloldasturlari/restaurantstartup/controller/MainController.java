package hiloldasturlari.restaurantstartup.controller;


import hiloldasturlari.restaurantstartup.entity.Meal;
import hiloldasturlari.restaurantstartup.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MainController {


    @Autowired
    private MainService mainService;

    @GetMapping("/top-meals")
    public ResponseEntity<List<Meal>> getTopMeals() {
        return mainService.getTopMeals();
    }

    @GetMapping("/meals-with-discount")
    public ResponseEntity<List<Meal>> getMealsWithDiscount() {
        return mainService.getMealsWithDiscount();
    }


    @GetMapping("/meals-by-category")
    public ResponseEntity<List<Meal>> getMealsByCategory(@RequestParam(value = "category") String category) {
        return mainService.getMealsByCategory(category);
    }

    @GetMapping("/meal-by-id/{id}")
    public ResponseEntity<Meal> getMealById(@PathVariable(value = "id") Long id) {
        return mainService.getMealById(id);
    }
}
//Har bitta stol uchun alohida QR-code commentlar qaysi stoldan keganini bilish uchun
//Bitta telefonga hammaniki tushadi
// category view