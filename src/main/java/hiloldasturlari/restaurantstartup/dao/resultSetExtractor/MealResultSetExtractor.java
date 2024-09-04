package hiloldasturlari.restaurantstartup.dao.resultSetExtractor;

import hiloldasturlari.restaurantstartup.entity.Meal;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MealResultSetExtractor implements ResultSetExtractor<List<Meal>> {
    @Override
    public List<Meal> extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<Meal> meals = new ArrayList<Meal>();
        while (rs.next()) {
            Meal meal = new Meal();
            meal.setId(rs.getLong("id"));
            meal.setName(rs.getString("name"));
            meal.setDescription(rs.getString("description"));
            meal.setPrice(rs.getDouble("price"));
            meal.setViewed(rs.getLong("viewed"));
            meal.setPriceWithDiscount(rs.getDouble("price_with_discount"));
            meal.setImageUrl(rs.getString("image_url"));
            meals.add(meal);
        }
        return meals;
    }
}
