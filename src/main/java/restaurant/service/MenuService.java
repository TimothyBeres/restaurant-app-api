package restaurant.service;


import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import restaurant.model.FoodItem;
import restaurant.repository.FoodItemRepository;

import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
@Component("MenuService")
public class MenuService {

    @Autowired
    private FoodItemRepository foodItemRepository;

    public List<FoodItem> getAll(String category) {
        if (StringUtils.isNotBlank(category)) {
            return foodItemRepository.findByCategoryContainingIgnoreCase(category);
        }
        return foodItemRepository.findAll();
    }

    public FoodItem findOne(Long id) {
        FoodItem food = foodItemRepository.findById(id)
                .orElseThrow(this::badRequest);
        return food;
    }

    public FoodItem save(FoodItem food) {

        return foodItemRepository.save(food);
    }

    public FoodItem update(FoodItem food, Long id) {
        FoodItem dbFood = findOne(id);
        dbFood.setName(food.getName());
        dbFood.setDescription(food.getDescription());
        dbFood.setPrice(food.getPrice());
        dbFood.setCategory(food.getCategory());
        return foodItemRepository.save(dbFood);
    }

    public void delete(Long id) {
        FoodItem dbFood = findOne(id);
        foodItemRepository.delete(dbFood);
    }

    private ResponseStatusException badRequest() {
        return new ResponseStatusException(BAD_REQUEST, "id doesnt exist");
    }
}
