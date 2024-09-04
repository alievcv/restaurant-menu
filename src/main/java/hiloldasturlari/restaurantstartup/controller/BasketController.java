package hiloldasturlari.restaurantstartup.controller;

import hiloldasturlari.restaurantstartup.entity.Basket;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/basket")
public class BasketController {

    @PostMapping("/add-basket")
    public void addMealToBasket(Basket basket) {

    }
}
