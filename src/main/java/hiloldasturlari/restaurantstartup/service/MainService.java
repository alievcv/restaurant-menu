package hiloldasturlari.restaurantstartup.service;

import hiloldasturlari.restaurantstartup.entity.Meal;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MainService {

    ResponseEntity<List<Meal>> getTopMeals();

    ResponseEntity<List<Meal>> getMealsWithDiscount();

    ResponseEntity<List<Meal>> getMeals();

    ResponseEntity<List<Meal>> getMealsByCategory(String categoryName);

    ResponseEntity<Meal> getMealById(Long id);

    ResponseEntity<Meal> getMealByName(String name);

    void addMeal(Meal meal);

    void updateMeal(Meal meal);

    void deleteMeal(Long id);

    void setDiscountByPrice(String mealName, Integer discount);

    void setDiscountByPercentage(String mealName, Integer percentage);
}
