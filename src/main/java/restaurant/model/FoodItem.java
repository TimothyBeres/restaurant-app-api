package restaurant.model;



import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class FoodItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String foodName;
    private String description;
    private Double price;
    private String category;

    public FoodItem() {
    }

    public FoodItem(String foodName, String description, double price, String category) {
        this.foodName = foodName;
        this.description = description;
        this.price = price;
        this.category = category;
    }

    public Long getID() {
        return id;
    }

    public void setID(Long id) {
        this.id = id;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory( String category) {
        this.category = category;
    }

    public String getName() {
        return foodName;
    }

    public void setName(String foodName) {
        this.foodName = foodName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
