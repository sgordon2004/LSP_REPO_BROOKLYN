package org.howard.edu.lspfinal.question3;

/**
 * Concrete implementation of Report for finance data.
 */
public class FinanceReport extends Report {
    @Override
    protected void loadData() {
        System.out.println("Loading finance data...");
    }

    @Override
    protected void formatData() {
        System.out.println("Formatting finance data...");
    }

    @Override
    protected void printReport() {
        System.out.println("Printing finance report.");
    }
}