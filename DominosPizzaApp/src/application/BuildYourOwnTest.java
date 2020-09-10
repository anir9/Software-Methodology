package application;

import org.junit.jupiter.api.Test;
import junit.framework.TestCase;
import java.util.ArrayList;
import java.util.Arrays;

public class BuildYourOwnTest extends TestCase {
    
    @Test
    public void testPizzaPriceSmall() {
        BuildYourOwn testPizza1 = new BuildYourOwn(Pizza.BUILD_YOUR_OWN, Pizza.SMALL, 
                new ArrayList<String>(Arrays.asList("Sausage", "Pepperoni", "Green Pepper", "Onion", "Mushroom", "Ham")));
        int testPizza1TheoryPrice = 17;
        assertEquals(testPizza1TheoryPrice, testPizza1.pizzaPrice());
      
        BuildYourOwn testPizza2 = new BuildYourOwn(Pizza.BUILD_YOUR_OWN, Pizza.SMALL, 
                new ArrayList<String>(Arrays.asList("Sausage", "Pepperoni", "Green Pepper", "Onion", "Mushroom")));
        int testPizza2TheoryPrice = 15;
        assertEquals(testPizza2TheoryPrice, testPizza2.pizzaPrice());
        
        BuildYourOwn testPizza3 = new BuildYourOwn(Pizza.BUILD_YOUR_OWN, Pizza.SMALL, 
                new ArrayList<String>(Arrays.asList("Sausage", "Pepperoni", "Green Pepper", "Onion")));
        int testPizza3TheoryPrice = 13;
        assertEquals(testPizza3TheoryPrice, testPizza3.pizzaPrice());
        
        BuildYourOwn testPizza4 = new BuildYourOwn(Pizza.BUILD_YOUR_OWN, Pizza.SMALL, 
                new ArrayList<String>(Arrays.asList("Sausage", "Pepperoni", "Green Pepper")));
        int testPizza4TheoryPrice = 11;
        assertEquals(testPizza4TheoryPrice, testPizza4.pizzaPrice());
        
        BuildYourOwn testPizza5 = new BuildYourOwn(Pizza.BUILD_YOUR_OWN, Pizza.SMALL, 
                new ArrayList<String>(Arrays.asList("Sausage", "Pepperoni")));
        int testPizza5TheoryPrice = 9;
        assertEquals(testPizza5TheoryPrice, testPizza5.pizzaPrice());
        
        BuildYourOwn testPizza6 = new BuildYourOwn(Pizza.BUILD_YOUR_OWN, Pizza.SMALL, 
                new ArrayList<String>(Arrays.asList("Sausage")));
        int testPizza6TheoryPrice = 7;
        assertEquals(testPizza6TheoryPrice, testPizza6.pizzaPrice());
    }
    
    @Test
    public void testPizzaPriceMedium() {
        BuildYourOwn testPizza1 = new BuildYourOwn(Pizza.BUILD_YOUR_OWN, Pizza.MEDIUM, 
                new ArrayList<String>(Arrays.asList("Sausage", "Pepperoni", "Green Pepper", "Onion", "Mushroom", "Ham")));
        int testPizza1TheoryPrice = 19;
        assertEquals(testPizza1TheoryPrice, testPizza1.pizzaPrice());
      
        BuildYourOwn testPizza2 = new BuildYourOwn(Pizza.BUILD_YOUR_OWN, Pizza.MEDIUM, 
                new ArrayList<String>(Arrays.asList("Sausage", "Pepperoni", "Green Pepper", "Onion", "Mushroom")));
        int testPizza2TheoryPrice = 17;
        assertEquals(testPizza2TheoryPrice, testPizza2.pizzaPrice());
        
        BuildYourOwn testPizza3 = new BuildYourOwn(Pizza.BUILD_YOUR_OWN, Pizza.MEDIUM, 
                new ArrayList<String>(Arrays.asList("Sausage", "Pepperoni", "Green Pepper", "Onion")));
        int testPizza3TheoryPrice = 15;
        assertEquals(testPizza3TheoryPrice, testPizza3.pizzaPrice());
        
        BuildYourOwn testPizza4 = new BuildYourOwn(Pizza.BUILD_YOUR_OWN, Pizza.MEDIUM, 
                new ArrayList<String>(Arrays.asList("Sausage", "Pepperoni", "Green Pepper")));
        int testPizza4TheoryPrice = 13;
        assertEquals(testPizza4TheoryPrice, testPizza4.pizzaPrice());
        
        BuildYourOwn testPizza5 = new BuildYourOwn(Pizza.BUILD_YOUR_OWN, Pizza.MEDIUM, 
                new ArrayList<String>(Arrays.asList("Sausage", "Pepperoni")));
        int testPizza5TheoryPrice = 11;
        assertEquals(testPizza5TheoryPrice, testPizza5.pizzaPrice());
        
        BuildYourOwn testPizza6 = new BuildYourOwn(Pizza.BUILD_YOUR_OWN, Pizza.MEDIUM, 
                new ArrayList<String>(Arrays.asList("Sausage")));
        int testPizza6TheoryPrice = 9;
        assertEquals(testPizza6TheoryPrice, testPizza6.pizzaPrice());
    }
    
    @Test
    public void testPizzaPriceLarge() {
        BuildYourOwn testPizza1 = new BuildYourOwn(Pizza.BUILD_YOUR_OWN, Pizza.LARGE, 
                new ArrayList<String>(Arrays.asList("Sausage", "Pepperoni", "Green Pepper", "Onion", "Mushroom", "Ham")));
        int testPizza1TheoryPrice = 21;
        assertEquals(testPizza1TheoryPrice, testPizza1.pizzaPrice());
      
        BuildYourOwn testPizza2 = new BuildYourOwn(Pizza.BUILD_YOUR_OWN, Pizza.LARGE, 
                new ArrayList<String>(Arrays.asList("Sausage", "Pepperoni", "Green Pepper", "Onion", "Mushroom")));
        int testPizza2TheoryPrice = 19;
        assertEquals(testPizza2TheoryPrice, testPizza2.pizzaPrice());
        
        BuildYourOwn testPizza3 = new BuildYourOwn(Pizza.BUILD_YOUR_OWN, Pizza.LARGE, 
                new ArrayList<String>(Arrays.asList("Sausage", "Pepperoni", "Green Pepper", "Onion")));
        int testPizza3TheoryPrice = 17;
        assertEquals(testPizza3TheoryPrice, testPizza3.pizzaPrice());
        
        BuildYourOwn testPizza4 = new BuildYourOwn(Pizza.BUILD_YOUR_OWN, Pizza.LARGE, 
                new ArrayList<String>(Arrays.asList("Sausage", "Pepperoni", "Green Pepper")));
        int testPizza4TheoryPrice = 15;
        assertEquals(testPizza4TheoryPrice, testPizza4.pizzaPrice());
        
        BuildYourOwn testPizza5 = new BuildYourOwn(Pizza.BUILD_YOUR_OWN, Pizza.LARGE, 
                new ArrayList<String>(Arrays.asList("Sausage", "Pepperoni")));
        int testPizza5TheoryPrice = 13;
        assertEquals(testPizza5TheoryPrice, testPizza5.pizzaPrice());
        
        BuildYourOwn testPizza6 = new BuildYourOwn(Pizza.BUILD_YOUR_OWN, Pizza.LARGE, 
                new ArrayList<String>(Arrays.asList("Sausage")));
        int testPizza6TheoryPrice = 11;
        assertEquals(testPizza6TheoryPrice, testPizza6.pizzaPrice());
    }
}
