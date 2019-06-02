package restaurant.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    //Eelmisel andis array selle id, aga idk mis nyyd id asemel tleb ss :O
    @GetMapping("{id}")
    public FoodItem findOne(@PathVariable Long id) {
        return menuService.findOne(id);
    }

    @PutMapping("{id}")
    public FoodItem update(@RequestBody FoodItem menu, @PathVariable Long id) {
        return menuService.update(menu, id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        menuService.delete(id);
    }

}
