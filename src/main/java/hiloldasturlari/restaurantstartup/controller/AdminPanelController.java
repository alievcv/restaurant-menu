package hiloldasturlari.restaurantstartup.controller;

import hiloldasturlari.restaurantstartup.entity.Meal;
import hiloldasturlari.restaurantstartup.service.MainService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin-panel")
public class AdminPanelController {

    @Autowired
    private MainService mainService;


    @GetMapping
    public ResponseEntity<List<Meal>> getMeals() {
        return mainService.getMeals();
    }

    @GetMapping("/meals-by-category")
    public ResponseEntity<List<Meal>> getMealsByCategory(@RequestParam(value = "category") String category) {
        return mainService.getMealsByCategory(category);
    }

    @GetMapping("/meal-by-id/{id}")
    public ResponseEntity<Meal> getMealById(@PathVariable(value = "id") Long id) {
        return mainService.getMealById(id);
    }

    @GetMapping("meal-by-name")
    public ResponseEntity<Meal> getMealByName(@RequestParam(value = "name") String name) {
        return mainService.getMealByName(name);
    }

    @PostMapping("/add-meal")
    public void addMeal(@RequestBody Meal meal) {
        mainService.addMeal(meal);
    }

    @Operation(summary = "Ovqatni nomi va necha pul ayirish kk skidka qilish uchun")
    @PostMapping("/discount-by-meal-name-and-price")
    public void discountByNameAndPrice(@RequestParam(value = "meal-name") String mealName, @RequestParam Integer discount) {
        mainService.setDiscountByPrice(mealName, discount);
    }

    @Operation(summary = "Ovqatni nomi va foizlik discount")
    @PostMapping("/discount-by-meal-name-and-percentage")
    public void discountByNameAndPercentage(@RequestParam(value = "meal-name") String mealName, @RequestParam Integer percentage) {
        mainService.setDiscountByPercentage(mealName, percentage);
    }

    @PutMapping("/update-meal")
    public void updateMeal(@RequestBody Meal meal) {
        mainService.updateMeal(meal);
    }

    @DeleteMapping("/delete-meal/{id}")
    public void deleteMeal(@PathVariable(value = "id") Long id) {
        mainService.deleteMeal(id);
    }
}
