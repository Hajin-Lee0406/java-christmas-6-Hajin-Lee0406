package christmas.model;

import java.util.List;

public class Order {
    private final List<Menu> memus;

    public Order(List<Menu> memus) {
        this.memus = memus;
    }
}
