package christmas.model;

import java.util.Arrays;

public enum Badge {
    SANTA("산타", 20000),
    TREE("트리", 10000),
    STAR("별", 5000);

    private String name;
    private int price;

    Badge(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public static String getBadgeName(int totalPaymentAccount) {
        if (totalPaymentAccount < 10000) {
            return "없음";
        }

        return Arrays.stream(Badge.values())
                .filter(badge -> badge.price < totalPaymentAccount)
                .findAny()
                .map(Badge::getName)
                .orElse("없음");
    }

    public String getName() {
        return name;
    }
}
