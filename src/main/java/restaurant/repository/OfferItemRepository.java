package restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import restaurant.model.OfferItem;

public interface OfferItemRepository extends JpaRepository<OfferItem, Long> {


}
