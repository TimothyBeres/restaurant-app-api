package restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import restaurant.model.FoodItem;


public interface FoodItemRepository extends JpaRepository<FoodItem, Long> {
    //List<FoodItem> findFoodItemByParams(String foodName, String description);

}
