import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

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
