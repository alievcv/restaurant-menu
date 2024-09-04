package hiloldasturlari.restaurantstartup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RestaurantStartupApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestaurantStartupApplication.class, args);
    }

}
