package christmas.view;

import camp.nextstep.edu.missionutils.Console;

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
}
