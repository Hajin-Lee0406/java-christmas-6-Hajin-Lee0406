package christmas.model;

import java.awt.*;
import java.util.List;

public class Order {
    private final List<Food> foods;

    public Order(List<Food> foods) {
        this.foods = foods;
    }
}
