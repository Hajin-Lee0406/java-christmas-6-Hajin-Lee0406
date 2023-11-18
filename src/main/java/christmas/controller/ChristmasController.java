package christmas.controller;

import christmas.model.*;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static christmas.model.Category.*;
import static christmas.model.ErrorConstants.INVALID_ORDER;

public class ChristmasController {
    private static final ChristmasService christmasService = new ChristmasService();
    private final OutputView outputView;
    private final InputView inputView;
    private final List<Order> orders = new ArrayList<>();
    private UserOrder userOrder;
    int visitDate;
    boolean isGiftEvent;

    public ChristmasController() {
        outputView = OutputView.getInstance();
        inputView = InputView.getInstance();
    }

    public void run() {
        start();
    }

    private void start() {
        visitDate = inputView.readDate();
        getOrder();
        outputView.printOrderInfo(visitDate);
        outputView.printUserOrders(orders);

        int account = christmasService.getAccount(orders);
        outputView.printAccount(account);

        isGiftEvent = christmasService.isGiftEvent(account);
        printGiftEvent();

        int totalDiscount = getTotalDiscount();
        printBenefitInfo();
        printTotalBenefit(totalDiscount);
        printPaymentAccount(account, totalDiscount);
    }

    private void getOrder() {
        String inputOrder = inputView.readOrder();

        String[] menus = inputOrder.split(",");
        for (String menu : menus) {
            String[] temp = menu.split("-");

            if (temp.length != 2) {
                throw new IllegalArgumentException(INVALID_ORDER);
            }

            String menuName = temp[0];
            int menuCount = Integer.parseInt(temp[1]);

            if (orders.stream().anyMatch(order -> Menu.fromName(menuName).equals(order.getMenu()))) {
                throw new IllegalArgumentException(INVALID_ORDER);
            }

            orders.add(new Order(Menu.fromName(menuName), menuCount));
        }
        userOrder = new UserOrder(orders);
    }

    private void printGiftEvent() {
        String giftInfo = "없음";

        if (isGiftEvent) {
            giftInfo = "샴페인 1개";
        }

        outputView.printGift(giftInfo);
    }

    private void printBenefitInfo() {
        ArrayList<Discount> discounts = christmasService.getDiscount(visitDate, orders);

        if (isGiftEvent) {
            discounts.add(new Discount("증정 이벤트", 25000));
        }

        outputView.printBenefits(discounts);
    }

    private void printTotalBenefit(int totalDiscount) {
        int totalBenefit = totalDiscount;

        if (isGiftEvent) {
            totalBenefit = totalBenefit + 25000;
        }

        outputView.printTotalBenefit(totalBenefit);
    }

    private int getTotalDiscount() {
        int totalDiscount = 0;
        ArrayList<Discount> discounts = christmasService.getDiscount(visitDate, orders);

        for (Discount discount : discounts) {
            totalDiscount = totalDiscount + discount.getAmount();
        }

        return totalDiscount;
    }

    private void printPaymentAccount(int account, int totalDiscount) {
        int paymentAccount = account - totalDiscount;
        outputView.printPaymentAccount(paymentAccount);
    }

}
