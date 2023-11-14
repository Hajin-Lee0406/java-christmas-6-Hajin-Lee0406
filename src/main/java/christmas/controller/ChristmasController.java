package christmas.controller;

import christmas.view.InputView;
import christmas.view.OutputView;

public class ChristmasController {
    private final OutputView outputView;
    private final InputView inputView;

    public ChristmasController() {
        outputView = OutputView.getInstance();
        inputView = InputView.getInstance();
    }

    public void run() {
        start();
    }

    private void start(){
        int visitDate = inputView.readDate();
    }

}
