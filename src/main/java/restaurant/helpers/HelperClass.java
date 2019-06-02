package restaurant.helpers;

import restaurant.model.FoodItem;

import java.util.List;

public class HelperClass {
    public static Double calculateSavedMoney(Double offerPrice, List<FoodItem> foodItems) {
        double sumPrices = 0;
        double savedMoney = 0;
        for(FoodItem foodItem: foodItems)
        {
            sumPrices += foodItem.getPrice();
        }
        savedMoney = sumPrices - offerPrice;

        return savedMoney;
    }

    public static Double calculateOrderPrice(List<FoodItem> foodItems) {
        double sumPrices = 0;
        for(FoodItem foodItem: foodItems)
        {
            sumPrices += foodItem.getPrice();
        }
        return sumPrices;
    }
}
