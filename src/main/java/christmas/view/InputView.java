package christmas.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final InputView instance = new InputView();

    public static InputView getInstance() {
        return instance;
    }

    private InputView() {
    }

    public int readDate() {
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        int date;

        try {
            date = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 1 ~ 31 사이의 날짜를 입력해주세요");
        }

        if (date < 1 || date > 31) {
            throw new IllegalArgumentException("[ERROR] 1 ~ 31 사이의 날짜를 입력해주세요");
        }

        return date;
    }
}
