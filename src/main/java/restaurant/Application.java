package restaurant;

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

import java.lang.reflect.Array;
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
            //save items to menu
            logger.info("adding 1 food item");
            FoodItem food1 = new FoodItem("Chkn Wings", "Hot wings", 15.3, "Appertizer");
            FoodItem food2 = new FoodItem("Chips", "Potato chips", 8, "Appertizer");
            FoodItem food3 = new FoodItem("Salmon", "Atlantic salmon, oily", 11, "Main");
            FoodItem food4 = new FoodItem("BBq ribs", "Well done ribs", 17, "Main");
            FoodItem food5 = new FoodItem("Duck", "Nice and juici", 27, "Main");
            FoodItem food6 = new FoodItem("Ice cream", "Vanilla and chocolate", 16, "Dessert");
            FoodItem food7 = new FoodItem("Cake", "Cheesecake", 4, "Dessert");
            List<FoodItem> foods = new ArrayList<>();
            foods.add(food1);
            foods.add(food2);
            foods.add(food3);
            foods.add(food4);
            foods.add(food5);
            foods.add(food6);
            foods.add(food7);
            foodItems.saveAll(foods);
            OfferItem offer1 = new OfferItem("Monday special", 20, new ArrayList<FoodItem>(Arrays.asList(food1, food3)));
            OfferItem offer2 = new OfferItem("BBQ-ICECREAM COMBO", 30, new ArrayList<FoodItem>(Arrays.asList(food4, food6)));
            offerItems.save(offer1);
            offerItems.save(offer2);
            orderItems.save(new OrderItem("marko jagor", foods));
            orderItems.save(new OrderItem("reiko magi", offer1));
            orderItems.save(new OrderItem("timothy beres", offer2));
        };
    }
}
