package application;

import java.util.ArrayList;

public abstract class Pizza {
    public static final String[] TOPPINGS_AVAILABLE = {"Sausage", "Pepperoni", "Green Pepper", "Onion", "Mushroom", "Ham", 
            "Pineapple", "Beef", "Chicken", "Olives"};
    
    public static final String DELUXE = "Deluxe";
    public static final String HAWAIIAN = "Hawaiian";
    public static final String BUILD_YOUR_OWN = "Build Your Own";
    
    protected static final String SMALL = "Small";
    protected static final String MEDIUM = "Medium";
    protected static final String LARGE = "Large";
    
    protected String style;
    protected String size;
    protected ArrayList<String> toppings;
    
    public Pizza(String style, String size, ArrayList<String> toppings) { 
        this.style = style;
        this.size = size;
        this.toppings = toppings;
    }
    
    public Pizza(String style, String size) { 
        this.style = style;
        this.size = size;
        this.toppings = new ArrayList<String>();
    }
    
    public abstract int pizzaPrice();
    
    public String toString() { 
        String pizzaString = "Style: " + style + ", Size: " + size + ", Toppings:";
        
        for(String s: toppings) {
            pizzaString += " " + s + ",";
        }
        
        return pizzaString;
    }
}