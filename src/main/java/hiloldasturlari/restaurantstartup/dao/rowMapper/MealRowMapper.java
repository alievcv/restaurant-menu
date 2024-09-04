package hiloldasturlari.restaurantstartup.dao.rowMapper;

import hiloldasturlari.restaurantstartup.entity.Meal;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MealRowMapper implements RowMapper<Meal> {
    @Override
    public Meal mapRow(ResultSet rs, int rowNum) throws SQLException {
        Meal meal = new Meal();
        meal.setId(rs.getLong("id"));
        meal.setName(rs.getString("name"));
        meal.setDescription(rs.getString("description"));
        meal.setPrice(rs.getDouble("price"));
        meal.setViewed(rs.getLong("viewed"));
        meal.setPriceWithDiscount(rs.getDouble("price_with_discount"));
        meal.setImageUrl(rs.getString("image_url"));
        return meal;
    }
}
