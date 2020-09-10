package application;

import java.util.ArrayList;

public class Deluxe extends Pizza {
    public static final String[] DELUXE_TOPPINGS = {"Sausage", "Pepperoni", "Green Pepper", "Onion", "Mushroom"};
    
    private static final int SMALL_PRICE = 14;
    private static final int MEDIUM_PRICE = SMALL_PRICE + 2;
    private static final int LARGE_PRICE = SMALL_PRICE + 4;
    private static final int ERROR_PRICE = -1;
    
    public Deluxe(String style, String size, ArrayList<String> toppings) {
        super(style, size, toppings);
    }
    
    public Deluxe(String style, String size) {
        super(style, size);
    }
    
    public int pizzaPrice() {
        switch(size) {
        case Pizza.SMALL:
            return SMALL_PRICE;
        case Pizza.MEDIUM:
            return MEDIUM_PRICE;
        case Pizza.LARGE:
            return LARGE_PRICE;
        default:
            return ERROR_PRICE;
        }
    }
    
    public String toString() {
        return super.toString() + " Price: $" + pizzaPrice();
    }
}
