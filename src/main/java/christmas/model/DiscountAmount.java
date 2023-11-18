package christmas.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class DiscountAmount {
    List<Discount> discounts = new ArrayList<>();

    public int getTotalDiscount(){
        int totalDiscount = 0;
        for (Discount discount : discounts) {
            totalDiscount = totalDiscount + discount.getAmount();
        }

        return totalDiscount;
    }
}
