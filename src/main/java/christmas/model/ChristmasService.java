package christmas.model;

import org.mockito.internal.matchers.Or;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static christmas.model.Category.*;
import static christmas.model.Constants.SPEACIAL_DAYS;

public class ChristmasService {

    private static final int MINIMUM_GIFT_ACCOUNT = 120000;
    private static final String NO_GIFT = "없음";
    private static final String GIFT = "샴페인 1개";


    //총 주문 금액 계산
    public int getAccount(List<Order> orders) {
        int account = 0;

        for (Order order : orders) {
            account = account + order.getCount() * order.getMenu().getPrice();
        }

        return account;
    }

    // 증정 이벤트
    public String isGiftEvent(int account) {
        if (account < MINIMUM_GIFT_ACCOUNT) {
            return NO_GIFT;
        }
        return GIFT;
    }

    // 할인 혜택
    public ArrayList<Discount> getDiscount(int visitDate, List<Order> orders){
        ArrayList<Discount> discounts = new ArrayList<>();
        Category category = DESSERT;
        String WEEK = "평일 할인";

        if (isWeekend(visitDate)){
            category = MAIN;
            WEEK = "주말 할인";
        }

        discounts.add(new Discount("크리스마스 디데이 할인", getDdayDiscount(visitDate)));
        discounts.add(new Discount(WEEK, getWeekDiscount(visitDate, orders, category)));
        discounts.add(new Discount("특별할인", getSpecialDiscount(visitDate)));

        return discounts;
    }

    private boolean isWeekend(int visitDate){
        int weekValue = LocalDate.of(2023, 12, visitDate).getDayOfWeek().getValue();

        if (weekValue == 5 || weekValue == 6){
            return true;
        }

        return false;
    }

    // 디에이 할인
    public int getDdayDiscount(int visitDate) {
        if (visitDate > 25) {
            return 0;
        }

        return 1000 + (visitDate - 1) * 100;
    }

    public int getWeekDiscount(int visitDate, List<Order> orders, Category category) {
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
}
