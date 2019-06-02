package restaurant.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restaurant.Application;
import restaurant.model.OrderItem;
import restaurant.service.OrderService;

import java.util.List;

@RequestMapping("/order")
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<OrderItem> getAll() {
        logger.info("In offer controller");
        return orderService.getAll();
    }

    @GetMapping("{id}")
    public OrderItem findOne(@PathVariable Long id) {
        return orderService.findOne(id);
    }

    private static Logger logger = LoggerFactory.getLogger(Application.class);
}
