package duke.ui;

import task.Task;

/**
 * Constants and variables used for output.
 * Can be error messages or normal output messages that Duke should send to the user.
 */
public class Ui {
    public static final String OUTPUT_DISPLAY = "  ->   ";
    public static final String OUTPUT_SPACES = "      ";

    public static final String MESSAGE_FILE_NOT_FOUND = "Save file not found, creating new file";
    public static final String MESSAGE_INVALID_ARG = "Invalid argument found! :(";
    public static final String MESSAGE_INVALID_DATE = "Please enter a valid date! :(";
    public static final String MESSAGE_FILE_NOT_READ = "File not read.";
    public static final String MESSAGE_NOTHING_TO_DISPLAY = "There is nothing to display! :angery:";

    /**
     * Message to display when Duke wants to tell user that they input an invalid index in
     * a command.
     *
     * @param index Index to display
     * @return String to display
     */
    public static String messageNoTaskAtIndex(int index) {
        return "There's no task at index " + index + "!!";
    }

    /**
     * Message to display when the user removes any task successfully.
     *
     * @param removedTask Task removed
     * @param sizeString String to display new size of tasklist
     * @return Corresponding message string
     */
    public static String messageRemoveTask(Task removedTask, String sizeString) {
        return "Noted. Duke-san removed this task:"
                + removedTask
                + sizeString;
    }

    /**
     * Message to display when the user adds any task successfully.
     *
     * @param addedTask Task added
     * @param sizeString String to display new size of tasklist
     * @return Corresponding message string
     */
    public static String messageAddTask(Task addedTask, String sizeString) {
        return "Got it. I've added this task:\n"
                + Ui.OUTPUT_SPACES
                + addedTask + '\n'
                + sizeString;
    }

    /**
     * Message to display when getting size of list.
     *
     * @param size Size of list
     * @return Corresponding message string
     */
    public static String messageListSize(int size) {
        return size == 1
                ? "There is 1 task in your list"
                : "There are " + size + " tasks in your list";
    }

    /**
     * Welcome text to display when Duke starts up.
     */
    public static String introMessage() {
        String welcomeText = "    When the Duke is sus";

        String mascot = "\n"
                + "       `:ossys/`              \n"
                + "     .yh+-` ``-o/             \n"
                + "     hh         .o.           \n"
                + "     Ns  -+sssyyo:y:          \n"
                + "    `Ms.o/-/+ossym+do         \n"
                + "    -M+s+::/+osssdy.dh.       \n"
                + "    +M:dsoooossshm- `dm-      \n"
                + "    dM./ddhyyhhdy-   `dN-     \n"
                + "   .Nh  `-/+o+:.      .mh     \n"
                + "   +M:                 -No    \n"
                + "   mm                   +M:   \n"
                + "  -Mo                    dd`  \n"
                + "  sM.                    -M+  \n"
                + " `mh                      hm  \n"
                + " :M/                      :M- \n"
                + " oM`                      `Mo \n"
                + " hh                        Ny \n"
                + "`No       ./syyys+-`       Nh \n"
                + "-M:    `/hmy/:--:+dh:      Nh \n"
                + ":M-  `ody:`        :my`   .Ms \n"
                + "-My/ydo.            `ym:  oM- \n"
                + " :++-                 /mddd: ";

        return welcomeText + '\n'
                + mascot + "\n\n"
                + "         Hello! I'm Duke!\n"
                + "      What can I do for you?\n";
    }

    /**
     * Text to display when user exits (via gubbai command).
     */
    public static String goodByeMessage() {
        return "kimi no unmei no hito wa boku jyanai";
    }
}
