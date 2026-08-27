package gunna.task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Represents a deadline task with a specific due date.
 */
public class Deadline extends Task {
    protected LocalDate by;
    private static final DateTimeFormatter INPUT_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter OUTPUT_FORMAT = DateTimeFormatter.ofPattern("MMM dd yyyy");

    /**
     * Creates a Deadline task with a date.
     *
     * @param description The task description.
     * @param by The deadline date.
     */
    public Deadline(String description, LocalDate by) {
        super(description);
        this.by = by;
    }

    /**
     * Creates a Deadline task by parsing a date string.
     *
     * @param description The task description.
     * @param byStr The deadline date string in yyyy-MM-dd format.
     * @throws DateTimeParseException if the date string cannot be parsed.
     */
    public static Deadline createWithDateString(String description, String byStr) throws DateTimeParseException {
        LocalDate by = LocalDate.parse(byStr, INPUT_FORMAT);
        return new Deadline(description, by);
    }

    public LocalDate getByDate() {
        return this.by;
    }

    public String getBy() {
        return this.by.format(OUTPUT_FORMAT);
    }

    /**
     * Returns the date in storage format (yyyy-MM-dd).
     */
    public String getByForStorage() {
        return this.by.format(INPUT_FORMAT);
    }

    @Override
    public String toFileFormat() {
        return "D | " + (isDone ? "1" : "0") + " | " + description + " | " + by.format(INPUT_FORMAT);
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by.format(OUTPUT_FORMAT) + ")";
    }
}
