package christmas.model;

import java.util.Arrays;

import static christmas.model.Category.*;
import static christmas.constants.ErrorConstants.INVALID_ORDER;

public enum Menu {
    SOUP("양송이수프", 6000, APPETIZER),
    TAPAS("타파스", 5500, APPETIZER),
    CAESAR_SALAD("시저샐러드", 8000, APPETIZER),
    T_BONE_STEAK("티본스테이크", 55000, MAIN),
    BBQ_RIBS("바비큐립", 54000, MAIN),
    SEAFOOD_PASTA("해산물파스타", 35000, MAIN),
    CHRISTMAS_PASTA("크리스마스파스타", 25000, MAIN),
    CHOCO_CAKE("초코케이크", 15000, DESSERT),
    ICE_CREAM("아이스크림", 5000, DESSERT),
    ZERO_COLA("제로콜라", 3000, BEVERAGES),
    RED_WINE("레드와인", 60000, BEVERAGES),
    CHAMPAGNE("샴페인", 25000, BEVERAGES);

    private String name;
    private int price;
    private Category category;

    Menu(String name, int price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public static Menu fromName(String name) {
        return Arrays.stream(Menu.values())
                .filter(menu -> menu.name.equals(name))
                .findAny()
                .orElseThrow(()-> new IllegalArgumentException(INVALID_ORDER));
    }


    public String getName(){
        return name;
    }

    public int getPrice(){
        return price;
    }

    public Category getCategory(){
        return category;
    }
}
