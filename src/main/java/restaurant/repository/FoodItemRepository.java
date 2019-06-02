package restaurant.repository;

import restaurant.model.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface FoodItemRepository extends JpaRepository<FoodItem, Long>{
    List<FoodItem> findFoodItemByParams(String foodName, String description);

}
