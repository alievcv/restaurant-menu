package hiloldasturlari.restaurantstartup.dao.impl;

import hiloldasturlari.restaurantstartup.dao.MainDAO;

import hiloldasturlari.restaurantstartup.dao.resultSetExtractor.MealResultSetExtractor;
import hiloldasturlari.restaurantstartup.dao.rowMapper.MealRowMapper;
import hiloldasturlari.restaurantstartup.entity.Meal;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MainDAOImpl implements MainDAO {

    private final JdbcTemplate jdbcTemplate;

    public MainDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Meal> findTopMeals() {
        return List.of();
    }

    @Override
    public List<Meal> findMealsWithDiscount() {
        return List.of();
    }

    @Override
    public List<Meal> getMeals() {
        String sql = "SELECT * FROM meal";
        return jdbcTemplate.query(sql, new MealResultSetExtractor());
    }

    @Override
    public List<Meal> getMealsByCategory(String category) {
        String sql = "SELECT * FROM meal WHERE category = ?";
        return jdbcTemplate.query(sql, new MealResultSetExtractor(), category);
    }

    @Override
    public Meal getMealById(Long id) {
        String sql = "SELECT * FROM meal WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new MealRowMapper(), id);
    }

    @Override
    public Meal getMealByName(String name) {
        String sql = "SELECT * FROM meal WHERE name = ?";
        return jdbcTemplate.queryForObject(sql, new MealRowMapper(), name);
    }

    @Override
    public void addMeal(Meal meal) {
        String sql = "Insert INTO meal(name, description, price, imageurl, category) " +
                "VALUES(?,?,?,?,?)";
        Object[] params = {
                meal.getName(),
                meal.getDescription(),
                meal.getPrice(),
                meal.getImageUrl(),
                meal.getCategory()};
        jdbcTemplate.update(sql, params);
    }

    @Override
    public void insertDiscountByPercentage(String mealName, Integer percentage) {
        String sql = "UPDATE meal SET discount_price = price - price * ? WHERE name = ?";
        jdbcTemplate.update(sql, percentage, mealName);
    }

    @Override
    public void insertDiscountByPrice(String mealName, Integer price) {
        String sql = "UPDATE meal SET discount_price = price - ? WHERE name = ?";
        jdbcTemplate.update(sql, price, mealName);
    }

    @Override
    public void updateMeal(Meal meal) {
        String sql = "UPDATE meal SET name = ?, description = ?, price = ? WHERE id = ?";
        Object[] params = {meal.getName(), meal.getDescription(), meal.getPrice()};
        jdbcTemplate.update(sql, params);
    }

    @Override
    public void deleteMeal(Long id) {
        String sql = "DELETE FROM meal WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }


}
