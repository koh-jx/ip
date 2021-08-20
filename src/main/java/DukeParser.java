import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DukeParser {

    /**
     * Task list that this Parser object edits
     */
    final TaskList taskList;

    /**
     * Patterns for the Parser to look out for in the input
     */
    Pattern donePattern = Pattern.compile("done (\\d+)", Pattern.CASE_INSENSITIVE);
    Pattern deletePattern = Pattern.compile("delete (\\d+)", Pattern.CASE_INSENSITIVE);
    Pattern todoPattern = Pattern.compile("todo (.+)", Pattern.CASE_INSENSITIVE);
    Pattern deadlinePattern = Pattern.compile("deadline (.+) /by (\\d{1,2}/\\d{1,2}/\\d{4}+)( \\d{4}+)?", Pattern.CASE_INSENSITIVE);
    Pattern eventPattern = Pattern.compile("event (.+) /at (\\d{1,2}/\\d{1,2}/\\d{4}+)( \\d{4}+)?", Pattern.CASE_INSENSITIVE);
    Pattern findPattern = Pattern.compile("find (\\d{1,2}/\\d{1,2}/\\d{4}+)( \\d{4}+)?", Pattern.CASE_INSENSITIVE);

    /**Constructor
     *
     * @param tasks Task List to edit using this Parser object
     */
    public DukeParser(TaskList tasks) {
        this.taskList = tasks;
    }

    /** Parses Input for any list related functions, and carries it out
     *
     * @param input String input from the Listener given by the User
     */
    public void parseInput(String input) {
        Matcher checkDone = donePattern.matcher(input);
        Matcher checkDelete = deletePattern.matcher(input);
        Matcher checkTodo = todoPattern.matcher(input);
        Matcher checkDeadline = deadlinePattern.matcher(input);
        Matcher checkEvent = eventPattern.matcher(input);
        Matcher checkFind = findPattern.matcher(input);

        if (input.equals("list")) {
            // Display items
            taskList.displayList(task -> true);

        } else if (checkDone.matches()) {
            // Toggles completion of a task
            taskList.toggleDone(Integer.parseInt(checkDone.group(1)));

        } else if (checkDelete.matches()) {
            // Remove a task from list
            taskList.delete(Integer.parseInt(checkDelete.group(1)));

        } else if (checkTodo.matches()) {
            // Add a to-do task to list
            taskList.add(checkTodo, TaskType.TODO);

        } else if (checkDeadline.matches()) {
            // Add a deadline to list
            taskList.add(checkDeadline, TaskType.DEADLINE);

        } else if (checkEvent.matches()) {
            // Add an event to list
            taskList.add(checkEvent, TaskType.EVENT);

        } else if (checkFind.matches()) {
            //Display list of dates
            try {
                taskList.displayList(task -> task.isDate(TaskType.getDate(checkFind.group(1))));
            } catch (DateTimeParseException e) {
                System.out.println("Please enter a valid date! :(");
            }

        } else {
            // Invalid command
            System.out.println(Ui.OUTPUT_DISPLAY + "☹ eeeeeee~dameda!! " + input + " isn't a valid command!");
        }
    }
}
