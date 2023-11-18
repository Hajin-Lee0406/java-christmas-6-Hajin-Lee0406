package christmas.model;

import java.util.ArrayList;
import java.util.List;

import static christmas.model.Category.APPETIZER;
import static christmas.model.ErrorConstants.INVALID_ORDER;

public class UserOrder {
    List<Order> orders;

    public UserOrder(List<Order> orders) {
        this.orders = orders;
        getTotalOrderCount();
        isOnlyBeverages();
    }

    public int getTotalOrderCount() {
        return orders.stream()
                .mapToInt(Order::getCount)
                .peek(count -> {
                    if (count > 20) throw new IllegalArgumentException(INVALID_ORDER);
                })
                .sum();
    }

    public void isOnlyBeverages(){
        orders.stream()
                .filter(order -> APPETIZER.equals(order.getMenu().getCategory()))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_ORDER));
    }
}
