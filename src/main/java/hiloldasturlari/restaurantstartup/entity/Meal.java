package hiloldasturlari.restaurantstartup.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.annotation.Id;


@Data
public class Meal {

    @Id
    private Long id;
    @NotNull
    @NotBlank
    @NotEmpty
    private String name;
    @NotNull
    @NotBlank
    @NotEmpty
    private String description;
    @NotNull
    @NotBlank
    @NotEmpty
    private Double price;
    private Long viewed;
    private Double priceWithDiscount;
    @NotNull
    @NotBlank
    @NotEmpty
    private String imageUrl;
    private String category;

}

