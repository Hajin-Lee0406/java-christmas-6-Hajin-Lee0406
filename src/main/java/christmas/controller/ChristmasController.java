package christmas.controller;

import christmas.model.*;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static christmas.model.Category.*;

public class ChristmasController {
    private static final ChristmasService christmasService =  new ChristmasService();
    private final OutputView outputView;
    private final InputView inputView;
    private final List<Order> orders = new ArrayList<>();

    public ChristmasController() {
        outputView = OutputView.getInstance();
        inputView = InputView.getInstance();
    }

    public void run() {
        start();
    }

    private void start(){
        int visitDate = inputView.readDate();
        getOrder();
        outputView.printOrderInfo(visitDate);
        outputView.printUserOrders(orders);
        int account = christmasService.getAccount(orders);
        outputView.printAccount(account);
        outputView.printGift(christmasService.isGiftEvent(account));
        ArrayList<Discount> discounts = christmasService.getDiscount(visitDate, orders);
        String discountInfo = "없음";

        outputView.printBenefits(discounts);
    }

    private void getOrder(){
        String inputOrder = inputView.readOrder();

        String[] menus = inputOrder.split(",");
        for (String menu : menus) {
            String[] temp = menu.split("-");
            String menuName = temp[0];
            int menuCount = Integer.parseInt(temp[1]);

            if(temp.length != 2){
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }

            boolean isExistMenu = orders.stream()
                    .anyMatch(order -> Menu.fromName(menuName).equals(order.getMenu()));

            if(isExistMenu){
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }

            orders.add(new Order(Menu.fromName(menuName), menuCount));
        }
    }

    private void printGiftEvent(int account){
        String giftInfo = "없음";
        if (christmasService.isGiftEvent(account)) {
            giftInfo = "샴페인 1개";
        }
        outputView.printGift(giftInfo);
    }


}
