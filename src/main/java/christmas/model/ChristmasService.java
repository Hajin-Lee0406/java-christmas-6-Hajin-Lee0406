package christmas.model;

import org.mockito.internal.matchers.Or;

import java.util.List;

import static christmas.model.Category.*;

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

    // 디에이 할인
    public int getDdayDiscount(int visitDate) {
        if (visitDate > 25) {
            return 0;
        }

        return 1000 + (visitDate - 1) * 100;
    }

    public int getDiscount(List<Order> orders, Category menuCategory) {
        int count = 0;
        for (Order order : orders) {
            if (order.getMenu().getCategory() == menuCategory) {
                count++;
            }
        }

        return count * 2023;
    }

}
