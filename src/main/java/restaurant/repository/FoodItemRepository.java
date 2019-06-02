package restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import restaurant.model.FoodItem;

import java.util.List;


public interface FoodItemRepository extends JpaRepository<FoodItem, Long> {
    //List<FoodItem> findFoodItemByParams(String foodName, String description);
    List<FoodItem> findByCategoryContainingIgnoreCase(String category);

}
