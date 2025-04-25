package org.howard.edu.lspfinal.question3;

/**
 * Demonstrates the Template Method pattern with different report types.
 * @author Syrr Gordon
 */
public class Driver {
    /**
     * Main method to generate and print different types of reports.
     * 
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        Report sales = new SalesReport();
        sales.generateReport();

        System.out.println();

        Report inventory = new InventoryReport();
        inventory.generateReport();

        System.out.println();

        Report finance = new FinanceReport();
        finance.generateReport();
    }
}