package restaurant.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import restaurant.helpers.HelperClass;
import restaurant.model.FoodItem;
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

    public List<OrderItem> getAll(String clientName) {
        if(StringUtils.isNotBlank(clientName))
        {
            return orderRepository.findByClientNameContainingIgnoreCase(clientName);
        }
        return orderRepository.findAll();
    }
    public OrderItem findOne(Long id) {
        OrderItem order = orderRepository.findById(id)
                .orElseThrow(this::badRequest);
        return order;
    }


    public OrderItem save(OrderItem order) {
        if(order.getOffer() == null)
        {
            order.setOrderPrice(HelperClass.calculateOrderPrice(order.getFoodItems()));
        }
        else
        {
            order.setOrderPrice(order.getOffer().getOfferPrice());
        }
        return orderRepository.save(order);
    }

    public OrderItem update(OrderItem order, Long id) {
        OrderItem dbOrder = findOne(id);
        dbOrder.setClientName(order.getClientName());
        dbOrder.setFoodItems(order.getFoodItems());
        return orderRepository.save(dbOrder);
    }

    public void delete(Long id) {
        OrderItem dbOrder = findOne(id);
        orderRepository.delete(dbOrder);
    }
    private ResponseStatusException badRequest() {
        return new ResponseStatusException(BAD_REQUEST, "id doesnt exist");
    }
}
