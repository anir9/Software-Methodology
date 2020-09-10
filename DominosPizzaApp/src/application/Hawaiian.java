package application;

import java.util.ArrayList;

public class Hawaiian extends Pizza {
    public static final String[] HAWAIIAN_TOPPINGS = {"Ham", "Pineapple"};
    
    private static final int SMALL_PRICE = 8;
    private static final int MEDIUM_PRICE = SMALL_PRICE + 2;
    private static final int LARGE_PRICE = SMALL_PRICE + 4;
    private static final int ERROR_PRICE = -1;
    
    public Hawaiian(String style, String size, ArrayList<String> toppings) {
        super(style, size, toppings);
    }
    
    public Hawaiian(String style, String size) {
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
