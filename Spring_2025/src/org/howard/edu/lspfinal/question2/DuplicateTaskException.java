package org.howard.edu.lspfinal.question2;

/**
 * Thrown when an attempt is made to add a task with a name that already exists.
 */
public class DuplicateTaskException extends Exception {
    /**
     * Constructs a new DuplicateTaskException with the specified detail message.
     * 
     * @param message the detail message
     */
    public DuplicateTaskException(String message) {
        super(message);
    }
}