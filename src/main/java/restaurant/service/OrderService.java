package restaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import restaurant.model.OfferItem;
import restaurant.model.OrderItem;
import restaurant.repository.OfferItemRepository;
import restaurant.repository.OrderRepository;

import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
@Component("OrderService")
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<OrderItem> getAll() {

        return orderRepository.findAll();
    }
    public OrderItem findOne(Long id) {
        OrderItem order = orderRepository.findById(id)
                .orElseThrow(this::badRequest);
        //List<Lease> leases = leaseRepository.findByCar(car);
        //car.setLeases(leases);
        return order;
    }
    private ResponseStatusException badRequest() {
        return new ResponseStatusException(BAD_REQUEST, "id doesnt exist");
    }
}
