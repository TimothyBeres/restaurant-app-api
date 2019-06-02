package restaurant.repository;

import restaurant.model.OfferItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferItemRepository extends JpaRepository<OfferItem, Long> {


}
