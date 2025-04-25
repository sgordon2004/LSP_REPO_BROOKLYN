package org.howard.edu.lspfinal.question2;

/**
 * Thrown when a task cannot be found in the TaskManager.
 */
public class TaskNotFoundException extends Exception {
    /**
     * Constructs a new TaskNotFoundException with the specified detail message.
     * 
     * @param message the detail message
     */
    public TaskNotFoundException(String message) {
        super(message);
    }
}