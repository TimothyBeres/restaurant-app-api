package restaurant.model;

import restaurant.helpers.HelperClass;
import restaurant.model.FoodItem;

import javax.persistence.*;
import java.util.List;

@Entity
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String clientName;
    private Double orderPrice;
    @ManyToOne
    private OfferItem offer;
    @ManyToMany
    private List<FoodItem> foodItems;

    public OrderItem() {

    }

    public OrderItem(String clientName, List<FoodItem> foodItems) {
        this.clientName = clientName;
        this.foodItems = foodItems;
        this.orderPrice = HelperClass.calculateOrderPrice(foodItems);
    }
    public OrderItem(String clientName, OfferItem offer) {
        this.clientName = clientName;
        this.offer = offer;
        this.foodItems = offer.getFoodItems();
        this.orderPrice = offer.getOfferPrice();
    }

    public Long getID() {
        return id;
    }

    public void setID(Long id) {
        this.id = id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
    public Double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Double offerPrice) {
        this.orderPrice = offerPrice;
    }
    public OfferItem getOffer() {
        return offer;
    }

    public void setOfferId(OfferItem offer) {
        this.offer = offer;
    }

    public List<FoodItem> getFoodItems() {
        return foodItems;
    }

    public void setFoodItems(List<FoodItem> foodItems) {
        this.foodItems = foodItems;
    }
}
