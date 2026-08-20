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
        System.out.println("Hello! I'm GUNNA.");
        System.out.println("What can I do for you?");
        System.out.println(delimiter);

        // Array to store tasks (max 100)
        String[] tasks = new String[100];
        int taskCount = 0;

        Scanner scanner = new Scanner(System.in);
        String command;

        while (true) {
            command = scanner.nextLine();

            if (command.equals("bye")) {
                System.out.println(delimiter);
                System.out.println("Bye. Hope to see you again soon!");
                System.out.println(delimiter);
                break;
            } else if (command.equals("list")) {
                System.out.println(delimiter);
                for (int i = 0; i < taskCount; i++) {
                    System.out.println(" " + (i + 1) + ". " + tasks[i]);
                }
                System.out.println(delimiter);
            } else {
                // Add task to array
                tasks[taskCount] = command;
                taskCount++;

                System.out.println(delimiter);
                System.out.println(" added: " + command);
                System.out.println(delimiter);
            }
        }

        scanner.close();
    }
}
