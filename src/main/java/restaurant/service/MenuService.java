package restaurant.service;


import com.sun.istack.internal.Nullable;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import restaurant.model.FoodItem;
import org.springframework.beans.factory.annotation.Autowired;
import restaurant.repository.FoodItemRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Component("MenuService")
public class MenuService {

    @Autowired
    private FoodItemRepository foodItemRepository;

    public List<FoodItem> getAll(@Nullable String foodName, @Nullable String description) {

        if (foodName != null && description != null) {
            return foodItemRepository.findFoodItemByParams(foodName, description);
        }
        return foodItemRepository.findAll();

        /*TypedQuery<FoodItem> query = em.createQuery("select f from FoodItems", FoodItem.class);
        return query.getResultList();*/
    }
}
