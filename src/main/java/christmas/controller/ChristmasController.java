package christmas.controller;

import christmas.model.Food;
import christmas.model.Menu;
import christmas.model.Order;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static christmas.model.Category.*;

public class ChristmasController {
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

}
