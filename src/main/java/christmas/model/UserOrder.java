package christmas.model;

import java.util.List;

import static christmas.model.Category.*;
import static christmas.constants.ErrorConstants.INVALID_ORDER;

public class UserOrder {
    List<Order> orders;

    public UserOrder(List<Order> orders) {
        this.orders = orders;
        checkTotalOrderCount();
        checkOnlyBeverages();
    }

    public void checkTotalOrderCount() {
        if (orders.stream().mapToInt(Order::getCount).sum() > 20) {
            throw new IllegalArgumentException(INVALID_ORDER);
        }
    }

    public void checkOnlyBeverages(){
        if(orders.stream().allMatch(order -> BEVERAGES.equals(order.getMenu().getCategory()))){
            throw new IllegalArgumentException(INVALID_ORDER);
        }
    }
}
