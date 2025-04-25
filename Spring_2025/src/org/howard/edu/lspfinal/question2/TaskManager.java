package org.howard.edu.lspfinal.question2;

import java.util.*;
import org.howard.edu.lspfinal.question2.DuplicateTaskException;
import org.howard.edu.lspfinal.question2.TaskNotFoundException;

/**
 * TaskManager class manages a collection of tasks.
 * Supports adding, retrieving, updating, and grouping tasks by status.
 */
public class TaskManager {
    private Map<String, Task> tasks = new HashMap<>();

    /**
     * Adds a new task to the manager.
     * 
     * @param name     the unique name of the task
     * @param priority the priority of the task (lower number = higher priority)
     * @param status   the initial status ("TODO", "IN_PROGRESS", or "DONE")
     * @throws DuplicateTaskException if a task with the same name already exists
     */
    public void addTask(String name, int priority, String status) throws DuplicateTaskException {
        if (tasks.containsKey(name)) {
            throw new DuplicateTaskException("Task '" + name + "' already exists.");
        }
        tasks.put(name, new Task(name, priority, status));
    }

    /**
     * Retrieves a task by its name.
     * 
     * @param name the name of the task to retrieve
     * @return the Task object
     * @throws TaskNotFoundException if the task does not exist
     */
    public Task getTaskByName(String name) throws TaskNotFoundException {
        Task task = tasks.get(name);
        if (task == null) {
            throw new TaskNotFoundException("Task '" + name + "' not found.");
        }
        return task;
    }

    /**
     * Updates the status of an existing task.
     * 
     * @param name   the name of the task
     * @param status the new status to assign ("TODO", "IN_PROGRESS", or "DONE")
     * @throws TaskNotFoundException if the task does not exist or status is invalid
     */
    public void updateStatus(String name, String status) throws TaskNotFoundException {
        if (!status.equals("TODO") && !status.equals("IN_PROGRESS") && !status.equals("DONE")) {
            throw new TaskNotFoundException("Invalid status: '" + status + "'. Must be TODO, IN_PROGRESS, or DONE.");
        }

        Task task = getTaskByName(name);  // this will already throw TaskNotFoundException if not found
        task.setStatus(status);
    }

    /**
     * Prints all tasks grouped by their status category.
     * Groups include TODO, IN_PROGRESS, and DONE.
     */
    public void printTasksGroupedByStatus() {
        Map<String, List<Task>> grouped = new LinkedHashMap<>();
        grouped.put("TODO", new ArrayList<>());
        grouped.put("IN_PROGRESS", new ArrayList<>());
        grouped.put("DONE", new ArrayList<>());

        for (Task task : tasks.values()) {
            grouped.get(task.getStatus()).add(task);
        }

        System.out.println("Tasks grouped by status:");
        for (String status : grouped.keySet()) {
            System.out.println(status + ":");
            for (Task task : grouped.get(status)) {
                System.out.println("  " + task);
            }
        }
    }
}