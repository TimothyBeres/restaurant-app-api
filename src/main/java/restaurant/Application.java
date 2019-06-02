package restaurant;

import org.aspectj.weaver.ast.Or;
import restaurant.model.FoodItem;
import restaurant.model.OfferItem;
import restaurant.model.OrderItem;
import restaurant.repository.FoodItemRepository;
import restaurant.repository.OfferItemRepository;
import restaurant.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import restaurant.model.FoodItem;
import restaurant.model.OrderItem;
import restaurant.repository.FoodItemRepository;
import restaurant.repository.OfferItemRepository;
import restaurant.repository.OrderRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Application {

    private static Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner initCars(FoodItemRepository foodItems,
                                      OrderRepository orderItems,
                                      OfferItemRepository offerItems) {
        return (args) -> {
            // save a couple of cars
            logger.info("adding 1 food item");
            FoodItem food = new FoodItem("Chkn Wings", "Hot wings", 15.3, "Appertizer");
            foodItems.save(food);
            List<FoodItem> foods = new ArrayList<>();
            foods.add(food);
            orderItems.save(new OrderItem("marko jagor", foods));
        };
    }
}
