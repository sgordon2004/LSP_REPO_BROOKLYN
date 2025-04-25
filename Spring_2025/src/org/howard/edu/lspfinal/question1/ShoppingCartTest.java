package org.howard.edu.lspfinal.question1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;


public class ShoppingCartTest {
	private ShoppingCart cart;
	
	@BeforeEach
    public void setUp() {
        cart = new ShoppingCart();
    }
	
    @Test
    @DisplayName("Test adding valid item")
    public void testAddValidItem() {
        cart.addItem("Apple", 1.50);
        assertEquals(1.50, cart.getTotalCost(), 0.001); // 0.001 used for float comparison tolerance, neglecting small rounding errors
    }

    @Test
    @DisplayName("Test adding item with 0 price (expect exception)")
    public void testAddItemWithZeroPrice() {
        cart.addItem("Bananas", 0.0);
        assertEquals(0.0, cart.getTotalCost(), 0.001);
        // NOTE: Originally expected exception for price = 0, but the method allows for prices of 0.
        //		 Professor clarified that this was a mistake.
        //       Since source code cannot be modified, I am testing behavior as implemented.
    }

    @Test
    @DisplayName("Test adding item with negative price (expect exception)")
    public void testAddItemWithNegativePrice() {
        assertThrows(IllegalArgumentException.class, () -> {
        	cart.addItem("Ground Beef", -7.20);
        });
    }

    @Test
    @DisplayName("Test applying 'SAVE10'")
    public void testApplySave10() {
        cart.addItem("Filet Mignon", 50.0);
        cart.applyDiscountCode("SAVE10");
        assertEquals(45.0, cart.getTotalCost(), 0.001);
        assertEquals(10.0, cart.getDiscountPercentage());
    }

    @Test
    @DisplayName("Test applying 'SAVE20'")
    public void testApplySave20() {
    	cart.addItem("Filet Mignon", 50.0);
        cart.applyDiscountCode("SAVE20");
        assertEquals(40.0, cart.getTotalCost(), 0.001);
        assertEquals(20.0, cart.getDiscountPercentage());
    }

    @Test
    @DisplayName("Test applying invalid code (expect exception)")
    public void testApplyInvalidCode() {
    	cart.addItem("Filet Mignon", 50.0);
        assertThrows(IllegalArgumentException.class, () -> {
        	cart.applyDiscountCode("SAVE70");
        });
        
    }

    @Test
    @DisplayName("Test total cost without discount")
    public void testTotalCostNoDiscount() {
    	cart.addItem("Apple", 1.50);
    	cart.addItem("Bananas", 4.00);
    	cart.addItem("Filet Mignon", 55.0);
    	cart.addItem("Lobster", 65.0);
    	assertEquals(125.5, cart.getTotalCost(), 0.001);
    }

    @Test
    @DisplayName("Test total cost with discount")
    public void testTotalCostWithDiscount() {
    	cart.addItem("Apple", 1.50);
    	cart.addItem("Bananas", 4.00);
    	cart.addItem("Filet Mignon", 55.0);
    	cart.addItem("Lobster", 65.0);
    	cart.applyDiscountCode("SAVE20");
    	assertEquals(100.40, cart.getTotalCost(), 0.001);
    }

    @Test
    @DisplayName("Test total cost with empty cart")
    public void testTotalCostEmptyCart() {
    	assertEquals(0.0, cart.getTotalCost(), 0.001);
    }

    // Add additional test cases for removing items and checking cart size if needed.
    @Test
    @DisplayName("Test removing existing item")
    public void testRemoveExistingItem() {
        cart.addItem("Apple", 1.50);
        cart.removeItem("Apple");
        assertEquals(0.0, cart.getTotalCost(), 0.001);
        assertEquals(0, cart.getCartSize());
    }

    @Test
    @DisplayName("Test removing non-existent item (expect exception)")
    public void testRemoveNonExistentItem() {
        assertThrows(IllegalArgumentException.class, () -> {
            cart.removeItem("Nonexistent Item");
        });
    }
}