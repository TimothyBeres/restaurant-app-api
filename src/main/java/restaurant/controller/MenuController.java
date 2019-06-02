package restaurant.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restaurant.Application;
import restaurant.model.FoodItem;
import restaurant.service.MenuService;

import java.util.List;


@RequestMapping("/menu")
@RestController
public class MenuController  {
    @Autowired
    private MenuService menuService;

    @GetMapping
    public List<FoodItem> getAll()
    {
        logger.info("In menu controller");
        return menuService.getAll(null,null);
    }
    private static Logger logger = LoggerFactory.getLogger(Application.class);
}
