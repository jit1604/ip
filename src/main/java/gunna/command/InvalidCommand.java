package gunna.command;

import gunna.DukeException;
import gunna.Storage;
import gunna.TaskList;
import gunna.Ui;
/**
 * Represents an invalid or unknown command.
 */
public class InvalidCommand extends Command {

    /**
     * Executes the invalid command by showing an error message.
     *
     * @param tasks The task list (not used).
     * @param ui The UI to display error message.
     * @param storage The storage (not used).
     * @throws DukeException Always throws with an unknown command message.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        throw new DukeException("OOPS!!! I'm sorry, but I don't know what that means :-(");
    }
}
