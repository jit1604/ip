package gunna;

import gunna.task.Task;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Handles all interactions with the user.
 * Responsible for reading user input and displaying messages to the user.
 */
public class Ui {
    private static final String DELIMITER = "____________________________________________________________";
    private static final String BANNER =
            "    ____                         \n"
            + " / ___|_   _ _ __  _ __   __ _ \n"
            + "| |  _| | | | '_ \\| '_ \\ / _` |\n"
            + "| |_| | |_| | | | | | | | (_| |\n"
            + " \\____|\\__,_|_| |_|_| |_|\\__,_|\n";

    private Scanner scanner;

    /**
     * Creates a Ui instance and initializes the scanner for user input.
     */
    public Ui() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Displays the welcome message when the application starts.
     */
    public void showWelcome() {
        System.out.println(DELIMITER);
        System.out.println(BANNER);
        System.out.println("     Hello! I'm GUNNA.");
        System.out.println("     What can I do for you?");
        System.out.println(DELIMITER);
    }

    /**
     * Displays the goodbye message when the user exits.
     */
    public void showGoodbye() {
        System.out.println(DELIMITER);
        System.out.println("     Bye. Hope to see you again soon!");
        System.out.println(DELIMITER);
    }

    /**
     * Displays the delimiter line.
     */
    public void showLine() {
        System.out.println(DELIMITER);
    }

    /**
     * Reads a command from the user.
     *
     * @return The command entered by the user.
     */
    public String readCommand() {
        return scanner.nextLine();
    }

    /**
     * Displays the task list to the user.
     *
     * @param tasks The list of tasks to display.
     */
    public void showTaskList(ArrayList<Task> tasks) {
        System.out.println(DELIMITER);
        System.out.println("     Here are the tasks in your list:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println("     " + (i + 1) + "." + tasks.get(i));
        }
        System.out.println(DELIMITER);
    }

    /**
     * Displays a message when a task is successfully added.
     *
     * @param task The task that was added.
     * @param taskCount The total number of tasks in the list.
     */
    public void showTaskAdded(Task task, int taskCount) {
        System.out.println(DELIMITER);
        System.out.println("     Got it. I've added this task:");
        System.out.println("       " + task);
        System.out.println("     Now you have " + taskCount + " tasks in the list.");
        System.out.println(DELIMITER);
    }

    /**
     * Displays a message when a task is successfully marked as done.
     *
     * @param task The task that was marked as done.
     */
    public void showTaskMarked(Task task) {
        System.out.println(DELIMITER);
        System.out.println("     Nice! I've marked this task as done:");
        System.out.println("       " + task);
        System.out.println(DELIMITER);
    }

    /**
     * Displays a message when a task is successfully unmarked.
     *
     * @param task The task that was unmarked.
     */
    public void showTaskUnmarked(Task task) {
        System.out.println(DELIMITER);
        System.out.println("     OK, I've marked this task as not done yet:");
        System.out.println("       " + task);
        System.out.println(DELIMITER);
    }

    /**
     * Displays a message when a task is successfully deleted.
     *
     * @param task The task that was deleted.
     * @param taskCount The total number of tasks remaining in the list.
     */
    public void showTaskDeleted(Task task, int taskCount) {
        System.out.println(DELIMITER);
        System.out.println("     Noted. I've removed this task:");
        System.out.println("       " + task);
        System.out.println("     Now you have " + taskCount + " tasks in the list.");
        System.out.println(DELIMITER);
    }

    /**
     * Displays an error message to the user.
     *
     * @param message The error message to display.
     */
    public void showError(String message) {
        System.out.println(DELIMITER);
        System.out.println("     " + message);
        System.out.println(DELIMITER);
    }

    /**
     * Displays tasks that occur on a specific date.
     *
     * @param tasks The list of tasks on the specified date.
     * @param dateStr The formatted date string.
     */
    public void showTasksOnDate(ArrayList<Task> tasks, String dateStr) {
        System.out.println(DELIMITER);
        if (tasks.isEmpty()) {
            System.out.println("     No tasks found on " + dateStr);
        } else {
            System.out.println("     Here are the tasks on " + dateStr + ":");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println("     " + (i + 1) + "." + tasks.get(i));
            }
        }
        System.out.println(DELIMITER);
    }

    /**
     * Closes the scanner resource.
     */
    public void close() {
        scanner.close();
    }
}
