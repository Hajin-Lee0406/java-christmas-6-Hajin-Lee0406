package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.model.Order;

import java.util.List;

public class OutputView {
    private static final OutputView instance = new OutputView();

    public static OutputView getInstance() {
        return instance;
    }

    private OutputView() {
    }

    public void printOrderInfo(int visitDate) {
        System.out.println(String.format("12월 %s일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!", visitDate));
    }

    public void printUserOrders(List<Order> orders) {
        System.out.println("\n<주문 메뉴>");

        for (Order order : orders) {
            System.out.println(order.getMenu().getName() + " " + order.getCount() + "개");
        }
    }
}
