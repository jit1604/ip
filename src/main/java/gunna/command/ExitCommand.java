package gunna.command;

import gunna.DukeException;
import gunna.Storage;
import gunna.TaskList;
import gunna.Ui;
/**
 * Represents a command to exit the application.
 */
public class ExitCommand extends Command {

    /**
     * Executes the exit command by displaying a goodbye message.
     *
     * @param tasks The task list (not used).
     * @param ui The UI to display the goodbye message.
     * @param storage The storage (not used).
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showGoodbye();
    }

    /**
     * Returns true to indicate the application should exit.
     *
     * @return true, always.
     */
    @Override
    public boolean isExit() {
        return true;
    }
}
