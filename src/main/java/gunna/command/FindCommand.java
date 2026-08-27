package gunna.command;

import gunna.DukeException;
import gunna.Storage;
import gunna.TaskList;
import gunna.Ui;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Represents a command to find tasks on a specific date.
 */
public class FindCommand extends Command {
    private String dateStr;

    /**
     * Constructs a FindCommand with the specified date string.
     *
     * @param dateStr The date string in yyyy-MM-dd format.
     */
    public FindCommand(String dateStr) {
        this.dateStr = dateStr;
    }

    /**
     * Executes the find command by searching for tasks on the specified date.
     *
     * @param tasks The task list to search.
     * @param ui The UI to display the matching tasks.
     * @param storage The storage (not used).
     * @throws DukeException If the date string is empty or has an invalid format.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        if (dateStr.isEmpty()) {
            throw new DukeException("OOPS!!! Please specify a date.\n     Usage: on <yyyy-MM-dd>");
        }
        try {
            LocalDate searchDate = LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            String formattedDate = searchDate.format(DateTimeFormatter.ofPattern("MMM dd yyyy"));
            ui.showTasksOnDate(tasks.getTasksOnDate(searchDate), formattedDate);
        } catch (DateTimeParseException e) {
            throw new DukeException("OOPS!!! Invalid date format. Please use: yyyy-MM-dd (e.g., 2019-12-31)");
        }
    }
}
