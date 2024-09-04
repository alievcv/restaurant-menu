package hiloldasturlari.restaurantstartup.service.impl;

import hiloldasturlari.restaurantstartup.dao.MainDAO;
import hiloldasturlari.restaurantstartup.entity.Meal;
import hiloldasturlari.restaurantstartup.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainServiceImpl implements MainService {

    @Autowired
    private MainDAO mainDAO;


    @Override
    public ResponseEntity<List<Meal>> getTopMeals() {
        return ResponseEntity.ok().body(mainDAO.findTopMeals());
    }

    @Override
    public ResponseEntity<List<Meal>> getMealsWithDiscount() {
        return ResponseEntity.ok().body(mainDAO.findMealsWithDiscount());
    }

    @Override
    public ResponseEntity<List<Meal>> getMeals() {
        return ResponseEntity.ok().body(mainDAO.getMeals());
    }

    @Override
    public ResponseEntity<List<Meal>> getMealsByCategory(String categoryName) {
        return ResponseEntity.ok().body(mainDAO.getMealsByCategory(categoryName));
    }

    @Override
    public ResponseEntity<Meal> getMealById(Long id) {
        return ResponseEntity.ok().body(mainDAO.getMealById(id));
    }

    @Override
    public ResponseEntity<Meal> getMealByName(String name) {
        return ResponseEntity.ok().body(mainDAO.getMealByName(name));
    }

    @Override
    public void addMeal(Meal meal) {
        mainDAO.addMeal(meal);
    }

    @Override
    public void updateMeal(Meal meal) {
        mainDAO.updateMeal(meal);
    }

    @Override
    public void deleteMeal(Long id) {
        mainDAO.deleteMeal(id);
    }

    @Override
    public void setDiscountByPrice(String mealName, Integer discount) {
        mainDAO.insertDiscountByPrice(mealName, discount);
    }

    @Override
    public void setDiscountByPercentage(String mealName, Integer percentage) {
        mainDAO.insertDiscountByPercentage(mealName, percentage);
    }

}
