import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Optional;

public class TaskEvent extends Task {
    private final LocalDate at;
    private final String time;

    public TaskEvent(String description, LocalDate date, String time, boolean done) {
        super(description, done);
        this.at = date;
        this.time = Optional.ofNullable(time)
                .map(String::strip)
                .orElse("");
    }

    /**
     * String representation of Event
     *
     * @return event display
     */
    @Override
    public String toString() {
        String checkBox = done
                ? "[X] "
                : "[ ] ";
        return "[E]" + checkBox + description
                + " (at: " + at + (!time.equals("") ? " "
                + time : "") + ")";
    }

    @Override
    String saveString() {
        return "E" + '\t'
                + (this.done ? "1" : "0") + '\t'
                + this.description + '\t'
                + this.at + '\t'
                + this.time;
    }

    @Override
    boolean isDate(LocalDate date) throws DateTimeParseException {
        return date.equals(at);
    }


}
