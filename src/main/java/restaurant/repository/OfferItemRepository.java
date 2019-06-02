package restaurant.repository;

import restaurant.model.FoodItem;
import restaurant.model.OfferItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OfferItemRepository extends JpaRepository<OfferItem, Long> {


}
