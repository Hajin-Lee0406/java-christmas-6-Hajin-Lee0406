package christmas.model;

public class Food {
    private String name;
    private int price;
    private FoodType foodType;

    public Food(String name, int price, FoodType foodType) {
        this.name = name;
        this.price = price;
        this.foodType = foodType;
    }
}
