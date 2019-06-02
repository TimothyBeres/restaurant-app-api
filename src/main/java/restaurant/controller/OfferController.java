package restaurant.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restaurant.Application;
import restaurant.model.FoodItem;
import restaurant.model.OfferItem;
import restaurant.service.MenuService;
import restaurant.service.OfferService;

import java.util.List;

@RequestMapping("/offer")
@RestController
public class OfferController {
    @Autowired
    private OfferService offerService;

    @GetMapping
    public List<OfferItem> getAll()
    {
        logger.info("In offer controller");
        return offerService.getAll();
    }
    private static Logger logger = LoggerFactory.getLogger(Application.class);
}
