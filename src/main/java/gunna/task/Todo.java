package gunna.task;

/**
 * Represents a todo task without any date/time attached.
 * A todo task only has a description and a completion status.
 */
public class Todo extends Task {

    /**
     * Creates a new Todo task with the given description.
     *
     * @param description The description of the todo task.
     */
    public Todo(String description) {
        super(description);
    }

    /**
     * Converts the todo task to a file-safe format for storage.
     * Format: T | status | description
     *
     * @return A pipe-separated string representation of the todo task.
     */
    @Override
    public String toFileFormat() {
        return "T | " + (isDone ? "1" : "0") + " | " + description;
    }

    /**
     * Returns a string representation of the todo task for display.
     * Format: [T][status icon] description
     *
     * @return The string representation of the todo task.
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
