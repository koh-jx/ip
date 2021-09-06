package duke.command;

import duke.ui.Ui;

/**
 * Command to exit program
 */
public class CommandExit extends Command {

    /**
     * Constructor
     */
    public CommandExit() {
        this.commandName = "gubbai";
        this.description = "Exits the program";
        this.arguments = new String[]{};
    }

    /**
     * This class signals to Duke that it should terminate the program
     */
    @Override
    public String execute() {
        return Ui.goodByeMessage();
    }
}
