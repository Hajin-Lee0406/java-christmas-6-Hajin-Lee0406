package christmas.model;

public class Discount {

    private final String name;
    private int amount;

    public Discount(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }
}
