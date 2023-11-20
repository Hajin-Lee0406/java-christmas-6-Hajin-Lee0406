package christmas.model;

import java.awt.*;
import java.util.List;
import java.util.Map;

public class Order {
    private final Menu menu;
    private int count;


    public Order(Menu menu, int count){
        this.menu = menu;
        this.count = count;
    }

    public Menu getMenu(){
        return menu;
    }

    public int getCount(){
        return count;
    }

}
