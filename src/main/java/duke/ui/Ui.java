package duke.ui;

/**
 * Constants and variables used for output
 */
public class Ui {
    public static final String LINE = "____________________________________________________________\n";
    public static final String OUTPUT_DISPLAY = "  ->   ";
    public static final String OUTPUT_SPACES = "      ";

    /**
     * Welcome text to display when duke.Duke starts up
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
     * Text to display when user exits (via gubbai command)
     */
    public static String goodByeMessage() {
        return "kimi no unmei no hito wa boku jyanai";
    }
}
