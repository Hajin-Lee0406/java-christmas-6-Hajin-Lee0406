package christmas.view;

import camp.nextstep.edu.missionutils.Console;

import static christmas.constants.Constants.GET_DATE_MESSAGE;
import static christmas.constants.Constants.GET_ORDER_MESSAGE;
import static christmas.constants.ErrorConstants.*;

public class InputView {
    private static final InputView instance = new InputView();

    public static InputView getInstance() {
        return instance;
    }

    private InputView() {
    }

    public int readDate() {
        System.out.println(GET_DATE_MESSAGE);
        int date;

        try {
            date = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(INVALID_DATE_FORMAT);
        }

        if (date < 1 || date > 31) {
            throw new IllegalArgumentException(INVALID_DATE_FORMAT);
        }

        return date;
    }

    public String readOrder() {
        System.out.println(GET_ORDER_MESSAGE);
        return Console.readLine();
    }
}
