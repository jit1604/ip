import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Main class for the Gunna task management application.
 * Coordinates the UI, storage, and task list components.
 */
public class Gunna {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    /**
     * Constructs a Gunna instance with the specified file path for data storage.
     *
     * @param filePath The path to the data file for saving/loading tasks.
     */
    public Gunna(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        tasks = new TaskList(storage.loadTasks());
    }

    /**
     * Runs the main command loop of the application.
     * Displays welcome message, processes commands, and handles user interaction.
     */
    public void run() {
        ui.showWelcome();

        String command;

        while (true) {
            command = ui.readCommand();

            if (command.equals("bye")) {
                ui.showGoodbye();
                break;
            } else if (command.equals("list")) {
                ui.showTaskList(tasks.getTasks());
            } else if (command.equals("mark") || command.startsWith("mark ")) {
                String argument = Parser.getArgument(command, "mark");

                if (argument.trim().isEmpty()) {
                    ui.showError("OOPS!!! Please specify which task to mark.\n     Usage: mark <task number>");
                } else {
                    try {
                        int taskIndex = Parser.parseTaskNumber(argument);

                        if (taskIndex >= tasks.size()) {
                            ui.showError("OOPS!!! Task number " + (taskIndex + 1) + " doesn't exist.\n"
                                    + "     You have " + tasks.size() + " task(s) in your list.");
                        } else {
                            tasks.mark(taskIndex);
                            ui.showTaskMarked(tasks.get(taskIndex));
                            storage.saveTasks(tasks.getTasks());
                        }
                    } catch (NumberFormatException e) {
                        ui.showError("OOPS!!! Task number must be a valid number.");
                    } catch (IndexOutOfBoundsException e) {
                        ui.showError("OOPS!!! Task number " + argument.trim() + " doesn't exist.\n"
                                + "     You have " + tasks.size() + " task(s) in your list.");
                    }
                }
            } else if (command.equals("unmark") || command.startsWith("unmark ")) {
                String argument = Parser.getArgument(command, "unmark");

                if (argument.trim().isEmpty()) {
                    ui.showError("OOPS!!! Please specify which task to unmark.\n     Usage: unmark <task number>");
                } else {
                    try {
                        int taskIndex = Parser.parseTaskNumber(argument);

                        if (taskIndex >= tasks.size()) {
                            ui.showError("OOPS!!! Task number " + (taskIndex + 1) + " doesn't exist.\n"
                                    + "     You have " + tasks.size() + " task(s) in your list.");
                        } else {
                            tasks.unmark(taskIndex);
                            ui.showTaskUnmarked(tasks.get(taskIndex));
                            storage.saveTasks(tasks.getTasks());
                        }
                    } catch (NumberFormatException e) {
                        ui.showError("OOPS!!! Task number must be a valid number.");
                    } catch (IndexOutOfBoundsException e) {
                        ui.showError("OOPS!!! Task number " + argument.trim() + " doesn't exist.\n"
                                + "     You have " + tasks.size() + " task(s) in your list.");
                    }
                }
            } else if (command.equals("todo") || command.startsWith("todo ")) {
                String description = Parser.parseTodo(command);

                if (description.isEmpty()) {
                    ui.showError("OOPS!!! The description of a todo cannot be empty.");
                } else {
                    Task newTask = new Todo(description);
                    tasks.add(newTask);
                    ui.showTaskAdded(newTask, tasks.size());
                    storage.saveTasks(tasks.getTasks());
                }
            } else if (command.equals("deadline") || command.startsWith("deadline ")) {
                String[] parts = Parser.parseDeadline(command);

                if (parts == null) {
                    ui.showError("OOPS!!! Please use the format: deadline <description> /by <time>");
                } else {
                    String description = parts[0];
                    String by = parts[1];

                    if (description.isEmpty()) {
                        ui.showError("OOPS!!! The description of a deadline cannot be empty.");
                    } else if (by.isEmpty()) {
                        ui.showError("OOPS!!! The deadline time cannot be empty.");
                    } else {
                        try {
                            Task newTask = Deadline.createWithDateString(description, by);
                            tasks.add(newTask);
                            ui.showTaskAdded(newTask, tasks.size());
                            storage.saveTasks(tasks.getTasks());
                        } catch (DateTimeParseException e) {
                            ui.showError("OOPS!!! Invalid date format. Please use: yyyy-MM-dd (e.g., 2019-12-31)");
                        }
                    }
                }
            } else if (command.equals("event") || command.startsWith("event ")) {
                String[] parts = Parser.parseEvent(command);

                if (parts == null) {
                    ui.showError("OOPS!!! Please use the format: event <description> /from <time> /to <time>");
                } else {
                    String description = parts[0];
                    String from = parts[1];
                    String to = parts[2];

                    if (description.isEmpty()) {
                        ui.showError("OOPS!!! The description of an event cannot be empty.");
                    } else if (from.isEmpty() || to.isEmpty()) {
                        ui.showError("OOPS!!! The event time cannot be empty.");
                    } else {
                        Task newTask = new Event(description, from, to);
                        tasks.add(newTask);
                        ui.showTaskAdded(newTask, tasks.size());
                        storage.saveTasks(tasks.getTasks());
                    }
                }
            } else if (command.equals("delete") || command.startsWith("delete ")) {
                String argument = Parser.getArgument(command, "delete");

                if (argument.trim().isEmpty()) {
                    ui.showError("OOPS!!! Please specify which task to delete.\n     Usage: delete <task number>");
                } else {
                    try {
                        int taskIndex = Parser.parseTaskNumber(argument);

                        if (taskIndex >= tasks.size()) {
                            ui.showError("OOPS!!! Task number " + (taskIndex + 1) + " doesn't exist.\n"
                                    + "     You have " + tasks.size() + " task(s) in your list.");
                        } else {
                            Task removedTask = tasks.delete(taskIndex);
                            ui.showTaskDeleted(removedTask, tasks.size());
                            storage.saveTasks(tasks.getTasks());
                        }
                    } catch (NumberFormatException e) {
                        ui.showError("OOPS!!! Task number must be a valid number.");
                    } catch (IndexOutOfBoundsException e) {
                        ui.showError("OOPS!!! Task number " + argument.trim() + " doesn't exist.\n"
                                + "     You have " + tasks.size() + " task(s) in your list.");
                    }
                }
            } else if (command.equals("on") || command.startsWith("on ")) {
                String dateStr = Parser.parseDate(command);

                if (dateStr.isEmpty()) {
                    ui.showError("OOPS!!! Please specify a date.\n     Usage: on <yyyy-MM-dd>");
                } else {
                    try {
                        LocalDate searchDate = LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                        String formattedDate = searchDate.format(DateTimeFormatter.ofPattern("MMM dd yyyy"));
                        ui.showTasksOnDate(tasks.getTasksOnDate(searchDate), formattedDate);
                    } catch (DateTimeParseException e) {
                        ui.showError("OOPS!!! Invalid date format. Please use: yyyy-MM-dd (e.g., 2019-12-31)");
                    }
                }
            } else {
                ui.showError("OOPS!!! I'm sorry, but I don't know what that means :-(");
            }
        }

        ui.close();
    }

    /**
     * Main entry point for the application.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        String filePath = "data" + File.separator + "duke.txt";
        new Gunna(filePath).run();
    }
}
