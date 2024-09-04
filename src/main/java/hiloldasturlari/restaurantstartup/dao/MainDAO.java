package hiloldasturlari.restaurantstartup.dao;

import hiloldasturlari.restaurantstartup.entity.Meal;

import java.util.List;

public interface MainDAO {


    List<Meal> findTopMeals();

    List<Meal> findMealsWithDiscount();

    List<Meal> getMeals();

    List<Meal> getMealsByCategory(String category);

    Meal getMealById(Long id);

    Meal getMealByName(String name);

    void addMeal(Meal meal);

    void insertDiscountByPercentage(String mealname, Integer discount);

    void insertDiscountByPrice(String mealname, Integer price);

    void updateMeal(Meal meal);

    void deleteMeal(Long id);


}
