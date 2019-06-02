package restaurant.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import restaurant.Application;
import restaurant.model.OfferItem;
import restaurant.model.OrderItem;
import restaurant.service.OfferService;
import restaurant.service.OrderService;

import java.util.List;

@RequestMapping("/order")
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private OfferService offerService;

    @GetMapping
    public List<OrderItem> getAll(@RequestParam(value = "clientName", required = false) String clientName) {
        logger.info("In offer controller");
        return orderService.getAll(clientName);
    }

    @GetMapping("{id}")
    public OrderItem findOne(@PathVariable Long id) {
        return orderService.findOne(id);
    }

    private static Logger logger = LoggerFactory.getLogger(Application.class);

    @PostMapping
    public OrderItem save(@RequestBody OrderItem orderItem, @RequestParam(value = "offerId", required = false) Long offerId) {
        if(offerId != null)
        {
            OfferItem offer = offerService.findOne(offerId);
            orderItem.setOffer(offer);
            orderItem.setFoodItems(offer.getFoodItems());
        }
        return orderService.save(orderItem);
    }

    @PutMapping("{id}")
    public OrderItem update(@RequestBody OrderItem orderItem, @PathVariable Long id) {
        return orderService.update(orderItem, id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long orderItem) {
        orderService.delete(orderItem);
    }
}
