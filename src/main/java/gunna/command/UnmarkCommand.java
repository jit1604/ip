package gunna.command;

import gunna.DukeException;
import gunna.Storage;
import gunna.TaskList;
import gunna.Ui;
/**
 * Represents a command to unmark a task (mark as not done).
 */
public class UnmarkCommand extends Command {
    private int taskIndex;

    /**
     * Constructs an UnmarkCommand with the specified task index.
     *
     * @param taskIndex The 0-based index of the task to unmark.
     */
    public UnmarkCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }

    /**
     * Executes the unmark command by marking the specified task as not done.
     *
     * @param tasks The task list containing the task.
     * @param ui The UI to display success message.
     * @param storage The storage to save the updated task list.
     * @throws DukeException If the task index is out of bounds.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        if (taskIndex < 0 || taskIndex >= tasks.size()) {
            throw new DukeException("OOPS!!! Task number " + (taskIndex + 1) + " doesn't exist.\n"
                    + "     You have " + tasks.size() + " task(s) in your list.");
        }
        tasks.unmark(taskIndex);
        ui.showTaskUnmarked(tasks.get(taskIndex));
        storage.saveTasks(tasks.getTasks());
    }
}
