package restaurant.model;

import restaurant.helpers.HelperClass;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class OfferItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String offerName;
    private double offerPrice;
    private double moneySaved;
    @ManyToMany
    private List<FoodItem> foodItems;

    public OfferItem() {
    }

    public OfferItem(String offerName, double offerPrice, List<FoodItem> foodItems) {
        this.offerName = offerName;
        this.offerPrice = offerPrice;
        this.foodItems = foodItems;
        this.moneySaved = HelperClass.calculateSavedMoney(offerPrice, foodItems);
    }

    public Long getID() {
        return this.id;
    }

    public void setID(Long id) {
        this.id = id;
    }

    public String getOfferName() {
        return offerName;
    }

    public void setOfferName(String offerName) {
        this.offerName = offerName;
    }

    public double getOfferPrice() {
        return offerPrice;
    }

    public void setOfferPrice(double offerPrice) {
        this.offerPrice = offerPrice;
    }

    public double getMoneySaved() {
        return moneySaved;
    }

    public void setMoneySaved(double moneySaved) {
        this.moneySaved = moneySaved;
    }

    public List<FoodItem> getFoodItems() {

        return new ArrayList<>(foodItems);
    }

    public void setFoodItems(List<FoodItem> foodItems) {
        this.foodItems = foodItems;
    }
}