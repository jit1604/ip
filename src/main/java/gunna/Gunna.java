package gunna;

import gunna.command.Command;
import java.io.File;

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
     * Generates a response for the user's input.
     * Used by the GUI to get chatbot responses.
     *
     * @param input The user's input command.
     * @return The chatbot's response.
     */
    public String getResponse(String input) {
        try {
            Command c = Parser.parse(input);
            return c.execute(tasks, ui, storage);
        } catch (DukeException e) {
            return e.getMessage();
        }
    }

    /**
     * Returns the welcome message for the application.
     *
     * @return The welcome message.
     */
    public String getWelcomeMessage() {
        return "Hello! I'm GUNNA.\nWhat can I do for you?";
    }

    /**
     * Runs the main command loop of the application.
     * Displays welcome message, processes commands, and handles user interaction.
     */
    public void run() {
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                Command c = Parser.parse(fullCommand);
                String response = c.execute(tasks, ui, storage);
                isExit = c.isExit();
            } catch (DukeException e) {
                ui.showError(e.getMessage());
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
