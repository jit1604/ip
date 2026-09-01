package gunna.command;

import java.time.format.DateTimeParseException;

import gunna.DukeException;
import gunna.Storage;
import gunna.TaskList;
import gunna.Ui;
import gunna.task.Deadline;
import gunna.task.Task;

/**
 * Represents a command to add a deadline task.
 */
public class DeadlineCommand extends Command {
    private String description;
    private String by;

    /**
     * Constructs a DeadlineCommand with the specified description and deadline.
     *
     * @param description The description of the deadline task.
     * @param by The deadline time/date string.
     */
    public DeadlineCommand(String description, String by) {
        this.description = description;
        this.by = by;
    }

    /**
     * Executes the deadline command by creating and adding a new deadline task.
     *
     * @param tasks The task list to add the task to.
     * @param ui The UI to display success message.
     * @param storage The storage to save the updated task list.
     * @throws DukeException If the description or deadline is empty, or if the date format is invalid.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        if (description.isEmpty()) {
            throw new DukeException("OOPS!!! The description of a deadline cannot be empty.");
        }
        if (by.isEmpty()) {
            throw new DukeException("OOPS!!! The deadline time cannot be empty.");
        }
        try {
            Task newTask = Deadline.createWithDateString(description, by);
            tasks.add(newTask);
            ui.showTaskAdded(newTask, tasks.size());
            storage.saveTasks(tasks.getTasks());
        } catch (DateTimeParseException e) {
            throw new DukeException("OOPS!!! Invalid date format. Please use: yyyy-MM-dd (e.g., 2019-12-31)");
        }
    }
}
