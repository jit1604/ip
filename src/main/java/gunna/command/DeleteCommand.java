package gunna.command;

import gunna.DukeException;
import gunna.Storage;
import gunna.TaskList;
import gunna.Ui;
import gunna.task.Task;
/**
 * Represents a command to delete a task.
 */
public class DeleteCommand extends Command {
    private int taskIndex;

    /**
     * Constructs a DeleteCommand with the specified task index.
     *
     * @param taskIndex The 0-based index of the task to delete.
     */
    public DeleteCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }

    /**
     * Executes the delete command by removing the specified task.
     *
     * @param tasks The task list containing the task.
     * @param ui The UI to display success message.
     * @param storage The storage to save the updated task list.
     * @throws DukeException If the task index is out of bounds.
     */
    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        if (taskIndex < 0 || taskIndex >= tasks.size()) {
            throw new DukeException("OOPS!!! Task number " + (taskIndex + 1) + " doesn't exist.\n"
                    + "     You have " + tasks.size() + " task(s) in your list.");
        }
        Task removedTask = tasks.delete(taskIndex);
        ui.showTaskDeleted(removedTask, tasks.size());
        storage.saveTasks(tasks.getTasks());
        return "Noted. I've removed this task:\n  " + removedTask
                + "\nNow you have " + tasks.size() + " tasks in the list.";
    }
}
