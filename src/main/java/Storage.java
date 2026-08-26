import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Handles saving and loading of tasks to/from the hard disk.
 * Tasks are saved in a pipe-separated format for easy parsing.
 */
public class Storage {
    private String filePath;

    /**
     * Creates a Storage instance with the specified file path.
     *
     * @param filePath The path to the data file relative to the project root.
     */
    public Storage(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Loads tasks from the data file.
     * Returns an empty list if the file doesn't exist or if there's an error.
     *
     * @return ArrayList of tasks loaded from the file.
     */
    public ArrayList<Task> loadTasks() {
        ArrayList<Task> tasks = new ArrayList<>();
        File file = new File(filePath);

        // If file doesn't exist, return empty list
        if (!file.exists()) {
            return tasks;
        }

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Task task = parseTask(line);
                if (task != null) {
                    tasks.add(task);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("     Error loading tasks: File not found.");
        } catch (Exception e) {
            System.out.println("     Error loading tasks: " + e.getMessage());
        }

        return tasks;
    }

    /**
     * Parses a line from the data file and creates the appropriate Task object.
     * Format: TYPE | STATUS | DESCRIPTION | [ADDITIONAL_FIELDS]
     *
     * @param line The line to parse.
     * @return The parsed Task object, or null if the line is invalid.
     */
    private Task parseTask(String line) {
        try {
            String[] parts = line.split(" \\| ");
            if (parts.length < 3) {
                return null;
            }

            String type = parts[0];
            boolean isDone = parts[1].equals("1");
            String description = parts[2];

            Task task = null;

            switch (type) {
            case "T":
                task = new Todo(description);
                break;
            case "D":
                if (parts.length >= 4) {
                    String by = parts[3];
                    task = new Deadline(description, by);
                }
                break;
            case "E":
                if (parts.length >= 5) {
                    String from = parts[3];
                    String to = parts[4];
                    task = new Event(description, from, to);
                }
                break;
            default:
                return null;
            }

            if (task != null && isDone) {
                task.markAsDone();
            }

            return task;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Saves the task list to disk.
     * Creates the data directory and file if they don't exist.
     *
     * @param tasks The list of tasks to save.
     */
    public void saveTasks(ArrayList<Task> tasks) {
        try {
            // Create data directory if it doesn't exist
            File file = new File(filePath);
            File parentDir = file.getParentFile();
            if (parentDir != null && !parentDir.exists()) {
                parentDir.mkdirs();
            }

            // Write tasks to file
            FileWriter writer = new FileWriter(filePath);
            for (Task task : tasks) {
                writer.write(task.toFileFormat() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("     Error saving tasks: " + e.getMessage());
        }
    }
}
