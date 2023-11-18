package christmas.model;

import org.mockito.internal.matchers.Or;

import java.util.List;

public class ChristmasService {

    private static final int MINIMUM_GIFT_ACCOUNT = 120000;
    private static final String NO_GIFT = "없음";
    private static final String GIFT = "샴페인 1개";


    //총 주문 금액 계산
    public int getAccount(List<Order> orders){
        int account = 0;

        for (Order order : orders) {
            account = account + order.getCount() * order.getMenu().getPrice();
        }

        return account;
    }

    // 증정 이벤트
    public String isGiftEvent(int account){
        if(account < MINIMUM_GIFT_ACCOUNT){
            return NO_GIFT;
        }
        return GIFT;
    }
}
