package duke.command;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.function.Predicate;

import duke.ui.Ui;
import task.Task;
import task.TaskList;

/**
 * Command to list out tasks.
 */
public class CommandList extends Command {

    private final TaskList taskList;
    private final String args;

    /**
     * Constructor.
     *
     * @param taskList Task list to list
     * @param args Un-parsed list of filters
     */
    public CommandList(TaskList taskList, String args) {
        this.commandName = "list /name <name> /date DD/MM/YYYY";
        this.description = "Toggles completion of task";
        this.arguments = new String[]{
            "/name Optional argument to search for particular name",
            "/date Optional date argument in DAY/MONTH/YEAR, "
                    + "to search for tasks on a particular date"
        };

        this.taskList = taskList;
        this.args = args;
    }

    /**
     * Lists out tasks based on given filters.
     */
    @Override
    public String execute() {
        if (args == null) {
            // Display all if no filters
            ArrayList<Predicate<Task>> filter = new ArrayList<>();
            filter.add(task -> true);
            return taskList.displayList(filter);
        }

        // Extract modifiers and filter
        try {
            ArrayList<Predicate<Task>> filters = listStringToFilter(args);
            return taskList.displayList(filters);
        } catch (DateTimeParseException e) {
            return Ui.MESSAGE_INVALID_DATE;
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }

    /**
     * Gets arguments from a multi-argument string.
     *
     * @param stringToParse String to parse
     * @return Arraylist with all filters to use to display list
     * @throws DateTimeParseException Thrown if error in parsing dates
     * @throws IllegalArgumentException Thrown if an argument is in a wrong format
     */
    public static ArrayList<Predicate<Task>> listStringToFilter(String stringToParse)
            throws DateTimeParseException, IllegalArgumentException {

        // Separate individual commands
        String[] args = stringToParse.split(" /");

        ArrayList<Predicate<Task>> results = new ArrayList<>();

        for (String str : args) {

            // Ignore any empty strings
            if (str.equals("")) {
                continue;
            }

            // Ensure validity; has a command and an argument
            int index = str.indexOf(' ');
            if (index == -1) {
                throw new IllegalArgumentException(Ui.MESSAGE_INVALID_ARG);
            }

            // Get command and argument information
            String command = str.substring(0, index);
            String arg = str.substring(index).trim();

            switch (command) {
            case ("name"):
                results.add(task -> task.getDescription().contains(arg));
                break;
            case ("date"):
                LocalDate date = Command.getDate(arg);
                results.add(task -> task.isDate(date));
                break;
            default:
                throw new IllegalArgumentException(Ui.MESSAGE_INVALID_ARG);
            }
        }

        return results;
    }
}
