package christmas.model;

import org.mockito.internal.matchers.Or;

import java.util.List;

public class ChristmasService {

    //총 주문 금액 계산
    public int getAccount(List<Order> orders){
        int account = 0;

        for (Order order : orders) {
            account = account + order.getCount() * order.getMenu().getPrice();
        }

        return account;
    }
}
