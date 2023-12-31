package christmas.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static christmas.model.Category.*;
import static christmas.constants.Constants.SPEACIAL_DAYS;

public class ChristmasService {

    private static final int MINIMUM_GIFT_ACCOUNT = 120000;

    public int getAccount(List<Order> orders) {
        int account = 0;

        for (Order order : orders) {
            account = account + order.getCount() * order.getMenu().getPrice();
        }

        return account;
    }


    public boolean isGiftEvent(int account) {
        return account > MINIMUM_GIFT_ACCOUNT;
    }

    public ArrayList<Discount> getDiscount(int visitDate, List<Order> orders){
        ArrayList<Discount> discounts = new ArrayList<>();
        Category category = DESSERT;
        String WEEK = "평일 할인";

        if (isWeekend(visitDate)){
            category = MAIN;
            WEEK = "주말 할인";
        }

        int ddayDiscount = getDdayDiscount(visitDate);
        if (ddayDiscount != 0){
            discounts.add(new Discount("크리스마스 디데이 할인", ddayDiscount));
        }

        int weekDiscount = getWeekDiscount(orders, category);
        if(weekDiscount != 0){
            discounts.add(new Discount(WEEK, weekDiscount));
        }

        int specialDiscount = getSpecialDiscount(visitDate);
        if(specialDiscount != 0){
            discounts.add(new Discount("특별할인", specialDiscount));
        }

        return discounts;
    }

    private boolean isWeekend(int visitDate){
        int weekValue = LocalDate.of(2023, 12, visitDate).getDayOfWeek().getValue();

        return weekValue == 5 || weekValue == 6;
    }


    public int getDdayDiscount(int visitDate) {
        if (visitDate > 25) {
            return 0;
        }

        return 1000 + (visitDate - 1) * 100;
    }

    public int getWeekDiscount(List<Order> orders, Category category) {
        int count = 0;

        for (Order order : orders) {
            if (order.getMenu().getCategory() == category) {
                count++;
            }
        }

        return count * 2023;
    }

    public int getSpecialDiscount(int visitDate){
        if (SPEACIAL_DAYS.contains(visitDate)){
            return 1000;
        }

        return 0;
    }

    public String getBadge(int totalPaymentAccount){
        return Badge.getBadgeName(totalPaymentAccount);
    }
}
