package christmas.model;

import static christmas.model.MenuType.APPETIZER;

public class Menu {
    private String name;
    private int price;
    private MenuType menuType;

    public Menu(String name, int price, MenuType menuType) {
        this.name = name;
        this.price = price;
        this.menuType = menuType;
    }
}
