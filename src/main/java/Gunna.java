import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class Gunna {
    public static void main(String[] args) {
        // Initialize UI for user interactions
        Ui ui = new Ui();

        // Show welcome message
        ui.showWelcome();

        // Storage to save/load tasks from disk
        // Using OS-independent path construction with relative path
        String filePath = "data" + File.separator + "duke.txt";
        Storage storage = new Storage(filePath);

        // Load tasks from file
        ArrayList<Task> tasks = storage.loadTasks();

        String command;

        while (true) {
            command = ui.readCommand();

            if (command.equals("bye")) {
                ui.showGoodbye();
                break;
            } else if (command.equals("list")) {
                ui.showTaskList(tasks);
            } else if (command.equals("mark") || command.startsWith("mark ")) {
                // Parse task number from "mark N"
                String numStr = command.length() > 5 ? command.substring(5).trim() : "";

                if (numStr.isEmpty()) {
                    ui.showError("OOPS!!! Please specify which task to mark.\n     Usage: mark <task number>");
                } else {
                    try {
                        int taskNumber = Integer.parseInt(numStr);
                        int taskIndex = taskNumber - 1;

                        if (taskIndex < 0 || taskIndex >= tasks.size()) {
                            ui.showError("OOPS!!! Task number " + taskNumber + " doesn't exist.\n"
                                    + "     You have " + tasks.size() + " task(s) in your list.");
                        } else {
                            tasks.get(taskIndex).markAsDone();
                            ui.showTaskMarked(tasks.get(taskIndex));
                            storage.saveTasks(tasks);
                        }
                    } catch (NumberFormatException e) {
                        ui.showError("OOPS!!! Task number must be a valid number.");
                    }
                }
            } else if (command.equals("unmark") || command.startsWith("unmark ")) {
                // Parse task number from "unmark N"
                String numStr = command.length() > 7 ? command.substring(7).trim() : "";

                if (numStr.isEmpty()) {
                    ui.showError("OOPS!!! Please specify which task to unmark.\n     Usage: unmark <task number>");
                } else {
                    try {
                        int taskNumber = Integer.parseInt(numStr);
                        int taskIndex = taskNumber - 1;

                        if (taskIndex < 0 || taskIndex >= tasks.size()) {
                            ui.showError("OOPS!!! Task number " + taskNumber + " doesn't exist.\n"
                                    + "     You have " + tasks.size() + " task(s) in your list.");
                        } else {
                            tasks.get(taskIndex).markAsNotDone();
                            ui.showTaskUnmarked(tasks.get(taskIndex));
                            storage.saveTasks(tasks);
                        }
                    } catch (NumberFormatException e) {
                        ui.showError("OOPS!!! Task number must be a valid number.");
                    }
                }
            } else if (command.equals("todo") || command.startsWith("todo ")) {
                // Parse todo command
                String description = command.length() > 5 ? command.substring(5).trim() : "";

                if (description.isEmpty()) {
                    ui.showError("OOPS!!! The description of a todo cannot be empty.");
                } else {
                    Task newTask = new Todo(description);
                    tasks.add(newTask);
                    ui.showTaskAdded(newTask, tasks.size());
                    storage.saveTasks(tasks);
                }
            } else if (command.equals("deadline") || command.startsWith("deadline ")) {
                // Parse deadline command: deadline <description> /by <time>
                String remaining = command.length() > 9 ? command.substring(9) : "";
                int byIndex = remaining.indexOf(" /by ");
                boolean hasTrailingSpace = true;

                // Also check for /by at the end without trailing space
                if (byIndex == -1 && remaining.endsWith(" /by")) {
                    byIndex = remaining.lastIndexOf(" /by");
                    hasTrailingSpace = false;
                }

                if (byIndex == -1) {
                    ui.showError("OOPS!!! Please use the format: deadline <description> /by <time>");
                } else {
                    String description = remaining.substring(0, byIndex).trim();
                    String by;
                    if (hasTrailingSpace) {
                        by = remaining.substring(byIndex + 5).trim();
                    } else {
                        by = remaining.substring(byIndex + 4).trim();  // " /by" is 4 chars
                    }

                    if (description.isEmpty()) {
                        ui.showError("OOPS!!! The description of a deadline cannot be empty.");
                    } else if (by.isEmpty()) {
                        ui.showError("OOPS!!! The deadline time cannot be empty.");
                    } else {
                        try {
                            Task newTask = Deadline.createWithDateString(description, by);
                            tasks.add(newTask);
                            ui.showTaskAdded(newTask, tasks.size());
                            storage.saveTasks(tasks);
                        } catch (DateTimeParseException e) {
                            ui.showError("OOPS!!! Invalid date format. Please use: yyyy-MM-dd (e.g., 2019-12-31)");
                        }
                    }
                }
            } else if (command.equals("event") || command.startsWith("event ")) {
                // Parse event command: event <description> /from <time> /to <time>
                String remaining = command.length() > 6 ? command.substring(6) : "";
                int fromIndex = remaining.indexOf(" /from ");
                int toIndex = remaining.indexOf(" /to ");

                // Check for /to without trailing space at the end
                if (toIndex == -1 && remaining.contains(" /to")) {
                    toIndex = remaining.lastIndexOf(" /to");
                }

                if (fromIndex == -1 || toIndex == -1 || fromIndex + 7 > toIndex) {
                    ui.showError("OOPS!!! Please use the format: event <description> /from <time> /to <time>");
                } else {
                    String description = remaining.substring(0, fromIndex).trim();
                    String from = remaining.substring(fromIndex + 7, toIndex).trim();
                    String to;
                    // Handle both " /to " and " /to" (at end without trailing space)
                    if (remaining.indexOf(" /to ") != -1) {
                        to = remaining.substring(toIndex + 5).trim();
                    } else {
                        to = remaining.substring(toIndex + 4).trim();  // " /to" is 4 chars
                    }

                    if (description.isEmpty()) {
                        ui.showError("OOPS!!! The description of an event cannot be empty.");
                    } else if (from.isEmpty() || to.isEmpty()) {
                        ui.showError("OOPS!!! The event time cannot be empty.");
                    } else {
                        Task newTask = new Event(description, from, to);
                        tasks.add(newTask);
                        ui.showTaskAdded(newTask, tasks.size());
                        storage.saveTasks(tasks);
                    }
                }
            } else if (command.equals("delete") || command.startsWith("delete ")) {
                // Parse delete command: delete <task number>
                String numStr = command.length() > 7 ? command.substring(7).trim() : "";

                if (numStr.isEmpty()) {
                    ui.showError("OOPS!!! Please specify which task to delete.\n     Usage: delete <task number>");
                } else {
                    try {
                        int taskNumber = Integer.parseInt(numStr);
                        int taskIndex = taskNumber - 1;

                        if (taskIndex < 0 || taskIndex >= tasks.size()) {
                            ui.showError("OOPS!!! Task number " + taskNumber + " doesn't exist.\n"
                                    + "     You have " + tasks.size() + " task(s) in your list.");
                        } else {
                            Task removedTask = tasks.remove(taskIndex);
                            ui.showTaskDeleted(removedTask, tasks.size());
                            storage.saveTasks(tasks);
                        }
                    } catch (NumberFormatException e) {
                        ui.showError("OOPS!!! Task number must be a valid number.");
                    }
                }
            } else if (command.equals("on") || command.startsWith("on ")) {
                // Parse on command: on <date>
                String dateStr = command.length() > 3 ? command.substring(3).trim() : "";

                if (dateStr.isEmpty()) {
                    ui.showError("OOPS!!! Please specify a date.\n     Usage: on <yyyy-MM-dd>");
                } else {
                    try {
                        LocalDate searchDate = LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                        ArrayList<Task> matchingTasks = new ArrayList<>();

                        // Find all tasks on this date
                        for (Task task : tasks) {
                            if (task instanceof Deadline) {
                                Deadline deadline = (Deadline) task;
                                if (deadline.getByDate().equals(searchDate)) {
                                    matchingTasks.add(task);
                                }
                            }
                        }

                        String formattedDate = searchDate.format(DateTimeFormatter.ofPattern("MMM dd yyyy"));
                        ui.showTasksOnDate(matchingTasks, formattedDate);
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
}
