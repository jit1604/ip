/**
 * Represents a command to add a todo task.
 */
public class TodoCommand extends Command {
    private String description;

    /**
     * Constructs a TodoCommand with the specified task description.
     *
     * @param description The description of the todo task.
     */
    public TodoCommand(String description) {
        this.description = description;
    }

    /**
     * Executes the todo command by creating and adding a new todo task.
     *
     * @param tasks The task list to add the task to.
     * @param ui The UI to display success message.
     * @param storage The storage to save the updated task list.
     * @throws DukeException If the description is empty.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        if (description.isEmpty()) {
            throw new DukeException("OOPS!!! The description of a todo cannot be empty.");
        }
        Task newTask = new Todo(description);
        tasks.add(newTask);
        ui.showTaskAdded(newTask, tasks.size());
        storage.saveTasks(tasks.getTasks());
    }
}
