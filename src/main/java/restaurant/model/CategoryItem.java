package restaurant.model;


import javax.persistence.*;
import java.util.List;

@Entity
public class CategoryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String categoryName;
    @ManyToMany
    private List<FoodItem> foodItems;

    public CategoryItem(String categoryName, List<FoodItem> foodItems) {
        this.categoryName = categoryName;
        this.foodItems = foodItems;
    }
}
