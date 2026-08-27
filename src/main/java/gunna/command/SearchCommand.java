package gunna.command;

import gunna.DukeException;
import gunna.Storage;
import gunna.TaskList;
import gunna.Ui;

/**
 * Represents a command to search for tasks by keyword.
 * Searches task descriptions for the given keyword and displays matching tasks.
 */
public class SearchCommand extends Command {
    private String keyword;

    /**
     * Constructs a SearchCommand with the specified search keyword.
     *
     * @param keyword The keyword to search for in task descriptions.
     */
    public SearchCommand(String keyword) {
        this.keyword = keyword;
    }

    /**
     * Executes the search command by finding and displaying matching tasks.
     *
     * @param tasks The task list to search.
     * @param ui The UI to display the search results.
     * @param storage The storage (not used).
     * @throws DukeException If the keyword is empty.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        if (keyword.isEmpty()) {
            throw new DukeException("OOPS!!! Please specify a search keyword.\n     Usage: find <keyword>");
        }
        ui.showSearchResults(tasks.findTasksByKeyword(keyword), keyword);
    }
}
