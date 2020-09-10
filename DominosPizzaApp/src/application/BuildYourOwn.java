package application;

import java.util.ArrayList;

public class BuildYourOwn extends Pizza {
    private static final int SMALL_PRICE = 5;
    private static final int MEDIUM_PRICE = SMALL_PRICE + 2;
    private static final int LARGE_PRICE = SMALL_PRICE + 4;
    private static final int PRICE_PER_TOPPING = 2;
    private static final int ERROR_PRICE = -1;
    public static final int MAX_NUM_TOPPINGS = 6;
    
    public BuildYourOwn(String style, String size, ArrayList<String> toppings) {
        super(style, size, toppings);
    }
    
    public BuildYourOwn(String style, String size) {
        super(style, size);
    }
    
    public int pizzaPrice() {
        switch(size) {
        case Pizza.SMALL:
            return SMALL_PRICE + PRICE_PER_TOPPING * toppings.size();
        case Pizza.MEDIUM:
            return MEDIUM_PRICE + PRICE_PER_TOPPING * toppings.size();
        case Pizza.LARGE:
            return LARGE_PRICE + PRICE_PER_TOPPING * toppings.size();
        default:
            return ERROR_PRICE;
        }
    }
    
    public String toString() {
        return super.toString() + " Price: $" + pizzaPrice();
    }
}
