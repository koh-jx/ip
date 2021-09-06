package duke;

import duke.command.Command;

import duke.util.DukeParser;
import duke.util.Storage;
import task.TaskList;

/**
 * Main Duke class.
 */
public class Duke {
    private final DukeParser parser;

    /**
     * Constructor.
     * Instantiates a (saved) {@link task.TaskList} and a {@link DukeParser}.
     */
    protected Duke() {
        TaskList taskList = Storage.loadList();
        this.parser = new DukeParser(taskList);
    }

    /**
     * Get response from duke from the GUI.
     *
     * @param input String input from user
     */
    public String getResponse(String input) {
        Command cmd = parser.parseInput(input);
        return cmd.execute();
    }
}
