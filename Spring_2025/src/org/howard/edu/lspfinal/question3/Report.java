package org.howard.edu.lspfinal.question3;

/**
 * Abstract base class for reports. Defines the template method
 * for generating reports and abstract steps that must be implemented
 * by concrete subclasses.
 * @author Syrr Gordon
 */
public abstract class Report {
    /**
     * Template method to generate a report.
     * This defines the high-level workflow that subclasses must follow.
     */
    public final void generateReport() {
        loadData();
        formatData();
        printReport();
    }

    /**
     * Load the data for the report. Implemented by subclass.
     */
    protected abstract void loadData();

    /**
     * Format the data for the report. Implemented by subclass.
     */
    protected abstract void formatData();

    /**
     * Print the final report. Implemented by subclass.
     */
    protected abstract void printReport();
}