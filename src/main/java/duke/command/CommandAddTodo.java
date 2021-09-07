package duke.command;

import task.TaskList;
import task.TaskTodo;

/**
 * Command to add a to-do.
 */
public class CommandAddTodo extends Command {

    private final TaskList taskList;
    private final String desc;

    /**
     * Constructor.
     *
     * @param taskList Task list to add to
     * @param desc Description of task
     */
    public CommandAddTodo(TaskList taskList, String desc) {
        this.commandName = "todo <string>";
        this.description = "Creates a to-do task";
        this.arguments = new String[]{
            "<string> Description of to-do"
        };

        this.taskList = taskList;
        this.desc = desc;
    }

    /**
     * Add To-do to task list if valid.
     */
    @Override
    public String execute() {
        return taskList.add(new TaskTodo(desc, false));
    }
}
