package christmas.model;


public class Order {
    private final Menu menu;
    private int count;


    public Order(Menu menu, int count) {
        this.menu = menu;
        this.count = count;
    }

    public Menu getMenu() {
        return menu;
    }

    public int getCount() {
        return count;
    }

}
