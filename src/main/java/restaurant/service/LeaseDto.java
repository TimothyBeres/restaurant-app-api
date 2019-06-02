package restaurant.service;

import restaurant.model.FoodItem;
import restaurant.model.OrderItem;

import java.time.LocalDate;

public class LeaseDto {

    private Long id;
    private FoodItem car;
    private OrderItem user;
    private LocalDate returnDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FoodItem getCar() {
        return car;
    }

    public void setCar(FoodItem car) {
        this.car = car;
    }

    public OrderItem getUser() {
        return user;
    }

    public void setUser(OrderItem user) {
        this.user = user;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}
