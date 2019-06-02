package restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import restaurant.model.OfferItem;
import restaurant.model.OrderItem;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderItem, Long> {
    List<OrderItem> findByClientNameContainingIgnoreCase(String clientName);
}
