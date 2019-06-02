package restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import restaurant.model.OrderItem;

public interface OrderRepository extends JpaRepository<OrderItem, Long> {

}
