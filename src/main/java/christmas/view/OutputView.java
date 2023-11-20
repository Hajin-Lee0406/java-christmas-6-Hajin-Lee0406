package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.model.Discount;
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

    public void printAccount(int account) {
        System.out.println("\n<할인 전 총주문 금액>");
        System.out.println(account + "원");
    }

    public void printGift(String gift) {
        System.out.println("\n<증정 메뉴>");
        System.out.println(gift);
    }

    public void printBenefits(List<Discount> discounts) {
        System.out.println("\n<혜택 내역>");

        if (discounts.size() == 0) {
            System.out.println("없음");
        }

        for (Discount discount : discounts) {
            System.out.println(discount.getName() + ": -" + discount.getAmount() + "원");
        }
    }

    public void printTotalBenefit(int totalBenefit) {
        System.out.println("\n<총혜택 금액>");
        System.out.println(totalBenefit + "원");
    }

    public void printPaymentAccount(int paymentAccount) {
        System.out.println("\n<할인 후 예상 결제 금액>");
        System.out.println(paymentAccount + "원");
    }

    public void printBadgeName(String badgeName) {
        System.out.println("\n<12월 이벤트 배지>");
        System.out.println(badgeName);
    }
}
