import java.util.Scanner;

public class Gunna {
    public static void main(String[] args) {
        String banner =
                "    ____                         \n"
                + " / ___|_   _ _ __  _ __   __ _ \n"
                + "| |  _| | | | '_ \\| '_ \\ / _` |\n"
                + "| |_| | |_| | | | | | | | (_| |\n"
                + " \\____|\\__,_|_| |_|_| |_|\\__,_|\n";

        String delimiter = "____________________________________________________________";

        System.out.println(delimiter);
        System.out.println(banner);
        System.out.println("     Hello! I'm GUNNA.");
        System.out.println("     What can I do for you?");
        System.out.println(delimiter);

        // Array to store tasks (max 100)
        Task[] tasks = new Task[100];
        int taskCount = 0;

        Scanner scanner = new Scanner(System.in);
        String command;

        while (true) {
            command = scanner.nextLine();

            if (command.equals("bye")) {
                System.out.println(delimiter);
                System.out.println("     Bye. Hope to see you again soon!");
                System.out.println(delimiter);
                break;
            } else if (command.equals("list")) {
                System.out.println(delimiter);
                System.out.println("     Here are the tasks in your list:");
                for (int i = 0; i < taskCount; i++) {
                    System.out.println("     " + (i + 1) + "." + tasks[i]);
                }
                System.out.println(delimiter);
            } else if (command.startsWith("mark ")) {
                // Parse task number from "mark N"
                int taskNumber = Integer.parseInt(command.substring(5));
                int taskIndex = taskNumber - 1;

                if (taskIndex >= 0 && taskIndex < taskCount) {
                    tasks[taskIndex].markAsDone();
                    System.out.println(delimiter);
                    System.out.println("     Nice! I've marked this task as done:");
                    System.out.println("       " + tasks[taskIndex]);
                    System.out.println(delimiter);
                }
            } else if (command.startsWith("unmark ")) {
                // Parse task number from "unmark N"
                int taskNumber = Integer.parseInt(command.substring(7));
                int taskIndex = taskNumber - 1;

                if (taskIndex >= 0 && taskIndex < taskCount) {
                    tasks[taskIndex].markAsNotDone();
                    System.out.println(delimiter);
                    System.out.println("     OK, I've marked this task as not done yet:");
                    System.out.println("       " + tasks[taskIndex]);
                    System.out.println(delimiter);
                }
            } else if (command.startsWith("todo ")) {
                // Parse todo command
                String description = command.substring(5);
                tasks[taskCount] = new Todo(description);
                taskCount++;

                System.out.println(delimiter);
                System.out.println("     Got it. I've added this task:");
                System.out.println("       " + tasks[taskCount - 1]);
                System.out.println("     Now you have " + taskCount + " tasks in the list.");
                System.out.println(delimiter);
            } else if (command.startsWith("deadline ")) {
                // Parse deadline command: deadline <description> /by <time>
                String remaining = command.substring(9);
                int byIndex = remaining.indexOf(" /by ");

                if (byIndex == -1) {
                    System.out.println(delimiter);
                    System.out.println("     Please use the format: deadline <description> /by <time>");
                    System.out.println(delimiter);
                } else {
                    String description = remaining.substring(0, byIndex);
                    String by = remaining.substring(byIndex + 5);
                    tasks[taskCount] = new Deadline(description, by);
                    taskCount++;

                    System.out.println(delimiter);
                    System.out.println("     Got it. I've added this task:");
                    System.out.println("       " + tasks[taskCount - 1]);
                    System.out.println("     Now you have " + taskCount + " tasks in the list.");
                    System.out.println(delimiter);
                }
            } else if (command.startsWith("event ")) {
                // Parse event command: event <description> /from <time> /to <time>
                String remaining = command.substring(6);
                int fromIndex = remaining.indexOf(" /from ");
                int toIndex = remaining.indexOf(" /to ");

                if (fromIndex == -1 || toIndex == -1) {
                    System.out.println(delimiter);
                    System.out.println("     Please use the format: event <description> /from <time> /to <time>");
                    System.out.println(delimiter);
                } else {
                    String description = remaining.substring(0, fromIndex);
                    String from = remaining.substring(fromIndex + 7, toIndex);
                    String to = remaining.substring(toIndex + 5);
                    tasks[taskCount] = new Event(description, from, to);
                    taskCount++;

                    System.out.println(delimiter);
                    System.out.println("     Got it. I've added this task:");
                    System.out.println("       " + tasks[taskCount - 1]);
                    System.out.println("     Now you have " + taskCount + " tasks in the list.");
                    System.out.println(delimiter);
                }
            } else {
                System.out.println(delimiter);
                System.out.println("     I don't understand that command.");
                System.out.println(delimiter);
            }
        }

        scanner.close();
    }
}
