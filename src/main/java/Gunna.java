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
            } else if (command.equals("mark") || command.startsWith("mark ")) {
                // Parse task number from "mark N"
                String numStr = command.length() > 5 ? command.substring(5).trim() : "";

                if (numStr.isEmpty()) {
                    System.out.println(delimiter);
                    System.out.println("     OOPS!!! Please specify which task to mark.");
                    System.out.println("     Usage: mark <task number>");
                    System.out.println(delimiter);
                } else {
                    try {
                        int taskNumber = Integer.parseInt(numStr);
                        int taskIndex = taskNumber - 1;

                        if (taskIndex < 0 || taskIndex >= taskCount) {
                            System.out.println(delimiter);
                            System.out.println("     OOPS!!! Task number " + taskNumber + " doesn't exist.");
                            System.out.println("     You have " + taskCount + " task(s) in your list.");
                            System.out.println(delimiter);
                        } else {
                            tasks[taskIndex].markAsDone();
                            System.out.println(delimiter);
                            System.out.println("     Nice! I've marked this task as done:");
                            System.out.println("       " + tasks[taskIndex]);
                            System.out.println(delimiter);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println(delimiter);
                        System.out.println("     OOPS!!! Task number must be a valid number.");
                        System.out.println(delimiter);
                    }
                }
            } else if (command.equals("unmark") || command.startsWith("unmark ")) {
                // Parse task number from "unmark N"
                String numStr = command.length() > 7 ? command.substring(7).trim() : "";

                if (numStr.isEmpty()) {
                    System.out.println(delimiter);
                    System.out.println("     OOPS!!! Please specify which task to unmark.");
                    System.out.println("     Usage: unmark <task number>");
                    System.out.println(delimiter);
                } else {
                    try {
                        int taskNumber = Integer.parseInt(numStr);
                        int taskIndex = taskNumber - 1;

                        if (taskIndex < 0 || taskIndex >= taskCount) {
                            System.out.println(delimiter);
                            System.out.println("     OOPS!!! Task number " + taskNumber + " doesn't exist.");
                            System.out.println("     You have " + taskCount + " task(s) in your list.");
                            System.out.println(delimiter);
                        } else {
                            tasks[taskIndex].markAsNotDone();
                            System.out.println(delimiter);
                            System.out.println("     OK, I've marked this task as not done yet:");
                            System.out.println("       " + tasks[taskIndex]);
                            System.out.println(delimiter);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println(delimiter);
                        System.out.println("     OOPS!!! Task number must be a valid number.");
                        System.out.println(delimiter);
                    }
                }
            } else if (command.equals("todo") || command.startsWith("todo ")) {
                // Parse todo command
                String description = command.length() > 5 ? command.substring(5).trim() : "";

                if (description.isEmpty()) {
                    System.out.println(delimiter);
                    System.out.println("     OOPS!!! The description of a todo cannot be empty.");
                    System.out.println(delimiter);
                } else {
                    tasks[taskCount] = new Todo(description);
                    taskCount++;

                    System.out.println(delimiter);
                    System.out.println("     Got it. I've added this task:");
                    System.out.println("       " + tasks[taskCount - 1]);
                    System.out.println("     Now you have " + taskCount + " tasks in the list.");
                    System.out.println(delimiter);
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
                    System.out.println(delimiter);
                    System.out.println("     OOPS!!! Please use the format: deadline <description> /by <time>");
                    System.out.println(delimiter);
                } else {
                    String description = remaining.substring(0, byIndex).trim();
                    String by;
                    if (hasTrailingSpace) {
                        by = remaining.substring(byIndex + 5).trim();
                    } else {
                        by = remaining.substring(byIndex + 4).trim();  // " /by" is 4 chars
                    }

                    if (description.isEmpty()) {
                        System.out.println(delimiter);
                        System.out.println("     OOPS!!! The description of a deadline cannot be empty.");
                        System.out.println(delimiter);
                    } else if (by.isEmpty()) {
                        System.out.println(delimiter);
                        System.out.println("     OOPS!!! The deadline time cannot be empty.");
                        System.out.println(delimiter);
                    } else {
                        tasks[taskCount] = new Deadline(description, by);
                        taskCount++;

                        System.out.println(delimiter);
                        System.out.println("     Got it. I've added this task:");
                        System.out.println("       " + tasks[taskCount - 1]);
                        System.out.println("     Now you have " + taskCount + " tasks in the list.");
                        System.out.println(delimiter);
                    }
                }
            } else if (command.equals("event") || command.startsWith("event ")) {
                // Parse event command: event <description> /from <time> /to <time>
                String remaining = command.length() > 6 ? command.substring(6) : "";
                int fromIndex = remaining.indexOf(" /from ");
                int toIndex = remaining.indexOf(" /to ");

                if (fromIndex == -1 || toIndex == -1) {
                    System.out.println(delimiter);
                    System.out.println("     OOPS!!! Please use the format: event <description> /from <time> /to <time>");
                    System.out.println(delimiter);
                } else {
                    String description = remaining.substring(0, fromIndex).trim();
                    String from = remaining.substring(fromIndex + 7, toIndex).trim();
                    String to = remaining.substring(toIndex + 5).trim();

                    if (description.isEmpty()) {
                        System.out.println(delimiter);
                        System.out.println("     OOPS!!! The description of an event cannot be empty.");
                        System.out.println(delimiter);
                    } else if (from.isEmpty() || to.isEmpty()) {
                        System.out.println(delimiter);
                        System.out.println("     OOPS!!! The event time cannot be empty.");
                        System.out.println(delimiter);
                    } else {
                        tasks[taskCount] = new Event(description, from, to);
                        taskCount++;

                        System.out.println(delimiter);
                        System.out.println("     Got it. I've added this task:");
                        System.out.println("       " + tasks[taskCount - 1]);
                        System.out.println("     Now you have " + taskCount + " tasks in the list.");
                        System.out.println(delimiter);
                    }
                }
            } else {
                System.out.println(delimiter);
                System.out.println("     OOPS!!! I'm sorry, but I don't know what that means :-(");
                System.out.println(delimiter);
            }
        }

        scanner.close();
    }
}
