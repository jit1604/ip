/**
 * Handles parsing of user commands.
 * Extracts arguments and parameters from command strings.
 */
public class Parser {

    /**
     * Extracts the argument after a command word.
     * For example, "mark 5" with commandWord "mark" returns " 5".
     * Note: Leading/trailing spaces are preserved for parsing purposes.
     *
     * @param command The full command string.
     * @param commandWord The command word (e.g., "mark", "todo").
     * @return The argument string after the command word (may have leading spaces).
     */
    public static String getArgument(String command, String commandWord) {
        int prefixLength = commandWord.length();
        if (command.length() > prefixLength) {
            return command.substring(prefixLength);
        }
        return "";
    }

    /**
     * Parses a task number from a command argument.
     * Converts from 1-based user input to 0-based array index.
     *
     * @param argument The argument containing the task number.
     * @return The task index (0-based).
     * @throws NumberFormatException if the argument is not a valid number.
     * @throws IndexOutOfBoundsException if the task number is less than 1.
     */
    public static int parseTaskNumber(String argument) throws NumberFormatException {
        int taskNumber = Integer.parseInt(argument.trim());
        if (taskNumber < 1) {
            throw new IndexOutOfBoundsException("Task number must be at least 1");
        }
        return taskNumber - 1;  // Convert to 0-based index
    }

    /**
     * Parses a deadline command to extract description and deadline time.
     * Format: deadline <description> /by <time>
     *
     * @param command The full deadline command.
     * @return A String array [description, by], or null if format is invalid.
     */
    public static String[] parseDeadline(String command) {
        String remaining = getArgument(command, "deadline");

        // Find the /by delimiter
        int byIndex = remaining.indexOf(" /by ");
        boolean hasTrailingSpace = true;

        // Also check for /by at the end without trailing space
        if (byIndex == -1 && remaining.endsWith(" /by")) {
            byIndex = remaining.lastIndexOf(" /by");
            hasTrailingSpace = false;
        }

        // If no /by found, return null to indicate invalid format
        if (byIndex == -1) {
            return null;
        }

        String description = remaining.substring(0, byIndex).trim();
        String by;
        if (hasTrailingSpace) {
            by = remaining.substring(byIndex + 5).trim();  // " /by " is 5 chars
        } else {
            by = remaining.substring(byIndex + 4).trim();  // " /by" is 4 chars
        }

        return new String[]{description, by};
    }

    /**
     * Parses an event command to extract description, from time, and to time.
     * Format: event <description> /from <time> /to <time>
     *
     * @param command The full event command.
     * @return A String array [description, from, to], or null if format is invalid.
     */
    public static String[] parseEvent(String command) {
        String remaining = getArgument(command, "event");

        int fromIndex = remaining.indexOf(" /from ");
        int toIndex = remaining.indexOf(" /to ");

        // Check for /to without trailing space at the end
        if (toIndex == -1 && remaining.contains(" /to")) {
            toIndex = remaining.lastIndexOf(" /to");
        }

        // Validate that both delimiters exist and are in the correct order
        if (fromIndex == -1 || toIndex == -1 || fromIndex + 7 > toIndex) {
            return null;
        }

        String description = remaining.substring(0, fromIndex).trim();
        String from = remaining.substring(fromIndex + 7, toIndex).trim();  // " /from " is 7 chars
        String to;

        // Handle both " /to " and " /to" (at end without trailing space)
        if (remaining.indexOf(" /to ") != -1) {
            to = remaining.substring(toIndex + 5).trim();  // " /to " is 5 chars
        } else {
            to = remaining.substring(toIndex + 4).trim();  // " /to" is 4 chars
        }

        return new String[]{description, from, to};
    }

    /**
     * Extracts the description from a todo command.
     * Format: todo <description>
     *
     * @param command The full todo command.
     * @return The todo description (trimmed).
     */
    public static String parseTodo(String command) {
        return getArgument(command, "todo").trim();
    }

    /**
     * Extracts the date string from an "on" command.
     * Format: on <date>
     *
     * @param command The full on command.
     * @return The date string (trimmed).
     */
    public static String parseDate(String command) {
        return getArgument(command, "on").trim();
    }
}
