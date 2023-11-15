package christmas.controller;

import christmas.model.Food;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static christmas.model.FoodType.*;

public class ChristmasController {
    private final OutputView outputView;
    private final InputView inputView;가
    private final List<Food> menu;

    public ChristmasController() {
        outputView = OutputView.getInstance();
        inputView = InputView.getInstance();
    }

    public void run() {
        start();
    }

    private void initMenu(){
        menu.add(new Food("양송이수프", 6000, APPETIZER));
        menu.add(new Food("타파스", 5500, APPETIZER));
        menu.add(new Food("시저샐러드", 8000, APPETIZER));
        menu.add(new Food("티본스테이크", 55000, MAIN));
        menu.add(new Food("바비큐립", 54000, MAIN));
        menu.add(new Food("해산물파스타", 35000, MAIN));
        menu.add(new Food("크리스마스파스타", 25000, MAIN));
        menu.add(new Food("초코케이크", 15000, DESSERT));
        menu.add(new Food("아이스크림", 5000, DESSERT));
        menu.add(new Food("제로콜라", 3000, BEVERAGES));
        menu.add(new Food("레드와인", 60000, BEVERAGES));
        menu.add(new Food("샴페인", 25000, BEVERAGES));
    }

    private void start(){
        initMenu();
        int visitDate = inputView.readDate();
        String inputOrder = inputView.readOrder();
    }

}
