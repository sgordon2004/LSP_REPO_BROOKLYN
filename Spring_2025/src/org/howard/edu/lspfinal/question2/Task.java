package org.howard.edu.lspfinal.question2;

/**
 * Represents a Task with a unique name, a priority, and a status.
 * Used by TaskManager to track and manage individual tasks.
 * @author Syrr Gordon
 */
public class Task {
    private String name;
    private int priority;
    private String status;

    /**
     * Constructs a Task with the given name, priority, and status.
     * 
     * @param name     the unique name of the task
     * @param priority the task's priority (lower number = higher priority)
     * @param status   the task's current status ("TODO", "IN_PROGRESS", or "DONE")
     */
    public Task(String name, int priority, String status) {
        this.name = name;
        this.priority = priority;
        this.status = status;
    }

    /**
     * Returns the name of the task.
     * 
     * @return task name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the priority of the task.
     * 
     * @return task priority
     */
    public int getPriority() {
        return priority;
    }

    /**
     * Returns the current status of the task.
     * 
     * @return task status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Updates the status of the task.
     * 
     * @param status the new status to assign
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Returns a string representation of the task.
     */
    @Override
    public String toString() {
        return "Task{name='" + name + "', priority=" + priority + ", status='" + status + "'}";
    }
}